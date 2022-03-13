package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.libro.commands.ComenzarLibro;
import domain.libro.entity.Progreso;
import domain.libro.entity.values.AutorId;
import domain.libro.entity.values.Nombre;
import domain.libro.entity.values.PaginaTotal;
import domain.libro.entity.values.ProgresoId;
import domain.libro.events.LibroComenzado;
import domain.libro.events.LibroIngresado;
import domain.libro.values.Contenido;
import domain.libro.values.Descripcion;
import domain.libro.values.LibroId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ComenzarLibroUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void comenzarLibro() {
        System.out.println("Test: Comenzar libro");
        //ARRANGE
        LibroId libroId = LibroId.of("9781429992800");
        ProgresoId progresoId = new ProgresoId();

        var command = new ComenzarLibro(libroId, progresoId);
        var usecase = new ComenzarLibroUseCase();

        Mockito.when(repository.getEventsBy("9781429992800")).thenReturn(history());
        usecase.addRepository(repository);

        //ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(libroId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var event = (LibroComenzado) events.get(0);
        Assertions.assertEquals("bookapp.libro.librocomenzado", event.type);
        Assertions.assertEquals(libroId.value(), event.aggregateRootId());
        Assertions.assertEquals(progresoId.value(), event.getProgresoId().value());

        //Assertions.assertEquals();
    }

    private List<DomainEvent> history() {
        Contenido contenido = new Contenido("A man’s emotions are what define him, control is the hallmark of true strength. To lack feeling is to be dead, but to act on every feeling is to be a child.");
        AutorId autorId = new AutorId();
        Nombre nombreAutor = new Nombre("Brandon Sanderson");
        Descripcion descripcion = new Descripcion("Book 1 Stormlight Archive", 75, new PaginaTotal(1007));

        return List.of(
                new LibroIngresado(
                        contenido,
                        autorId,
                        nombreAutor,
                        descripcion)
        );
    }


}