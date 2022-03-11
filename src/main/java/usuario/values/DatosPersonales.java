package usuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DatosPersonales implements ValueObject<DatosPersonales.Props>  {
    //ATRIBUTES
    private final String username;
    private final String nombre;
    private final String email;

    //CONSTRUCTOR
    public DatosPersonales(String username, String nombre, String email) {
        this.username = Objects.requireNonNull(username);
        this.nombre = Objects.requireNonNull(nombre);
        this.email = Objects.requireNonNull(email);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String username() {
                return username;
            }

            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public String email() {
                return email;
            }
        };
    }

    public interface Props {
        String username();
        String nombre();
        String email();
    }

}
