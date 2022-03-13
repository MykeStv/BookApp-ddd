package domain.reseña.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.reseña.values.Like;

public class LikeRemovido extends DomainEvent {


    public LikeRemovido() {
        super("bookapp.resenna.likeremovido");
    }

    //GETTERS

}
