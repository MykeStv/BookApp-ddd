package domain.usuario;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.libro.values.LibroId;
import domain.usuario.events.EmailCambiado;
import domain.usuario.events.UsuarioCreado;
import domain.usuario.values.Email;
import domain.usuario.values.Nombre;
import domain.usuario.values.Username;
import domain.usuario.events.NombreCambiado;
import domain.usuario.events.UsernameCambiado;
import domain.usuario.values.UsuarioId;
import domain.usuario.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Usuario extends AggregateEvent<UsuarioId> {

    protected Username username;
    protected Nombre nombre;
    protected Email email;



    //CONSTRUCTOR
    public Usuario(UsuarioId usuarioId, Username username , Nombre nombre, Email email) {
        super(usuarioId);
        //Crea el agregado a traves de un evento
        appendChange(new UsuarioCreado( username, nombre, email)).apply();
    }

    private Usuario(UsuarioId usuarioId) {
        super(usuarioId);
        subscribe(new UsuarioChange(this));
    }

    //Historial de eventos
    public static Usuario from(UsuarioId usuarioId, List<DomainEvent> events) {
        var usuario = new Usuario(usuarioId);
        events.forEach(usuario::applyEvent);

        return usuario;
    }


    //BEHAVIOURS
    public void cambiarUsername(Username username) {
        Objects.requireNonNull(username);
        appendChange(new UsernameCambiado(username)).apply();
    }

    public void cambiarNombre(Nombre nombre) {
        Objects.requireNonNull(nombre);
        appendChange(new NombreCambiado(nombre)).apply();
    }

    public void cambiarEmail(Email email) {
        Objects.requireNonNull(email);
        appendChange(new EmailCambiado(email)).apply();
    }

    //GETTER
    public Username username() {
        return username;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Email email() {
        return email;
    }
}
