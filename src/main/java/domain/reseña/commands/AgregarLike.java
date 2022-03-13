package domain.reseña.commands;

import co.com.sofka.domain.generic.Command;
import domain.reseña.values.ResennaId;

public class AgregarLike extends Command {

    private final ResennaId resennaId;

    //CONSTRUCTOR
    public AgregarLike(ResennaId resennaId) {
        this.resennaId = resennaId;
    }

    //GETTERS
    public ResennaId getResennaId() {
        return resennaId;
    }
}
