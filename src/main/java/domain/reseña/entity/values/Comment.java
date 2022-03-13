package domain.reseña.entity.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Comment implements ValueObject<String> {

    private final String comment;

    public Comment(String comment) {
        this.comment = Objects.requireNonNull(comment);
    }

    @Override
    public String value() {
        return comment;
    }
}
