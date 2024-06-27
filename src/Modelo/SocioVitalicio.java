package Modelo;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class SocioVitalicio extends Socio{
    private LocalDate fechaInicioVitalicio;

    public SocioVitalicio(int partidosVistos, int idSocio, String nombre, String apellido, int edad) {
        super(0, partidosVistos, idSocio, nombre, apellido, edad);
        this.fechaInicioVitalicio = LocalDate.now();
    }

    public SocioVitalicio(int partidosVistos, int idSocio, String nombre, String apellido, int edad, LocalDate fechaInicioVitalicio) {
        super(0, partidosVistos, idSocio, nombre, apellido, edad);
        this.fechaInicioVitalicio = fechaInicioVitalicio;
    }

    public LocalDate getFechaInicioVitalicio() {
        return fechaInicioVitalicio;
    }

    public void setFechaInicioVitalicio(LocalDate fechaInicioVitalicio) {
        this.fechaInicioVitalicio = fechaInicioVitalicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SocioVitalicio that = (SocioVitalicio) o;
        return Objects.equals(fechaInicioVitalicio, that.fechaInicioVitalicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fechaInicioVitalicio);
    }

    @Override
    public String toString() {
        return "Modelo.SocioVitalicio{" +
                "fechaInicioVitalicio=" + fechaInicioVitalicio +
                "} " + super.toString();
    }
}
