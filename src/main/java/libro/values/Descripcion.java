package libro.values;

import co.com.sofka.domain.generic.ValueObject;
import libro.entity.values.PaginaTotal;

public class Descripcion implements ValueObject<Descripcion.Props> {

    private final String resumen;
    private final Integer capitulos;
    private final PaginaTotal paginas;

    public Descripcion(String resumen, Integer capitulos, PaginaTotal paginas) {
        this.resumen = resumen;
        this.capitulos = capitulos;
        this.paginas = paginas;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String resumen() {
                return resumen;
            }

            @Override
            public Integer capitulos() {
                return capitulos;
            }

            @Override
            public PaginaTotal paginas() {
                return paginas;
            }
        };
    }

    public interface Props {
        String resumen();
        Integer capitulos();
        PaginaTotal paginas();
    }
}
