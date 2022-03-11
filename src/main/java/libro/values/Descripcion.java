package libro.values;

import co.com.sofka.domain.generic.ValueObject;

public class Descripcion implements ValueObject<Descripcion.Props> {

    private final String resumen;
    private final Integer capitulos;
    private final Integer paginas;

    public Descripcion(String resumen, Integer capitulos, Integer paginas) {
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
            public Integer paginas() {
                return paginas;
            }
        };
    }

    public interface Props {
        String resumen();
        Integer capitulos();
        Integer paginas();
    }
}
