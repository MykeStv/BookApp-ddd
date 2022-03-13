package domain.libro.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.libro.entity.values.AutorId;
import domain.libro.entity.values.Nombre;
import domain.libro.values.Contenido;
import domain.libro.values.Descripcion;

public class LibroIngresado extends DomainEvent {

    private final Contenido contenido;
    private final AutorId autorId; //just id or author as an Entity??
    private final Nombre nombre;
    private final Descripcion descripcion;


    public LibroIngresado(Contenido contenido, AutorId autorId, Nombre nombre, Descripcion descripcion) {
        super("bookapp.libro.librocreado");
        this.contenido = contenido;
        this.autorId = autorId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    //GETTERS
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
