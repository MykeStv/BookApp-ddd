package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.reseña.Resenna;
import domain.reseña.commands.EditarResenna;

public class EditarResennaUseCase extends UseCase<RequestCommand<EditarResenna>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<EditarResenna> input) {
        var command = input.getCommand();

        var resenna = Resenna.from(command.getResennaId(), retrieveEvents());
        resenna.editarResenna(command.getCritica());

        emit().onResponse(new ResponseEvents(resenna.getUncommittedChanges()));

    }
}
