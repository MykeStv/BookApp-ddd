package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.libro.commands.AdicionarResenna;
import domain.libro.entity.values.AutorId;
import domain.libro.entity.values.Nombre;
import domain.libro.entity.values.PaginaTotal;
import domain.libro.events.LibroIngresado;
import domain.libro.events.ResennaAdicionada;
import domain.libro.values.Contenido;
import domain.libro.values.Descripcion;
import domain.libro.values.LibroId;
import domain.reseña.values.ResennaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AdicionarResennaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void adicionarResenna() {
        System.out.println("Test: Adicionar reseña a libro");

        //ARRANGE
        LibroId libroId = LibroId.of("9781429992800");
        ResennaId resennaId = ResennaId.of("rrzzxx123");

        var command = new AdicionarResenna(libroId, resennaId);
        var usecase = new AdicionarResennaUseCase();

        Mockito.when(repository.getEventsBy(libroId.value())).thenReturn(EventHistory());
        usecase.addRepository(repository);

        //ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(libroId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var event = (ResennaAdicionada) events.get(0);

        Assertions.assertEquals("bookapp.libro.reseñaadicionada", event.type);
        Assertions.assertEquals(libroId.value(), event.aggregateRootId());
        Assertions.assertEquals(resennaId.value(), event.getResennaId().value());


    }

    private List<DomainEvent> EventHistory() {

        return List.of(
                new LibroIngresado(
                        new Contenido("A man’s emotions are what define him, control is the hallmark of true strength. To lack feeling is to be dead, but to act on every feeling is to be a child."),
                        AutorId.of("msrb12345"),
                        new Nombre("Brandon Sanderson"),
                        new Descripcion("Book 1 Stormlight Archive", 75, new PaginaTotal(1007))
                ),
                new ResennaAdicionada(ResennaId.of("rxp0001")),
                new ResennaAdicionada(ResennaId.of("rxp0002")),
                new ResennaAdicionada(ResennaId.of("rxp0003"))
        );
    }

}