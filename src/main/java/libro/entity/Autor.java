package libro.entity;

import co.com.sofka.domain.generic.Entity;
import libro.entity.values.AutorId;
import libro.entity.values.Nombre;

public class Autor extends Entity<AutorId> {

    private final Nombre nombre;

    public Autor(AutorId autorId, Nombre nombre) {
        super(autorId);
        this.nombre = nombre;
    }

    public Nombre nombre() {
        return nombre;
    }
}
