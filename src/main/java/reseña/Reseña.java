package reseña;

import co.com.sofka.domain.generic.AggregateEvent;
import reseña.values.ReseñaId;

public class Reseña extends AggregateEvent<ReseñaId> {


    public Reseña(ReseñaId reseñaId) {
        super(reseñaId);
    }
}
