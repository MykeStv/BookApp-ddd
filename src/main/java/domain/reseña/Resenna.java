package domain.reseña;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.reseña.entity.Comentario;
import domain.reseña.entity.values.ComentarioId;
import domain.reseña.entity.values.Comment;
import domain.reseña.entity.values.User;
import domain.reseña.events.*;
import domain.reseña.values.Critica;
import domain.reseña.values.Like;
import domain.reseña.values.ResennaId;
import domain.usuario.values.UsuarioId;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Resenna extends AggregateEvent<ResennaId> {

    protected Critica critica;
    protected UsuarioId usuarioId;
    protected Set<Comentario> comentarios;
    protected Like likes;

    //CONSTRUCTOR
    public Resenna(ResennaId resennaId, Critica critica, UsuarioId usuarioId) {
        super(resennaId);
        appendChange(new ResennaCreada(critica, usuarioId)).apply();

    }

    private Resenna(ResennaId resennaId) {
        super(resennaId);
        subscribe(new ResennaChange(this));
    }

    public static Resenna from(ResennaId resennaId, List<DomainEvent> events) {
        var resenna = new Resenna(resennaId);
        events.forEach(resenna::applyEvent);
        return resenna;
    }

    //BEHAVIOURS
    public void editarResenna(Critica critica){
        Objects.requireNonNull(critica);
        appendChange(new ResennaEditada(critica)).apply();
    }

    //Dont send the whole Comentario entity but his attributes
    public void agregarComentario(ComentarioId comentarioId, Comment comment, User user) {
        Objects.requireNonNull(comentarioId);
        Objects.requireNonNull(comment);
        Objects.requireNonNull(user);
        appendChange(new ComentarioAgregado(comentarioId, comment, user)).apply();
    }

    public void agregarLike() {
        var like = likes.addLike();
        appendChange(new LikeAgregado(like)).apply();
    }

    public void removerLike() {
        var like = likes.removeLike();
        appendChange(new LikeRemovido(like)).apply();
    }


    //GETTER
    public Critica critica() {
        return critica;
    }

    public UsuarioId usuarioId() {
        return usuarioId;
    }

    public Set<Comentario> comentarios() {
        return comentarios;
    }

    public Like likes() {
        return likes;
    }
}
