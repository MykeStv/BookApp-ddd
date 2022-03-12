package usuario.events;

import co.com.sofka.domain.generic.DomainEvent;
import usuario.values.Nombre;

public class NombreCambiado extends DomainEvent {
    private final Nombre nombre;

    public NombreCambiado(Nombre nombre) {
        super("bookapp.usuario.nombrecambiado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
