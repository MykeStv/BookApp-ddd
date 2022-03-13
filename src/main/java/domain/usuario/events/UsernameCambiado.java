package domain.usuario.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.usuario.values.Username;

public class UsernameCambiado extends DomainEvent {

    private final Username username;

    public UsernameCambiado(Username username) {
        super("bookapp.usuario.usernamecambiado");
        this.username = username;
    }

    public Username getUsername() {
        return username;
    }
}
