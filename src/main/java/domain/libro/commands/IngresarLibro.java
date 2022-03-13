package domain.libro.commands;

import co.com.sofka.domain.generic.Command;
import domain.libro.entity.values.AutorId;
import domain.libro.entity.values.Nombre;
import domain.libro.values.Contenido;
import domain.libro.values.Descripcion;
import domain.libro.values.LibroId;

public class IngresarLibro extends Command {

    private final LibroId libroId;
    private final Contenido contenido;
    private final AutorId autorId;
    private final Nombre nombre;
    private final Descripcion descripcion;

    public IngresarLibro(LibroId libroId, Contenido contenido, AutorId autorId, Nombre nombre, Descripcion descripcion) {

        this.libroId = libroId;
        this.contenido = contenido;
        this.autorId = autorId;
        this.nombre = nombre;
        this.descripcion = descripcion;

    }

    public LibroId getLibroId() {
        return libroId;
    }

    public Contenido getContenido() {
        return contenido;
    }

    public AutorId getAutorId() {
        return autorId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
