package usuario;

import co.com.sofka.domain.generic.AggregateEvent;
import usuario.values.DatosPersonales;
import usuario.values.UsuarioId;

public class Usuario extends AggregateEvent<UsuarioId> {

    private DatosPersonales datosPersonales;

    //CONSTRUCTOR
    public Usuario(UsuarioId usuarioId, DatosPersonales datosPersonales) {
        super(usuarioId);
        this.datosPersonales = datosPersonales;
    }
}
