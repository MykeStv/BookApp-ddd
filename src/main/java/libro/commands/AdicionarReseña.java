package libro.commands;

import co.com.sofka.domain.generic.Command;
import libro.values.LibroId;
import reseña.values.ResennaId;

public class AdicionarReseña extends Command {

    private final LibroId libroId;
    private final ResennaId reseñaId;

    public AdicionarReseña(LibroId libroId, ResennaId reseñaId) {

        this.libroId = libroId;
        this.reseñaId = reseñaId;
    }

    public LibroId getLibroId() {
        return libroId;
    }

    public ResennaId getReseñaId() {
        return reseñaId;
    }
}
