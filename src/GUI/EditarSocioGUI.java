package GUI;

import Interface.ScreenData;
import Modelo.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class EditarSocioGUI extends JFrame implements ScreenData {
    private JPanel EditarGUI;
    private JRadioButton adherenteBoton;
    private JRadioButton activoBoton;
    private JRadioButton vitalicioBoton;
    private JPanel textFieldPanel;
    private JTextField idField;
    private JLabel idLabel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel apellidoLabel;
    private JTextField apellidoField;
    private JLabel edadLabel;
    private JTextField edadField;
    private JButton volverBoton;
    private JButton aceptarBoton;

    public EditarSocioGUI(Object socio, GestionSocios<Socio> socios, GestionJugadores<Jugador> jugadores) {
        setContentPane(EditarGUI);
        setTitle("Editar");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation((ScreenData.width/2) - 250,(ScreenData.height/2) - 300);
        setResizable(false);
        setVisible(true);
        setSize(500, 600);

        if (socio instanceof SocioAdherente){
            adherenteBoton.setSelected(true);
            idField.setText(String.valueOf(((SocioAdherente) socio).getIdSocio()));
            nameField.setText(((SocioAdherente) socio).getNombre());
            apellidoField.setText(((SocioAdherente) socio).getApellido());
            edadField.setText(String.valueOf(((SocioAdherente) socio).getEdad()));
        }
        if(socio instanceof SocioActivo){
            activoBoton.setSelected(true);
            idField.setText(String.valueOf(((SocioActivo) socio).getIdSocio()));
            nameField.setText(((SocioActivo) socio).getNombre());
            apellidoField.setText(((SocioActivo) socio).getApellido());
            edadField.setText(String.valueOf(((SocioActivo) socio).getEdad()));
        }
        if(socio instanceof SocioVitalicio){
            vitalicioBoton.setSelected(true);
            idField.setText(String.valueOf(((SocioVitalicio) socio).getIdSocio()));
            nameField.setText(((SocioVitalicio) socio).getNombre());
            apellidoField.setText(((SocioVitalicio) socio).getApellido());
            edadField.setText(String.valueOf(((SocioVitalicio) socio).getEdad()));
        }





        volverBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VerSociosUI(socios, jugadores);
                dispose();
            }
        });
        aceptarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!idField.getText().equals("") && !nameField.getText().equals("") && !apellidoField.getText().equals("") && !edadField.getText().equals("")){

                    LocalDate date = null;

                    if (socio instanceof SocioAdherente){
                        date = ((SocioAdherente) socio).getFechaInicioAdherente();
                    }else if(socio instanceof SocioActivo){
                        date = ((SocioActivo) socio).getFechaInicialActivo();

                    }else if(socio instanceof SocioVitalicio){
                        date = ((SocioVitalicio) socio).getFechaInicioVitalicio();
                    }


                if (adherenteBoton.isSelected()) {
                    SocioAdherente newSocio = new SocioAdherente(((Socio) socio).getPartidosVistos(), Integer.parseInt(idField.getText()), nameField.getText(), apellidoField.getText(), Integer.parseInt(edadField.getText()), date);
                    socios.updateSocio((Socio) socio, newSocio);
                }else if (activoBoton.isSelected()) {
                    SocioActivo newSocio = new SocioActivo(((Socio) socio).getPartidosVistos(), Integer.parseInt(idField.getText()), nameField.getText(), apellidoField.getText(), Integer.parseInt(edadField.getText()), date);
                    socios.updateSocio((Socio) socio, newSocio);
                }else if (vitalicioBoton.isSelected()) {
                    SocioVitalicio newSocio = new SocioVitalicio(((Socio) socio).getPartidosVistos(), Integer.parseInt(idField.getText()), nameField.getText(), apellidoField.getText(), Integer.parseInt(edadField.getText()), date);
                    socios.updateSocio((Socio) socio, newSocio);
                }

                    JOptionPane.showMessageDialog(EditarGUI, "Modelo.Socio actualizado exitosamente");
                }else{
                    JOptionPane.showMessageDialog(EditarGUI, "Por favor llene todos los campos");
                }
            }
        });
        adherenteBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activoBoton.setSelected(false);
                vitalicioBoton.setSelected(false);
            }
        });


        activoBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adherenteBoton.setSelected(false);
                vitalicioBoton.setSelected(false);
            }
        });
        vitalicioBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activoBoton.setSelected(false);
                adherenteBoton.setSelected(false);
            }
        });
    }
}
