package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.reseña.Resenna;
import domain.reseña.commands.AgregarComentario;

public class AgregarComentarioUseCase extends UseCase<RequestCommand<AgregarComentario>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarComentario> input) {
            var command = input.getCommand();

            var resenna = Resenna.from(command.getResennaId(), retrieveEvents());
            resenna.agregarComentario(
                    command.getComentarioId(),
                    command.getComment(),
                    command.getUser()
            );

            emit().onResponse(new ResponseEvents(resenna.getUncommittedChanges()));
    }
}
