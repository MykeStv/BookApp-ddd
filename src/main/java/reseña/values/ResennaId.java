package reseña.values;

import co.com.sofka.domain.generic.Identity;
import usuario.values.UsuarioId;

public class ResennaId extends Identity {

    public ResennaId() {

    }

    private ResennaId(String id) {
        super(id);
    }

    public static ResennaId of(String id) {
        return new ResennaId(id);
    }

}
