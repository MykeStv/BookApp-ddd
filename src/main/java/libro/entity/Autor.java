package libro.entity;

import co.com.sofka.domain.generic.Entity;
import libro.entity.values.AutorId;

public class Autor extends Entity<AutorId> {


    public Autor(AutorId autorId) {
        super(autorId);
    }
}
