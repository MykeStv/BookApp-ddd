package domain.libro.entity;

import co.com.sofka.domain.generic.Entity;
import domain.libro.entity.values.*;
import libro.entity.values.*;

public class Progreso extends Entity<ProgresoId> {

    private final Progress progress;
    private final Estado estado;
    private final PaginaTotal paginaTotal;
    private PaginaActual paginaActual; //this has to be final??

    // CONSTRUCTOR
    public Progreso(ProgresoId progresoId, PaginaTotal paginaTotal) {
        super(progresoId);
        this.paginaTotal = paginaTotal;
        this.paginaActual = new PaginaActual(0);
        this.estado = new Estado(Estado.State.NO_LEIDO);
        this.progress = new Progress((double) 0);
    }

    //BEHAVIOURS
    public void pasarPagina() {
        if (!this.paginaActual.equals(paginaTotal)) {
            this.paginaActual.aumentarPag();
            this.progress.calcularProgress(this.paginaActual, this.paginaTotal);
        }
    }

    public void devolverPagina() {
        if (!this.paginaActual.equals(0)) {
            this.paginaActual.disminuirPag();
            this.progress.calcularProgress(this.paginaActual, this.paginaTotal);
        }
    }

    public void irAPagina(Integer pagina) {
        this.paginaActual = new PaginaActual(pagina);
        this.progress.calcularProgress(this.paginaActual, this.paginaTotal);
    }


    //GETTER
    public Progress progress() {
        return progress;
    }

    public Estado estado() {
        return estado;
    }

    public PaginaTotal pagTotal() {
        return paginaTotal;
    }

    public PaginaActual paginaActual() {
        return paginaActual;
    }
}
