package domain.reseña.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.reseña.values.Like;

public class LikeRemovido extends DomainEvent {

    private final Like like;

    public LikeRemovido(Like like) {
        super("bookapp.resenna.likeremovido");
        this.like = like;
    }

    //GETTERS

    public Like getLike() {
        return like;
    }
}
