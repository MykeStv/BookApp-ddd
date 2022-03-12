package usuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Username implements ValueObject<String> {

    private final String username;

    public Username(String username) {
        this.username = Objects.requireNonNull(username);
    }

    @Override
    public String value() {
        return username;
    }
}
