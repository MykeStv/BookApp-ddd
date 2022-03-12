package libro.events;

import co.com.sofka.domain.generic.DomainEvent;
import libro.entity.values.PaginaTotal;
import libro.entity.values.ProgresoId;

public class LibroComenzado extends DomainEvent {

    private final ProgresoId progresoId;
    private final PaginaTotal paginaTotal;

    public LibroComenzado(ProgresoId progresoId, PaginaTotal paginaTotal) {
        super("bookapp.libro.librocomenzado");

        this.progresoId = progresoId;
        this.paginaTotal = paginaTotal;
    }

    public ProgresoId getProgresoId() {
        return progresoId;
    }

    public PaginaTotal getPaginaTotal() {
        return paginaTotal;
    }
}
