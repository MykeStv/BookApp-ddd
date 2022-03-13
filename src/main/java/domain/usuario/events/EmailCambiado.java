package domain.usuario.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.usuario.values.Email;

public class EmailCambiado extends DomainEvent {
    private final Email email;

    public EmailCambiado(Email email) {
        super("bookapp.usuario.emailcambiado");
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }
}
