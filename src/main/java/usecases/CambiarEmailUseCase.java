package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.usuario.Usuario;
import domain.usuario.commands.CambiarEmail;

public class CambiarEmailUseCase extends UseCase<RequestCommand<CambiarEmail>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarEmail> input) {
            var command = input.getCommand();

            var usuario = Usuario.from(command.getUsuarioId(), retrieveEvents());
            usuario.cambiarEmail(command.getEmail());

            emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
