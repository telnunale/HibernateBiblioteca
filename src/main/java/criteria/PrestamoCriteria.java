package criteria;

import model.EstadoPrestamoEnum;
import model.Prestamo;

import java.time.LocalDate;

public class PrestamoCriteria {

    private EstadoPrestamoEnum estado;
    private LocalDate fechaInicio;
    private LocalDate finFechaInicio;

    public EstadoPrestamoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoPrestamoEnum estado) {
        this.estado = estado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFinFechaInicio() {
        return finFechaInicio;
    }

    public void setFinFechaInicio(LocalDate finFechaInicio) {
        this.finFechaInicio = finFechaInicio;
    }
    public boolean isPresentFechaInicio(){
        return this.fechaInicio!=null  && this.finFechaInicio!=null;
    }
    public boolean isPresentPrestamo(){
        return this.estado!=null;
    }
}
