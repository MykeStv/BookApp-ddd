package libro;

import co.com.sofka.domain.generic.AggregateEvent;
import libro.values.LibroId;

public class Libro extends AggregateEvent<LibroId> {

    public Libro(LibroId libroId) {
        super(libroId);
    }
}
