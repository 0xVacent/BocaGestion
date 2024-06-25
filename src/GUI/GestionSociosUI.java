package GUI;

import Interface.ScreenData;
import Modelo.*;
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


    public GestionSociosUI(GestionSocios<Socio> socios, GestionJugadores<Jugador> jugadores) {
        setTitle("Gestion Socios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(GestionSociosUI);
        setLocation((ScreenData.width/2) - 250,(ScreenData.height/2) - 300);
        setResizable(false);
        setVisible(true);
        setSize(500,600 );


        agregarSocioBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AgregarSocioUI(socios, jugadores);
                dispose();
            }
        });
        verSociosBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VerSociosUI(socios, jugadores);
                dispose();
            }
        });
        guardarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JSONArray arraySocios = new JSONArray();
                JSONArray arrayJugadores = new JSONArray();

                for (Socio socio : socios.mapaSocios.values()){
                    JSONObject json = new JSONObject(socio);
                    arraySocios.put(json);
                }

                for (Jugador jugador : jugadores.mapaJugadores.values()){
                    JSONObject json = new JSONObject(jugador);
                    try {
                        json.put("posicion", jugador.getPosicion());
                    } catch (JSONException ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println(json);
                    arrayJugadores.put(json);
                }

                GestionArchivos.grabar(arraySocios, "thesocios");
                GestionArchivos.grabar(arrayJugadores, "theplayers");
            }
        });
        agregarJugadorBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AgregarJugadorUI(socios,jugadores);
                dispose();
            }
        });
        verJugadoresBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new verJugadoresUI(socios,jugadores);
                dispose();
            }
        });
    }

}
