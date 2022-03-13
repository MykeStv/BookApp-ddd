package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.usuario.Usuario;
import domain.usuario.commands.CambiarNombre;

public class CambiarNombreUseCase extends UseCase<RequestCommand<CambiarNombre>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarNombre> input) {
        var command = input.getCommand();

        var usuario = Usuario.from(command.getUsuarioId(), retrieveEvents());
        usuario.cambiarNombre(command.getNombre());

        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));

    }
}
