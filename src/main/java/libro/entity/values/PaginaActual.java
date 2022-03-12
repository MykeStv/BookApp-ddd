package libro.entity.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PaginaActual implements ValueObject<Integer> {
    private final Integer paginaActual;

    public PaginaActual(Integer paginaActual) {
        this.paginaActual = Objects.requireNonNull(paginaActual);
        if (this.paginaActual < 0) {
            throw new IllegalArgumentException("No puede tener menos de 0 paginas");
        }
    }

    @Override
    public Integer value() {
        return paginaActual;
    }

    public PaginaActual aumentarPag() {
        return new PaginaActual(this.paginaActual + 1);
    }

    public PaginaActual disminuirPag() {
        return new PaginaActual(this.paginaActual - 1);
    }

}
