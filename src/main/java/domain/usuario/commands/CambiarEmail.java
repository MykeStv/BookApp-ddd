package domain.usuario.commands;

import co.com.sofka.domain.generic.Command;
import domain.usuario.values.Email;
import domain.usuario.values.UsuarioId;

public class CambiarEmail extends Command {

    private final UsuarioId usuarioId;
    private final Email email;

    public CambiarEmail(UsuarioId usuarioId, Email email) {

        this.usuarioId = usuarioId;
        this.email = email;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }

    public Email getEmail() {
        return email;
    }
}
