package domain.libro.commands;

import co.com.sofka.domain.generic.Command;
import domain.libro.values.LibroId;
import domain.reseña.values.ResennaId;

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
