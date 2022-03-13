package domain.reseña.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.reseña.entity.values.ComentarioId;
import domain.reseña.entity.values.Comment;
import domain.reseña.entity.values.User;

public class ComentarioAgregado extends DomainEvent {

    private final ComentarioId comentarioId;
    private final Comment comment;
    private final User user;

    public ComentarioAgregado(ComentarioId comentarioId, Comment comment, User user) {
        super("bookapp.resenna.comentarioagregado");
        this.comentarioId = comentarioId;
        this.comment = comment;
        this.user = user;
    }

    //GETTERS
    public ComentarioId getComentarioId() {
        return comentarioId;
    }

    public Comment getComment() {
        return comment;
    }

    public User getUser() {
        return user;
    }
}
