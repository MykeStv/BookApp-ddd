package domain.reseña.commands;

import co.com.sofka.domain.generic.Command;
import domain.reseña.values.Critica;
import domain.reseña.values.ResennaId;
import domain.usuario.values.UsuarioId;

public class CrearResenna extends Command {

    private final ResennaId resennaId;
    private final Critica critica;
    private final UsuarioId usuarioId;

    //CONSTRUCTOR
    public CrearResenna(ResennaId resennaId, Critica critica, UsuarioId usuarioId) {
        this.resennaId = resennaId;
        this.critica = critica;
        this.usuarioId = usuarioId;
    }

    //GETTERS
    public ResennaId getResennaId() {
        return resennaId;
    }

    public Critica getCritica() {
        return critica;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }
}
