package domain.libro.commands;

import co.com.sofka.domain.generic.Command;
import domain.libro.values.LibroId;
import domain.reseña.values.ResennaId;

public class AdicionarResenna extends Command {

    private final LibroId libroId;
    private final ResennaId resennaId;

    public AdicionarResenna(LibroId libroId, ResennaId reseñaId) {

        this.libroId = libroId;
        this.resennaId = reseñaId;
    }

    public LibroId getLibroId() {
        return libroId;
    }

    public ResennaId getResennaId() {
        return resennaId;
    }
}
