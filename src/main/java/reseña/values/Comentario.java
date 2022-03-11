package reseña.values;

import co.com.sofka.domain.generic.ValueObject;

public class Comentario implements ValueObject<Comentario.Props> {

    private final String comment;
    private final String user;

    public Comentario(String comment, String user) {
        this.comment = comment;
        this.user = user;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String user() {
                return user;
            }

            @Override
            public String comment() {
                return comment;
            }
        };
    }

    public interface Props {
        String user();
        String comment();
    }
}
