package GUI;

import Enums.Posicion;
import Interface.ScreenData;
import Modelo.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarJugadorGUI extends JFrame implements ScreenData {
    private JPanel EditarJugadorGUI;
    private JRadioButton inferioresRadioButton;
    private JRadioButton primeraRadioButton;
    private JComboBox posicionField;
    private JLabel posicionLabel;
    private JLabel sueldoLabel;
    private JTextField sueldoField;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField edadField;
    private JTextField idField;
    private JTextField ataqueField;
    private JTextField defensaField;
    private JButton volverButton;
    private JButton aceptarButton;
    private JLabel nombreLabel;
    private JLabel apellidoLabel;
    private JLabel edadLabel;
    private JLabel IDLabel;
    private JLabel ataqueLabel;
    private JLabel defensaLabel;

    public EditarJugadorGUI(GestionSocios<Socio> socios, GestionJugadores<Jugador> jugadores, Jugador jugador) {
        setTitle("Editar Jugador");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(EditarJugadorGUI);
        setLocation(ScreenData.width/2 - 250, ScreenData.height/2 - 300);
        setResizable(false);
        setVisible(true);
        setSize(500, 600);

        for (Posicion posicion : Posicion.values()) {
            posicionField.addItem(posicion);
        }

        posicionField.setSelectedItem(jugador.getPosicion());


        if (jugador instanceof JugadorPrimera){
            primeraRadioButton.setSelected(true);
            inferioresRadioButton.setSelected(false);
        }else if (jugador instanceof JugadorInferiores){
            inferioresRadioButton.setSelected(true);
            primeraRadioButton.setSelected(false);
        }

        sueldoField.setText(Double.toString(jugador.getSueldo()));
        nombreField.setText(jugador.getNombre());
        apellidoField.setText(jugador.getApellido());
        edadField.setText(String.valueOf(jugador.getEdad()));
        idField.setText(String.valueOf(jugador.getIdJugador()));
        ataqueField.setText(String.valueOf(jugador.getAtaque()));
        defensaField.setText(String.valueOf(jugador.getDefensa()));





        inferioresRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(primeraRadioButton.isSelected()) {
                    primeraRadioButton.setSelected(false);
                }
            }
        });

        primeraRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(inferioresRadioButton.isSelected()) {
                    inferioresRadioButton.setSelected(false);
                }
            }
        });


        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new verJugadoresUI(socios, jugadores);
                dispose();
            }
        });
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!nombreField.getText().equals("") && !apellidoField.getText().equals("") && !edadField.getText().equals("") && !idField.getText().equals("") && !ataqueField.getText().equals("")) {

                if(primeraRadioButton.isSelected()) {
                    JugadorPrimera newPlayer = new JugadorPrimera(nombreField.getText(), Integer.parseInt(edadField.getText()), apellidoField.getText(), (Posicion) posicionField.getSelectedItem(), Integer.parseInt(idField.getText()), Integer.getInteger(defensaField.getText()), Integer.parseInt(ataqueField.getText()), Double.valueOf(sueldoField.getText()));
                    jugadores.updateJugador(jugador, newPlayer);
                }else if (inferioresRadioButton.isSelected()) {
                    JugadorInferiores newPlayer = new JugadorInferiores(nombreField.getText(), Integer.parseInt(edadField.getText()), apellidoField.getText(), (Posicion) posicionField.getSelectedItem(), Integer.parseInt(idField.getText()), Integer.parseInt(defensaField.getText()), Integer.parseInt(ataqueField.getText()), Double.valueOf(sueldoField.getText()));
                    jugadores.updateJugador(jugador, newPlayer);
                }
                JOptionPane.showMessageDialog(EditarJugadorGUI, "Jugador actualizado exitosamente");
            }else {
                    JOptionPane.showMessageDialog(EditarJugadorGUI, "Por favor llene todos los campos");
                }
            }
        });
    }

}
