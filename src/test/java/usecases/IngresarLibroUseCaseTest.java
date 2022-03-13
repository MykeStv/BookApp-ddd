package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.libro.commands.IngresarLibro;
import domain.libro.entity.values.AutorId;
import domain.libro.entity.values.Nombre;
import domain.libro.entity.values.PaginaTotal;
import domain.libro.events.LibroIngresado;
import domain.libro.values.Contenido;
import domain.libro.values.Descripcion;
import domain.libro.values.LibroId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngresarLibroUseCaseTest {

    @Test
    void ingresarLibro() {
        System.out.println("Test: Ingresar libro");
        //ARRANGE
        LibroId libroId = LibroId.of("9781306768481");
        //"Contenido" is the text of the book. so, it's the book itself.
        Contenido contenido = new Contenido("Evil is Evil. Lesser, greater, middling… Makes no difference. The degree is arbitary. The definition’s blurred. If I’m to choose between one evil and another… I’d rather not choose at all.");
        AutorId autorId = new AutorId();
        Nombre nombre = new Nombre("Andrzej Sapkowski"); //Think this one is not necessary
        PaginaTotal paginas = new PaginaTotal(320); //todo: improve this
        Descripcion descripcion = new Descripcion("Book number 1 of the sage of the witcher Geralt of Rivia", 25, paginas);

        var command = new IngresarLibro(libroId, contenido, autorId, nombre, descripcion);
        var usecase = new IngresarLibroUseCase();

        //ACT
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var event = (LibroIngresado) events.get(0);
        Assertions.assertEquals("bookapp.libro.libroingresado", event.type);
        Assertions.assertEquals("9781306768481", event.aggregateRootId()); //Compares the id of the book
        Assertions.assertEquals(autorId.value(), event.getAutorId().value());
        Assertions.assertEquals(paginas.value(), event.getDescripcion().value().paginas().value());

    }

}