package domain.reseña.commands;

import co.com.sofka.domain.generic.Command;
import domain.reseña.entity.values.ComentarioId;
import domain.reseña.entity.values.Comment;
import domain.reseña.entity.values.User;
import domain.reseña.values.ResennaId;

public class AgregarComentario extends Command {

    private final ResennaId resennaId;
    private final ComentarioId comentarioId;
    private final Comment comment;
    private final User user;

    //CONSTRUCTOR
    public AgregarComentario(ResennaId resennaId, ComentarioId comentarioId, Comment comment, User user) {
        this.resennaId = resennaId;
        this.comentarioId = comentarioId;
        this.comment = comment;
        this.user = user;
    }

    //GETTERS
    public ResennaId getResennaId() {
        return resennaId;
    }

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
