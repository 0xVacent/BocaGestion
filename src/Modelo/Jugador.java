package Modelo;

import Enums.Posicion;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public abstract class Jugador extends Persona{
    private Posicion posicion;
    private int ataque;
    private int defensa;
    private int idJugador;
    private double sueldo;


    public Jugador(String nombre, int edad, String apellido, Posicion posicion, int idJugador, int defensa, int ataque, double sueldo) {
        super(nombre, apellido, edad);
        this.posicion = posicion;
        this.idJugador = idJugador;
        this.defensa = defensa;
        this.ataque = ataque;
        this.sueldo = sueldo;
    }




    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Jugador jugador = (Jugador) o;
        return ataque == jugador.ataque && defensa == jugador.defensa && idJugador == jugador.idJugador && Double.compare(sueldo, jugador.sueldo) == 0 && posicion == jugador.posicion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), posicion, ataque, defensa, idJugador, sueldo);
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "posicion=" + posicion +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                ", idJugador=" + idJugador +
                ", sueldo=" + sueldo +
                "} " + super.toString();
    }
}
