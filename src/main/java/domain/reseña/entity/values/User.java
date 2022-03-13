package domain.reseña.entity.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class User implements ValueObject<String> {

    private final String user;

    public User(String user) {
        this.user = Objects.requireNonNull(user);
    }

    @Override
    public String value() {
        return user;
    }
}
