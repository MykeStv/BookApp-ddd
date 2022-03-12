package libro.events;

import co.com.sofka.domain.generic.DomainEvent;
import reseña.values.ResennaId;

public class ResennaAdicionada extends DomainEvent {

    private final ResennaId reseñaId;

    public ResennaAdicionada(ResennaId reseñaId) {
        super("bookapp.libro.reseñaadicionada");
        this.reseñaId = reseñaId;
    }

    public ResennaId getReseñaId() {
        return reseñaId;
    }
}
