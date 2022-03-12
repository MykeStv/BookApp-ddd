package libro.values;

import co.com.sofka.domain.generic.Identity;
import usuario.values.UsuarioId;

public class LibroId extends Identity {

    public LibroId() {

    }

    private LibroId(String id) {
        super(id);
    }

    public static LibroId of(String id) {
        return new LibroId(id);
    }

}
