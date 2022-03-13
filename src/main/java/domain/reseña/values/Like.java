package domain.reseña.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Like implements ValueObject<Integer> {

    private final Integer likes;

    public Like(Integer likes) {
        this.likes = Objects.requireNonNull(likes);
        if (this.likes < 0) {
            throw new IllegalArgumentException("No puede tener un valor negativo");
        }
    }

    @Override
    public Integer value() {
        return likes;
    }

    public Like addLike() {
        return new Like(this.likes + 1);
    }

    public Like removeLike() {
        return new Like(this.likes - 1);
    }
}
