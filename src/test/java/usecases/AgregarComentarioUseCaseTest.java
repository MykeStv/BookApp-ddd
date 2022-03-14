package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.reseña.commands.AgregarComentario;
import domain.reseña.entity.values.ComentarioId;
import domain.reseña.entity.values.Comment;
import domain.reseña.entity.values.User;
import domain.reseña.events.ComentarioAgregado;
import domain.reseña.events.ResennaCreada;
import domain.reseña.values.Critica;
import domain.reseña.values.ResennaId;
import domain.usuario.values.UsuarioId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AgregarComentarioUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarComentario() {
        System.out.println("Test: Agregar comentario");

        //ARRANGE
        ResennaId resennaId = ResennaId.of("rrzzxx123");
        ComentarioId comentarioId = new ComentarioId();
        Comment comment = new Comment("Excelente libro");
        User user = new User("Arthur");

        var command = new AgregarComentario(resennaId,comentarioId, comment, user);
        var usecase = new AgregarComentarioUseCase();

        Mockito.when(repository.getEventsBy(resennaId.value())).thenReturn(EventHistory());
        usecase.addRepository(repository);

        //ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(resennaId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var event = (ComentarioAgregado) events.get(0);

        Assertions.assertEquals("bookapp.resenna.comentarioagregado", event.type);
        Assertions.assertEquals(resennaId.value(), event.aggregateRootId());
        Assertions.assertEquals(comentarioId.value(), event.getComentarioId().value());
        Assertions.assertEquals(comment.value(), event.getComment().value());
        Assertions.assertEquals("Arthur", event.getUser().value());
        
    }

    private List<DomainEvent> EventHistory() {

        return List.of(
                new ResennaCreada(
                        new Critica("This is a critic for the book The way of kings"),
                        UsuarioId.of("xxx123xxx")
                ),
                new ComentarioAgregado(ComentarioId.of("1"), new Comment("nice review"), new User("Cassandra")),
                new ComentarioAgregado(ComentarioId.of("2"), new Comment("As you said, life before death"), new User("Absalon"))
        );
    }

}