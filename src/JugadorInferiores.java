public class JugadorInferiores extends Jugador{
    private int aniosAcademia;

    public JugadorInferiores(String nombre, int edad, String apellido, Posicion posicion, int idJugador, int defensa, int ataque, int aniosAcademia) {
        super(nombre, edad, apellido, posicion, idJugador, defensa, ataque);
        this.aniosAcademia = aniosAcademia;
    }
}