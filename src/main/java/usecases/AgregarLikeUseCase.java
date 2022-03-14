package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.reseña.Resenna;
import domain.reseña.commands.AgregarLike;

public class AgregarLikeUseCase extends UseCase<RequestCommand<AgregarLike>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarLike> input) {
        var command = input.getCommand();

        var resenna = Resenna.from(command.getResennaId(), retrieveEvents());
        resenna.agregarLike();

        emit().onResponse(new ResponseEvents(resenna.getUncommittedChanges()));
    }

}
