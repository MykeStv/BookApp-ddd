package usuario.events;

import co.com.sofka.domain.generic.DomainEvent;
import usuario.values.DatosPersonales;
import usuario.values.Email;
import usuario.values.Nombre;
import usuario.values.Username;

public class UsuarioCreado extends DomainEvent {

    private final Username username;
    private final Nombre nombre;
    private final Email email;

    public UsuarioCreado(Username username, Nombre nombre, Email email) {
        super("bookapp.usuario.usuariocreado");
        this.username = username;
        this.nombre = nombre;
        this.email = email;
    }

    //GETTERS
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
