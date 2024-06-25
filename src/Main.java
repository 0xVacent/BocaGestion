import GUI.GestionSociosUI;
import Modelo.*;

public class Main {
    public static void main(String[] args) {

        GestionSocios<Socio> socios = new GestionSocios();
        GestionJugadores<Jugador> jugadores = new GestionJugadores();


        jugadores.mapaJugadores = GestionArchivos.parseJSONJugadores("theplayers");

        socios.mapaSocios = GestionArchivos.parseJSONSocios("thesocios");

        new GestionSociosUI(socios, jugadores);


    }
}