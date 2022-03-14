package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.reseña.commands.AgregarLike;
import domain.reseña.commands.RemoverLike;
import domain.reseña.events.LikeAgregado;
import domain.reseña.events.LikeRemovido;
import domain.reseña.events.ResennaCreada;
import domain.reseña.values.Critica;
import domain.reseña.values.Like;
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
class RemoveLikeUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void removerLike() {
        System.out.println("Test: Agregar like o likear");

        //ARRANGE
        ResennaId resennaId = ResennaId.of("rrzzxx123");

        var command = new RemoverLike(resennaId);
        var usecase = new RemoveLikeUseCase();

        Mockito.when(repository.getEventsBy(resennaId.value())).thenReturn(EventHistory());
        usecase.addRepository(repository);

        //ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(resennaId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var event = (LikeRemovido) events.get(0);

        Assertions.assertEquals("bookapp.resenna.likeremovido", event.type);
        Assertions.assertEquals(resennaId.value(), event.aggregateRootId());
        Assertions.assertEquals(5, event.getLike().value());
        System.out.println(event.getLike().value());
    }

    private List<DomainEvent> EventHistory() {

        return List.of(
                new ResennaCreada(
                        new Critica("This is a critic for the book Words of Radiance"),
                        UsuarioId.of("xxx456xxx")
                ),
                new LikeAgregado(new Like(1)),
                new LikeAgregado(new Like(2)),
                new LikeAgregado(new Like(7)),
                new LikeRemovido(new Like(6))
        );
    }


}