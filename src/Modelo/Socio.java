package Modelo;

import java.util.Objects;

public abstract class Socio extends Persona{
    private double cuota;
    private int partidosVistos;
    private int idSocio;

    public Socio(double cuota, int partidosVistos, int idSocio, String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.cuota = cuota;
        this.partidosVistos = partidosVistos;
        this.idSocio = idSocio;
    }

        public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public int getPartidosVistos() {
        return partidosVistos;
    }

    public void setPartidosVistos(int partidosVistos) {
        this.partidosVistos = partidosVistos;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Socio socio = (Socio) o;
        return Double.compare(cuota, socio.cuota) == 0 && partidosVistos == socio.partidosVistos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cuota, partidosVistos);
    }

    @Override
    public String toString() {
        return "Modelo.Socio{" +
                "cuota=" + cuota +
                ", partidosVistos=" + partidosVistos +
                ", idSocio=" + idSocio +
                "} " + super.toString();
    }


}

