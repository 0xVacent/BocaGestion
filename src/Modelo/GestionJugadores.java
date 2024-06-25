package Modelo;

import Interface.InterfaceGestionJugadores;

import java.util.HashMap;

public class GestionJugadores <T extends Jugador> implements InterfaceGestionJugadores<T> {
    public HashMap<Integer,Jugador> mapaJugadores;

    public GestionJugadores() {
        this.mapaJugadores = new HashMap<Integer, Jugador>();
    }


    @Override
    public boolean addJugador(T jugador) {
        if (jugador != null) {
            mapaJugadores.put(jugador.getIdJugador(), jugador);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeJugador(T jugador) {
        if (jugador != null) {
            mapaJugadores.remove(jugador.getIdJugador());
            return true;
        }
        return false;
    }

    @Override
    public boolean updateJugador(T jugador, T newJugador) {
        if(jugador != null && newJugador != null) {
            removeJugador(jugador);
            addJugador(newJugador);
        }
        return false;
    }

    @Override
    public T getJugadorById(int id) {
        if (mapaJugadores.containsKey(id)) {
            return (T) mapaJugadores.get(id);
        }
        return null;
    }

    public void subirSueldo(int idJugador) {
        if(mapaJugadores.containsKey(idJugador)) {
            Jugador jugador = mapaJugadores.get(idJugador);
            if(jugador.getAtaque()>=55 && jugador.getDefensa()>=35){ //dsp ponerle el LocalDate
                jugador.setSueldo(jugador.getSueldo() * 1.5);
                System.out.println("Nuevo Sueldo de "+jugador.getNombre()+ ": {" +jugador.getSueldo()+"}");
            }
            else{
                throw new IllegalArgumentException("El jugador no cumple los requerimientos para el aumento de sueldo");
            }
        }
    }
}