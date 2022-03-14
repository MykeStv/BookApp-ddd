package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.reseña.Resenna;
import domain.reseña.commands.RemoverLike;

public class RemoveLikeUseCase extends UseCase<RequestCommand<RemoverLike>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<RemoverLike> input) {
        var command = input.getCommand();

        var resenna = Resenna.from(command.getResennaId(), retrieveEvents());
        resenna.removerLike();

        emit().onResponse(new ResponseEvents(resenna.getUncommittedChanges()));
    }
}
