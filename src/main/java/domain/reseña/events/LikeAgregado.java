package domain.reseña.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.reseña.values.Like;

public class LikeAgregado extends DomainEvent {

    private final Like like;

    public LikeAgregado(Like like) {
        super("bookapp.resenna.likeagregado");
        this.like = like;
    }

    //GETTERS
    public Like getLike() {
        return like;
    }
}
