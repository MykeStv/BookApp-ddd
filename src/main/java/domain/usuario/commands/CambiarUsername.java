package domain.usuario.commands;

import co.com.sofka.domain.generic.Command;
import domain.usuario.values.Username;
import domain.usuario.values.UsuarioId;

public class CambiarUsername extends Command {

    private final UsuarioId usuarioId;
    private final Username username;

    public CambiarUsername(UsuarioId usuarioId, Username username) {

        this.usuarioId = usuarioId;
        this.username = username;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }

    public Username getUsername() {
        return username;
    }
}
