package domain.reseña.entity;

import co.com.sofka.domain.generic.Entity;
import domain.reseña.entity.values.ComentarioId;
import domain.reseña.entity.values.Comment;
import domain.reseña.entity.values.User;

public class Comentario extends Entity<ComentarioId> {

    private Comment comment;
    private final User user;

    //CONSTRUCTOR
    public Comentario(ComentarioId comentarioId, Comment comment, User user) {
        super(comentarioId);
        this.comment = comment;
        this.user = user;
    }

    //BEHAVIOURS
    public void editarComentario(String comment) {
        this.comment = new Comment(comment);
    }

    public void eliminarComentario() {
        //Todo: Implements this behaviour
    }


    //GETTER
    public Comment comment() {
        return comment;
    }

    public User user() {
        return user;
    }
}
