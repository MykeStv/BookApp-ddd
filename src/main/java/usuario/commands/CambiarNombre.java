package usuario.commands;

import co.com.sofka.domain.generic.Command;
import usuario.values.Nombre;
import usuario.values.UsuarioId;

public class CambiarNombre extends Command {

    private final UsuarioId usuarioId;
    private final Nombre nombre;

    public CambiarNombre(UsuarioId usuarioId, Nombre nombre) {

        this.usuarioId = usuarioId;
        this.nombre = nombre;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
