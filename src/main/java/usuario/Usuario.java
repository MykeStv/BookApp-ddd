package usuario;

import co.com.sofka.domain.generic.AggregateEvent;
import usuario.events.EmailCambiado;
import usuario.events.NombreCambiado;
import usuario.events.UsernameCambiado;
import usuario.events.UsuarioCreado;
import usuario.values.*;

import java.util.Objects;

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
