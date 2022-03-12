package libro.commands;

import co.com.sofka.domain.generic.Command;
import libro.entity.values.ProgresoId;
import libro.values.LibroId;

public class ComenzarLibro extends Command {

    private final LibroId libroId;
    private final ProgresoId progresoId;

    public ComenzarLibro(LibroId libroId, ProgresoId progresoId) {

        this.libroId = libroId;
        this.progresoId = progresoId;
    }

    public LibroId getLibroId() {
        return libroId;
    }

    public ProgresoId getProgresoId() {
        return progresoId;
    }
}
