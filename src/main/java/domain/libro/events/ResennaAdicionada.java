package domain.libro.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.reseña.values.ResennaId;

public class ResennaAdicionada extends DomainEvent {

    private final ResennaId resennaId;

    public ResennaAdicionada(ResennaId reseñaId) {
        super("bookapp.libro.reseñaadicionada");
        this.resennaId = reseñaId;
    }

    public ResennaId getResennaId() {
        return resennaId;
    }
}
