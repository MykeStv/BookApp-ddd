package libro.entity.values;

import co.com.sofka.domain.generic.ValueObject;

public class Progress implements ValueObject<Double> {
    private final Double progress;

    public Progress(Double progress) {
        this.progress = progress;
        if (this.progress < 0) {
            throw new IllegalArgumentException("El progreso no puede ser negativo");
        }
        if (this.progress > 100) {
            throw new IllegalArgumentException("El progreso no pueder ser mayor de 100%");
        }
    }

    public Progress calcularProgress(PaginaActual actual, PaginaTotal total) {
        var value = Double.valueOf((actual.value() / total.value()) * 100);
        return new Progress(value);
    }

    @Override
    public Double value() {
        return progress;
    }
}
