package GUI;

import Interface.ScreenData;
import Modelo.*;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class verJugadoresUI extends JFrame implements ScreenData {
    private JPanel verJugadoresUI;
    private JList jugadoresList;
    private JButton editarButton;
    private JButton eliminarButton;
    private JButton volverButton;
    private JTextArea infoField;
    private JScrollPane scrollList;
    private JTextField searchField;
    private JLabel searchLabel;

    public verJugadoresUI(GestionSocios<Socio> socios, GestionJugadores<Jugador> jugadores) {
        setTitle("Jugadores");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(verJugadoresUI);
        setLocation(ScreenData.width/2 - 250, ScreenData.height/2 - 300);
        setSize(500, 600);
        setVisible(true);
        setResizable(false);





        DefaultListModel<Jugador> model = new DefaultListModel<>();

        for (Jugador jugador : jugadores.mapaJugadores.values()){
            model.addElement(jugador);
        }

        JugadorListCellRenderer renderer = new JugadorListCellRenderer();
        jugadoresList.setModel(model);
        jugadoresList = new JList<Jugador>(model);

        scrollList.setViewportView(jugadoresList);
        jugadoresList.setCellRenderer(renderer);


        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(jugadoresList.getSelectedValue() != null){

                if (JOptionPane.showConfirmDialog(null, "Esta seguro que quiere eliminar?", "Eliminar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    jugadores.removeJugador((Jugador) jugadoresList.getSelectedValue());
                    model.removeElement(jugadoresList.getSelectedValue());
                    infoField.setText("");
                }
                }
            }
        });
        jugadoresList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()){
                    Jugador selectedJugador = (Jugador) jugadoresList.getSelectedValue();

                    if (selectedJugador != null){
                        infoField.setText("Nombre: "+selectedJugador.getNombre() + "\nApellido: " + selectedJugador.getApellido() + "\nEdad: " + selectedJugador.getEdad() + "\nPosicion: " + selectedJugador.getPosicion().name() + "\nAtaque: " + selectedJugador.getAtaque() + "\nDefensa: " + selectedJugador.getDefensa() + "\nSueldo: " + selectedJugador.getSueldo());
                    }


                }
            }
        });
        searchField.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String aBuscar = searchField.getText();

                if (!aBuscar.equals("")){
                    model.removeAllElements();

                    for (Jugador jugador : jugadores.mapaJugadores.values()){
                        if(jugador.getNombre().contains(aBuscar)){
                            model.addElement(jugador);
                        }
                    }
                }else {

                    model.removeAllElements();

                    for (Jugador jugador : jugadores.mapaJugadores.values()){
                        model.addElement(jugador);
                    }
                }

            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GestionSociosUI(socios, jugadores);
                dispose();
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jugadoresList.getSelectedValue() != null){
                new EditarJugadorGUI(socios, jugadores, (Jugador) jugadoresList.getSelectedValue());
                dispose();
            }
            }
        });
    }

}
