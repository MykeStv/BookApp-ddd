package domain.reseña.commands;

import co.com.sofka.domain.generic.Command;
import domain.reseña.values.Critica;
import domain.reseña.values.ResennaId;

public class EditarResenna extends Command {

    private final ResennaId resennaId;
    private final Critica critica;

    //CONSTRUCTOR
    public EditarResenna(ResennaId resennaId, Critica critica) {
        this.resennaId = resennaId;
        this.critica = critica;
    }

    //GETTERS
    public ResennaId getResennaId() {
        return resennaId;
    }

    public Critica getCritica() {
        return critica;
    }
}
