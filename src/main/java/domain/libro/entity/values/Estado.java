package domain.libro.entity.values;

import co.com.sofka.domain.generic.ValueObject;

public class Estado implements ValueObject<Estado.State> {

    private final State value;

    public Estado(State value) {
        this.value = value;
    }

    @Override
    public State value() {
        return value;
    }

    public enum State {
        LEIDO, LEYENDO, NO_LEIDO
    }
}
