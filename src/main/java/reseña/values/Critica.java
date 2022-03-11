package reseña.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Critica implements ValueObject<String> {

    private final String critic;

    public Critica(String critic) {
        this.critic = Objects.requireNonNull(critic);
    }

    @Override
    public String value() {
        return critic;
    }
}
