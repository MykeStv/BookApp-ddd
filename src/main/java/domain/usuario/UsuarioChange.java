package domain.usuario;

import co.com.sofka.domain.generic.EventChange;
import domain.usuario.events.EmailCambiado;
import domain.usuario.events.NombreCambiado;
import domain.usuario.events.UsernameCambiado;
import domain.usuario.events.UsuarioCreado;

public class UsuarioChange extends EventChange {
    public UsuarioChange(Usuario usuario) {

        //CONSUMERS
        apply((UsuarioCreado event) -> {
          usuario.username = event.getUsername();
          usuario.nombre = event.getNombre();
          usuario.email = event.getEmail();
        });

        apply((UsernameCambiado event) -> {
            usuario.username = event.getUsername();
        });

        apply((NombreCambiado event) -> {
            usuario.nombre = event.getNombre();
        });

        apply((EmailCambiado event) -> {
            usuario.email = event.getEmail();
        });

    }
}
