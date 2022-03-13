package domain.reseña;

import co.com.sofka.domain.generic.AggregateEvent;
import domain.reseña.values.ResennaId;

public class Resenna extends AggregateEvent<ResennaId> {


    public Resenna(ResennaId resennaId) {
        super(resennaId);
    }
}
