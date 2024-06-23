import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionSociosUI extends JFrame implements ScreenData {
    private JPanel GestionSociosUI;
    private JLabel textoBienvenida;
    private JButton verSociosBoton;
    private JButton agregarSocioBoton;
    private JButton verJugadoresBoton;
    private JButton agregarJugadorBoton;
    private JButton guardarBoton;


    public GestionSociosUI(GestionSocios<Socio> socios) {
        setTitle("Gestion Socios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(GestionSociosUI);
        setLocation((width/2) - 250,(height/2) - 300);
        setResizable(false);
        setVisible(true);
        setSize(500,600 );


        agregarSocioBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AgregarSocioUI(socios);
                dispose();
            }
        });
        verSociosBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VerSociosUI(socios);
                dispose();
            }
        });
        verJugadoresBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        guardarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JSONArray array = new JSONArray();

                for (Socio socio : socios.mapaSocios.values()){
                    JSONObject json = new JSONObject(socio);
                    array.put(json);
                }

                GestionArchivos.grabar(array, "thesocios");
            }
        });
    }

}
