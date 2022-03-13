package domain.libro.entity.values;

import co.com.sofka.domain.generic.Identity;

public class ProgresoId extends Identity {

    public ProgresoId() {

    }

    private ProgresoId(String id) {
        super(id);
    }

    public static ProgresoId of(String id) {
        return new ProgresoId(id);
    }
}
