public class Main {
    public static void main(String[] args) {

        GestionSocios<Socio> socios = new GestionSocios();;

        socios.mapaSocios = GestionArchivos.parseJSON("thesocios");

        new GestionSociosUI(socios);


    }
}