package domain.libro;

import co.com.sofka.domain.generic.EventChange;
import domain.libro.entity.Autor;
import domain.libro.entity.Progreso;
import domain.libro.events.LibroComenzado;
import domain.libro.events.LibroIngresado;
import domain.libro.events.ResennaAdicionada;

import java.util.HashSet;

public class LibroChange extends EventChange {
    public LibroChange(Libro libro) {

        //CONSUMERS
        apply((LibroIngresado event) -> {
            libro.contenido = event.getContenido();
            libro.autor = new Autor(event.getAutorId(), event.getNombre());
            libro.descripcion = event.getDescripcion();
            libro.reseñas = new HashSet<>(); //Inicia vacio

            //libro.progreso = new Progreso(event.getProgresoId(), libro.descripcion.value().paginas());
        });

        apply((LibroComenzado event) -> {
            libro.progreso = new Progreso(event.getProgresoId(), libro.descripcion.value().paginas());
        });

        apply((ResennaAdicionada event) -> {
            libro.reseñas.add(event.getReseñaId());
        });


    }
}
