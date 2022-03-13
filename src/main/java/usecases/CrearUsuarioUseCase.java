package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.usuario.Usuario;
import domain.usuario.commands.CrearUsuario;

public class CrearUsuarioUseCase extends UseCase<RequestCommand<CrearUsuario>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearUsuario> input) {
        //Get the commando for the request
        var command = input.getCommand();

        var usuario = new Usuario(command.getUsuarioId(), command.getUsername(),
                command.getNombre(), command.getEmail());

        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
