public abstract class Jugador extends Persona{
    private Posicion posicion;
    private int ataque;
    private int defensa;
    private int idJugador;


    public Jugador(String nombre, int edad, String apellido, Posicion posicion, int idJugador, int defensa, int ataque) {
        super(nombre, apellido, edad);
        this.posicion = posicion;
        this.idJugador = idJugador;
        this.defensa = defensa;
        this.ataque = ataque;
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
}
