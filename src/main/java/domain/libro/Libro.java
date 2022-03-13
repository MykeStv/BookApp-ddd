package domain.libro;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.libro.entity.Autor;
import domain.libro.entity.Progreso;
import domain.libro.entity.values.AutorId;
import domain.libro.entity.values.ProgresoId;
import domain.libro.entity.values.Nombre;
import domain.libro.events.LibroComenzado;
import domain.libro.events.LibroIngresado;
import domain.libro.events.ResennaAdicionada;
import domain.libro.values.Contenido;
import domain.libro.values.Descripcion;
import domain.libro.values.LibroId;
import domain.libro.values.*;
import domain.reseña.values.ResennaId;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Libro extends AggregateEvent<LibroId> {

    protected Descripcion descripcion;
    protected Contenido contenido;
    protected Progreso progreso;
    protected Autor autor;

    protected Set<ResennaId> reseñas;

    //CONSTRUCTOR
    public Libro(LibroId libroId, Contenido contenido, AutorId autorId, Nombre nombre, Descripcion descripcion) {
        super(libroId);
        appendChange(new LibroIngresado(contenido, autorId, nombre, descripcion)).apply();
    }

    private Libro(LibroId libroId) {
        super(libroId);
        subscribe(new LibroChange(this));
    }

    public static Libro from(LibroId libroId, List<DomainEvent> events) {
        var libro = new Libro(libroId);
        events.forEach(libro::applyEvent);
        return libro;
    }

    //BEHAVIOURS
    public void comenzarLibro(ProgresoId progresoId) {
        Objects.requireNonNull(progresoId);
        var paginaTotal = this.descripcion.value().paginas();
        appendChange(new LibroComenzado(progresoId, paginaTotal)).apply();
    }

    public void adicionarReseña(ResennaId reseñaId){
        Objects.requireNonNull(reseñaId);
        appendChange(new ResennaAdicionada(reseñaId)).apply();
    }

    /*public void cambiarPagina(Integer pagina) {
        Objects.requireNonNull(pagina);
        appendChange(new PaginaCambiada(pagina)).apply();
    }

    public void pasarPagina() {
        appendChange(new PaginaPasada(progreso.pasarPagina())).apply();
    }

    public void devolverPagina() {
        appendChange(new PaginaDevuelta(progreso.devolverPagina())).apply();
    }*/


    //GETTER
    public Descripcion descripcion() {
        return descripcion;
    }

    public Contenido contenido() {
        return contenido;
    }

    public Progreso progreso() {
        return progreso;
    }

    public Autor autor() {
        return autor;
    }
}
