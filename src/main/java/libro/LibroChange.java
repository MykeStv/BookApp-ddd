package libro;

import co.com.sofka.domain.generic.EventChange;
import libro.entity.Autor;
import libro.entity.Progreso;
import libro.events.LibroComenzado;
import libro.events.LibroIngresado;
import libro.events.ResennaAdicionada;

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
