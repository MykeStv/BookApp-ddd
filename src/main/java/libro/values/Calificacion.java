package libro.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Calificacion implements ValueObject<Double> {

    private final Double score;

    public Calificacion(Double score) {
        this.score = Objects.requireNonNull(score);
    }

    @Override
    public Double value() {
        return score;
    }
}
