package libro;

import co.com.sofka.domain.generic.AggregateEvent;
import libro.entity.Progreso;
import libro.entity.values.Estado;
import libro.values.*;

public class Libro extends AggregateEvent<LibroId> {

    protected Descripcion descripcion;
    protected Contenido contenido;
    protected Progreso progreso;

    public Libro(LibroId libroId, Contenido contenido, Descripcion descripcion) {
        super(libroId);
        appendChange()
    }
}
