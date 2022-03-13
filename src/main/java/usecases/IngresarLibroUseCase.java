package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.libro.Libro;
import domain.libro.commands.IngresarLibro;

public class IngresarLibroUseCase extends UseCase<RequestCommand<IngresarLibro>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<IngresarLibro> input) {
        //Get the command from the request
        var command = input.getCommand();

        var libro = new Libro(command.getLibroId(), command.getContenido(), command.getAutorId(),
                command.getNombre(), command.getDescripcion());

        //Emit a response through an event
        emit().onResponse(new ResponseEvents(libro.getUncommittedChanges()));
    }
}
