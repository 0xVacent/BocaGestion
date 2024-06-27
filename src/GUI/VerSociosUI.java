package GUI;

import Interface.ScreenData;
import Modelo.*;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;

public class VerSociosUI extends JFrame implements ScreenData {
    private JPanel VerSociosUI;
    private JList<Socio> listaSocios;
    private JButton volverBoton;
    private JButton EditarBoton;
    private JButton EliminarBoton;
    private JScrollPane scrollList;
    private JLabel searchLabel;
    private JTextField searchField;
    private JTextArea infoField;

    public VerSociosUI(GestionSocios<Socio> socios, GestionJugadores<Jugador> jugadores) {
        setTitle("Socios");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(VerSociosUI);
        setLocation(ScreenData.width/2 - 250, ScreenData.height/2 - 300);
        setSize(500, 600);
        setVisible(true);
        setResizable(false);




        DefaultListModel<Socio> model = new DefaultListModel<>();

        for (Socio socio : socios.mapaSocios.values()){
            model.addElement(socio);
        }


        SocioListCellRenderer renderer = new SocioListCellRenderer();
        listaSocios.setModel(model);
        listaSocios = new JList<Socio>(model);

        scrollList.setViewportView(listaSocios);
        listaSocios.setCellRenderer(renderer);



        volverBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GestionSociosUI(socios, jugadores);
                dispose();
            }
        });



        EliminarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (listaSocios.getSelectedValue() != null) {

                if (JOptionPane.showConfirmDialog(null, "Esta seguro que quiere eliminar?", "Eliminar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    socios.removeSocio(listaSocios.getSelectedValue());
                    model.removeElement(listaSocios.getSelectedValue());
                    infoField.setText("");
                }
                }
            }
        });

        listaSocios.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    Socio selectedSocio = listaSocios.getSelectedValue();
                    System.out.println(selectedSocio);

                    if (selectedSocio != null) {
                        infoField.setText("Nombre: " + selectedSocio.getNombre() + "\nApellido: " + selectedSocio.getApellido() + "\nID: " + selectedSocio.getIdSocio() + "\nEdad: " + selectedSocio.getEdad() + "\nCouta: " + selectedSocio.getCuota() + "\nPartidos Vistos: " + selectedSocio.getPartidosVistos());
                        if (selectedSocio instanceof SocioActivo) {
                            infoField.append("\nTipo de Socio: Socio Activo");
                            infoField.append("\nFecha inicial de Activo: " + ((SocioActivo) selectedSocio).getFechaInicialActivo());
                        }else if (selectedSocio instanceof SocioAdherente) {
                            infoField.append("\nTipo de Socio: Socio Adherente");
                            infoField.append("\nFecha inicial de Adherente: " + ((SocioAdherente) selectedSocio).getFechaInicioAdherente());
                        }else if (selectedSocio instanceof SocioVitalicio){
                            infoField.append("\nTipo de Socio: Socio Vitalicio");
                            infoField.append("\nFecha inicial de Vitalicio: " + ((SocioVitalicio) selectedSocio).getFechaInicioVitalicio());
                        }
                    }
                }
            }
        });
        EditarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (listaSocios.getSelectedValue() != null) {

                new EditarSocioGUI(listaSocios.getSelectedValue(), socios, jugadores);
                dispose();
                }
            }
        });
        searchField.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String aBuscar  = searchField.getText();

                if(!aBuscar.equals("")) {
                    model.removeAllElements();

                    for (Socio socio : socios.mapaSocios.values()) {
                        if (socio.getNombre().contains(aBuscar)) {
                            model.addElement(socio);
                        }
                    }
                }else{

                    model.removeAllElements();

                    for (Socio socio : socios.mapaSocios.values()){
                        model.addElement(socio);
                    }
                }

            }
        });
    }

}
