package domain.usuario.commands;

import co.com.sofka.domain.generic.Command;
import domain.usuario.values.Email;
import domain.usuario.values.Nombre;
import domain.usuario.values.Username;
import domain.usuario.values.UsuarioId;

public class CrearUsuario extends Command {


    private final UsuarioId usuarioId;
    private final Username username;
    private final Nombre nombre;
    private final Email email;

    public CrearUsuario(UsuarioId usuarioId, Username username , Nombre nombre, Email email) {

        this.usuarioId = usuarioId;
        this.username = username;
        this.nombre = nombre;
        this.email = email;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }

    public Username getUsername() {
        return username;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Email getEmail() {
        return email;
    }
}
