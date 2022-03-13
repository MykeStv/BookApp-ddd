package domain.reseña.entity.values;

import co.com.sofka.domain.generic.Identity;

public class ComentarioId extends Identity {

    public ComentarioId () {

    }

    private ComentarioId(String id) {
        super(id);
    }

    public static ComentarioId of(String id) {
        return new ComentarioId(id);
    }

}
