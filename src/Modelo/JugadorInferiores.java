package Modelo;

import Enums.Posicion;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Objects;

public class JugadorInferiores extends Jugador{
    private LocalDate entradaAcademia;

    public JugadorInferiores(String nombre, int edad, String apellido, Posicion posicion, int idJugador, int defensa, int ataque, double sueldo) {
        super(nombre, edad, apellido, posicion, idJugador, defensa, ataque, sueldo);
        entradaAcademia = LocalDate.now();
    }

    public JugadorInferiores(String nombre, int edad, String apellido, Posicion posicion, int idJugador, int defensa, int ataque, double sueldo, LocalDate entradaAcademia) {
        super(nombre, edad, apellido, posicion, idJugador, defensa, ataque, sueldo);
        this.entradaAcademia = entradaAcademia;
    }

    public LocalDate getEntradaAcademia() {
        return entradaAcademia;
    }

    public void setEntradaAcademia(LocalDate entradaAcademia) {
        this.entradaAcademia = entradaAcademia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        JugadorInferiores that = (JugadorInferiores) o;
        return Objects.equals(entradaAcademia, that.entradaAcademia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), entradaAcademia);
    }

    @Override
    public String toString() {
        return "JugadorInferiores{" +
                "entradaAcademia=" + entradaAcademia +
                "} " + super.toString();
    }
}