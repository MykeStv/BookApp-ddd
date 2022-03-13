package domain.libro.entity.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PaginaTotal implements ValueObject<Integer> {
    private final Integer paginas;

    public PaginaTotal(Integer paginas) {
        this.paginas = Objects.requireNonNull(paginas);
        if (this.paginas < 0) {
            throw new IllegalArgumentException("No puede tener menos de 0 paginas");
        }
    }

    @Override
    public Integer value() {
        return paginas;
    }
}
