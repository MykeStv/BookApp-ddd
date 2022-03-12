package usuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Email implements ValueObject<String> {

    private final String email;

    public Email(String email) {
        this.email = Objects.requireNonNull(email);
    }

    @Override
    public String value() {
        return email;
    }

}
