package Modelo;

import java.time.LocalDate;
import java.util.Objects;

public class SocioActivo extends Socio{
    private LocalDate fechaInicialActivo;

    public SocioActivo(int partidosVistos, int idSocio, String nombre, String apellido, int edad) {
        super(16500, partidosVistos, idSocio, nombre, apellido, edad);
        this.fechaInicialActivo = LocalDate.now();
    }
    public SocioActivo(int partidosVistos, int idSocio, String nombre, String apellido, int edad, LocalDate fechaInicialActivo) {
        super(16500, partidosVistos, idSocio, nombre, apellido, edad);
        this.fechaInicialActivo = fechaInicialActivo;
    }

    public LocalDate getFechaInicialActivo() {
        return fechaInicialActivo;
    }

    public void setFechaInicialActivo(LocalDate fechaInicialActivo) {
        this.fechaInicialActivo = fechaInicialActivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SocioActivo that = (SocioActivo) o;
        return Objects.equals(fechaInicialActivo, that.fechaInicialActivo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fechaInicialActivo);
    }

    @Override
    public String toString() {
        return "Modelo.SocioActivo{" +
                "fechaInicialActivo=" + fechaInicialActivo +
                "} " + super.toString();
    }
}
