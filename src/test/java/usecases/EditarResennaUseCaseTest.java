package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.reseña.commands.EditarResenna;
import domain.reseña.events.ResennaCreada;
import domain.reseña.events.ResennaEditada;
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

@ExtendWith(MockitoExtension.class)
class EditarResennaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void editarResenna() {
        System.out.println("Test: Editar reseña");

        //ARRANGE
        ResennaId resennaId = ResennaId.of("rrzzxx123");
        Critica critica = new Critica("Life before death. Strength before weakness. Journey before destination.");

        var command = new EditarResenna(resennaId, critica);
        var usecase = new EditarResennaUseCase();

        Mockito.when(repository.getEventsBy(resennaId.value())).thenReturn(historyEvents());
        usecase.addRepository(repository);

        //ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(resennaId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var event = (ResennaEditada) events.get(0);

        Assertions.assertEquals("bookapp.resenna.resennaeditada", event.type);
        Assertions.assertEquals(resennaId.value(), event.aggregateRootId());
        Assertions.assertEquals(critica.value(), event.getCritica().value());

    }

    private List<DomainEvent> historyEvents() {

        return List.of(
                new ResennaCreada(
                        new Critica("This is a critic for the book The way of kings"),
                        UsuarioId.of("xxx123xxx")
                )
        );
    }

}