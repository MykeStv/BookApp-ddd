package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.reseña.Resenna;
import domain.reseña.commands.AgregarLike;
import domain.reseña.events.LikeAgregado;
import domain.reseña.events.ResennaCreada;
import domain.reseña.values.Critica;
import domain.reseña.values.Like;
import domain.reseña.values.ResennaId;
import domain.usuario.Usuario;
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
class AgregarLikeUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarLike() {
        System.out.println("Test: Agregar like o likear");

        //ARRANGE
        ResennaId resennaId = ResennaId.of("rrzzxx123");

        var command = new AgregarLike(resennaId);
        var usecase = new AgregarLikeUseCase();

        Mockito.when(repository.getEventsBy(resennaId.value())).thenReturn(EventHistory());
        usecase.addRepository(repository);

        //ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(resennaId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var event = (LikeAgregado) events.get(0);

        Assertions.assertEquals("bookapp.resenna.likeagregado", event.type);
        Assertions.assertEquals(resennaId.value(), event.aggregateRootId());
        Assertions.assertEquals(4, event.getLike().value());

        System.out.println(event.getLike().value());
    }

    private List<DomainEvent> EventHistory() {

        return List.of(
                new ResennaCreada(
                        new Critica("This is a critic for the book The way of kings"),
                        UsuarioId.of("xxx123xxx")
                ),
                new LikeAgregado(new Like(1)),
                new LikeAgregado(new Like(2)),
                new LikeAgregado(new Like(3))
        );
    }

}