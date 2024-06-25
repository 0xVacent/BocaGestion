package GUI;

import Enums.Posicion;
import Interface.ScreenData;
import Modelo.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarJugadorUI extends JFrame implements ScreenData {
    private JPanel AgregarJugadorUI;
    private JRadioButton inferioresRadioButton;
    private JRadioButton primeraRadioButton;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField edadField;
    private JComboBox posicionComboBox;
    private JTextField ataqueField;
    private JTextField defensaField;
    private JTextField idField;
    private JButton volverButton;
    private JButton aceptarButton;
    private JLabel nombreLabel;
    private JLabel posicionLabel;
    private JLabel apellidoLabel;
    private JLabel edadLabel;
    private JLabel ataqueLabel;
    private JLabel defensaLabel;
    private JLabel idLabel;
    private JTextField sueldoField;
    private JLabel sueldoLabel;

    public AgregarJugadorUI(GestionSocios<Socio> socios, GestionJugadores<Jugador> jugadores) {
        setTitle("Agregar Jugador");
        setContentPane(AgregarJugadorUI);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation((ScreenData.width/2) - 250,(ScreenData.height/2) - 300);
        setResizable(false);
        setVisible(true);
        setSize(500,600);


        posicionComboBox.addItem(Posicion.ARQUERO);
        posicionComboBox.addItem(Posicion.DEFENSOR);
        posicionComboBox.addItem(Posicion.MEDIOCAMPISTA);
        posicionComboBox.addItem(Posicion.DELANTERO);



        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GestionSociosUI(socios, jugadores);
                dispose();
            }

        });


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
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!posicionComboBox.getSelectedItem().toString().equals("") && !apellidoField.getText().equals("") && !edadField.getText().equals("") && !ataqueField.getText().equals("") && !defensaField.getText().equals("") && !idField.getText().equals("")) {

                    if(primeraRadioButton.isSelected()) {
                        JugadorPrimera newJugador = new JugadorPrimera(nombreField.getText(), Integer.parseInt(edadField.getText()), apellidoField.getText(), (Posicion) posicionComboBox.getSelectedItem(), Integer.parseInt(idField.getText()), Integer.parseInt(defensaField.getText()), Integer.parseInt(ataqueField.getText()), Double.valueOf(sueldoField.getText()));
                        jugadores.addJugador(newJugador);
                        JOptionPane.showMessageDialog(null, "Jugador agregado exitosamente");
                    }else if (inferioresRadioButton.isSelected()) {
                        JugadorInferiores newJugador = new JugadorInferiores(nombreField.getText(), Integer.parseInt(edadField.getText()), apellidoField.getText(), (Posicion) posicionComboBox.getSelectedItem(), Integer.parseInt(idField.getText()), Integer.parseInt(defensaField.getText()), Integer.parseInt(ataqueField.getText()), Double.valueOf(sueldoField.getText()));
                        jugadores.addJugador(newJugador);
                        JOptionPane.showMessageDialog(null, "Jugador agregado exitosamente");
                    }

                }else {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un valor valido");
                }
            }
        });
    }


}
