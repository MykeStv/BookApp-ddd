package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.libro.Libro;
import domain.libro.commands.AdicionarResenna;
import domain.reseña.Resenna;

public class AdicionarResennaUseCase extends UseCase<RequestCommand<AdicionarResenna>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AdicionarResenna> input) {
        var command = input.getCommand();

        var libro = Libro.from(command.getLibroId(), retrieveEvents());
        libro.adicionarReseña(command.getResennaId());

        emit().onResponse(new ResponseEvents(libro.getUncommittedChanges()));
    }

}
