package domain.reseña.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.reseña.values.Critica;
import domain.reseña.values.ResennaId;
import domain.usuario.values.UsuarioId;

public class ResennaCreada extends DomainEvent {

    private final Critica critica;
    private final UsuarioId usuarioId;

    public ResennaCreada(Critica critica, UsuarioId usuarioId) {
        super("bookapp.resenna.resennacreada");
        this.critica = critica;
        this.usuarioId = usuarioId;
    }

    //GETTER

    public Critica getCritica() {
        return critica;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }
}
