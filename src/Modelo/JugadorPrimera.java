package Modelo;

import Enums.Posicion;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Objects;

public class JugadorPrimera extends Jugador{
    private LocalDate inicioPrimera;

    public JugadorPrimera(String nombre, int edad, String apellido, Posicion posicion, int idJugador, int defensa, int ataque, double sueldo) {
        super(nombre, edad, apellido, posicion, idJugador, defensa, ataque, sueldo);
        inicioPrimera = LocalDate.now();
    }

    public JugadorPrimera(String nombre, int edad, String apellido, Posicion posicion, int idJugador, int defensa, int ataque, double sueldo, LocalDate inicioPrimera) {
        super(nombre, edad, apellido, posicion, idJugador, defensa, ataque, sueldo);
        this.inicioPrimera = inicioPrimera;
    }

    public LocalDate getInicioPrimera() {
        return inicioPrimera;
    }

    public void setInicioPrimera(LocalDate inicioPrimera) {
        this.inicioPrimera = inicioPrimera;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        JugadorPrimera that = (JugadorPrimera) o;
        return Objects.equals(inicioPrimera, that.inicioPrimera);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), inicioPrimera);
    }

    @Override
    public String toString() {
        return "JugadorPrimera{" +
                "inicioPrimera=" + inicioPrimera +
                "} " + super.toString();
    }
}
