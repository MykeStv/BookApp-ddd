package domain.reseña.commands;

import co.com.sofka.domain.generic.Command;
import domain.reseña.values.ResennaId;

public class RemoverLike extends Command {

    private final ResennaId resennaId;

    //CONSTRUCTOR
    public RemoverLike(ResennaId resennaId) {
        this.resennaId = resennaId;
    }

    //GETTERS
    public ResennaId getResennaId() {
        return resennaId;
    }
}
