package domain.reseña;

import co.com.sofka.domain.generic.EventChange;
import domain.reseña.entity.Comentario;
import domain.reseña.events.*;
import domain.reseña.values.Like;

import java.util.HashSet;

public class ResennaChange extends EventChange {
    public ResennaChange(Resenna resenna) {

        //CONSUMERS
        apply((ResennaCreada event) -> {
            resenna.critica = event.getCritica();
            resenna.usuarioId = event.getUsuarioId();
            resenna.comentarios = new HashSet<>(); //Inicia sin comentarios
            resenna.likes = new Like(0); //Los likes son 0 inicialmente
        });

        apply((ResennaEditada event) -> {
            resenna.critica = event.getCritica();
        });

        apply((LikeAgregado event) -> {
            var likes = resenna.likes().value();
            if (likes < 0) {
                throw new IllegalArgumentException("No puede tener likes negativos");
            }
            resenna.likes = event.getLike();
        });

        //Trying another way to remove like
        apply((LikeRemovido event) -> {
            var likes = resenna.likes();
            if (likes.value() <= 0) {
                throw new IllegalArgumentException("No puede tener likes negativos");
            }
            resenna.likes = likes.removeLike();
        });

        apply((ComentarioAgregado event) -> {
            resenna.comentarios.add(new Comentario(
                    event.getComentarioId(),
                    event.getComment(),
                    event.getUser()
            ));
        });
    }
}
