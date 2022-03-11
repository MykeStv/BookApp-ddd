package libro.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Contenido implements ValueObject<String> {

    private final String content;

    public Contenido(String content) {
        this.content = Objects.requireNonNull(content);
    }

    @Override
    public String value() {
        return content;
    }
}
