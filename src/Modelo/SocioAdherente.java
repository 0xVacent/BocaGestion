package Modelo;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class SocioAdherente extends Socio{
    private LocalDate fechaInicioAdherente;

    public SocioAdherente(int partidosVistos, int idSocio, String nombre, String apellido, int edad) {
        super(8250, partidosVistos, idSocio, nombre, apellido, edad);
        this.fechaInicioAdherente = LocalDate.now();
    }

    public SocioAdherente(int partidosVistos, int idSocio, String nombre, String apellido, int edad, LocalDate fechaInicioAdherente) {
        super(8250, partidosVistos, idSocio, nombre, apellido, edad);
        this.fechaInicioAdherente = fechaInicioAdherente;
    }

    public LocalDate getFechaInicioAdherente() {
        return fechaInicioAdherente;
    }

    public void setFechaInicioAdherente(LocalDate fechaInicioAdherente) {
        this.fechaInicioAdherente = fechaInicioAdherente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SocioAdherente that = (SocioAdherente) o;
        return Objects.equals(fechaInicioAdherente, that.fechaInicioAdherente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fechaInicioAdherente);
    }

    @Override
    public String toString() {
        return "Modelo.SocioAdherente{" +
                "fechaInicioAdherente=" + fechaInicioAdherente +
                "} " + super.toString();
    }
}
