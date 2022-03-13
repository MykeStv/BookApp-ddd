package domain.reseña.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.reseña.values.Critica;

public class ResennaEditada extends DomainEvent {

    private final Critica critica;

    public ResennaEditada(Critica critica) {
        super("bookapp.resenna.resennaeditada");
        this.critica = critica;
    }

    //GETTERS
    public Critica getCritica() {
        return critica;
    }
}
