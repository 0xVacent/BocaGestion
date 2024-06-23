public class JugadorPrimera extends Jugador{
    private double sueldo;

    public JugadorPrimera(String nombre, int edad, String apellido, Posicion posicion, int idJugador, int defensa, int ataque, double sueldo) {
        super(nombre, edad, apellido, posicion, idJugador, defensa, ataque);
        this.sueldo = sueldo;
    }

}
