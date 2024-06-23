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

    public VerSociosUI(GestionSocios<Socio> socios) {
        setTitle("Socios");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(VerSociosUI);
        setLocation(width/2 - 250, height/2 - 300);
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
                new GestionSociosUI(socios);
                dispose();
            }
        });



        EliminarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (JOptionPane.showConfirmDialog(null, "Esta seguro que quiere eliminar?", "Eliminar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    socios.removeSocio(listaSocios.getSelectedValue());
                    System.out.println(listaSocios.getModel());
                    model.removeElement(listaSocios.getSelectedValue());
                }

            }
        });

        listaSocios.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    Socio selectedSocio = listaSocios.getSelectedValue();
                    System.out.println(selectedSocio);
                    // Additional handling code here
                }
            }
        });
        EditarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditarGUI(listaSocios.getSelectedValue(), socios);
                dispose();
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
