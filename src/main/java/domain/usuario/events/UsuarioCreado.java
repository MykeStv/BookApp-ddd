package domain.usuario.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.usuario.values.Nombre;
import domain.usuario.values.Username;
import domain.usuario.values.Email;

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
