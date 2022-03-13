package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.libro.Libro;
import domain.libro.commands.ComenzarLibro;

public class ComenzarLibroUseCase extends UseCase<RequestCommand<ComenzarLibro>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ComenzarLibro> input) {
        //Get the command from the request
        var command = input.getCommand();

        //Get the aggregate
        var libro = Libro.from(command.getLibroId(), retrieveEvents());
        //now, call the command or method
        libro.comenzarLibro(command.getProgresoId());

        emit().onResponse(new ResponseEvents(libro.getUncommittedChanges()));


    }
}
