package domain.libro.entity;

import co.com.sofka.domain.generic.Entity;
import domain.libro.entity.values.AutorId;
import domain.libro.entity.values.Nombre;

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
