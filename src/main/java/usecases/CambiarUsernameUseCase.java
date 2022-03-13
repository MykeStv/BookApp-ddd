package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.usuario.Usuario;
import domain.usuario.commands.CambiarUsername;

public class CambiarUsernameUseCase extends UseCase<RequestCommand<CambiarUsername>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarUsername> input) {

        var command = input.getCommand();

        var usuario = Usuario.from(command.getUsuarioId(), retrieveEvents());
        usuario.cambiarUsername(command.getUsername());

        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));

    }
}
