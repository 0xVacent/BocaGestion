package Interface;

import Modelo.Jugador;

public interface InterfaceGestionJugadores <T extends Jugador>{
    boolean addJugador(T jugador);
    boolean removeJugador(T jugador);
    boolean updateJugador(T jugador, T newJugador);
    T getJugadorById(int id);
}
