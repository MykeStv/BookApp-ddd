package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.reseña.Resenna;
import domain.reseña.commands.CrearResenna;

public class CrearResennaUseCase extends UseCase<RequestCommand<CrearResenna>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearResenna> input) {
        var command = input.getCommand();

        var resenna = new Resenna(command.getResennaId(), command.getCritica(), command.getUsuarioId());

        emit().onResponse(new ResponseEvents(resenna.getUncommittedChanges()));
    }
}
