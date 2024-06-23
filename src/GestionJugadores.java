import java.util.HashMap;

public class GestionJugadores <T extends Jugador> implements InterfaceGestionJugadores{
    HashMap<Integer,Jugador>mapaJugadores;

    public GestionJugadores(HashMap<Integer, Jugador> mapaJugadores) {
        this.mapaJugadores = mapaJugadores;
    }


    @Override
    public boolean addJugador(Jugador jugador) {
        if (jugador != null) {
            mapaJugadores.put(jugador.getIdJugador(), jugador);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeJugador(Jugador jugador) {
        if (jugador != null) {
            mapaJugadores.remove(jugador.getIdJugador());
            return true;
        }
        return false;
    }

    @Override
    public boolean updateJugador(Jugador jugador, Jugador newJugador) {
        if(jugador != null && newJugador != null) {
            removeJugador(jugador);
            addJugador(newJugador);
        }
        return false;
    }

    @Override
    public Jugador getJugadorById(int id) {
        if (mapaJugadores.containsKey(id)) {
            return (T) mapaJugadores.get(id);
        }
        return null;
    }
}