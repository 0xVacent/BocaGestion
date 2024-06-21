import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerSociosUI extends JFrame implements ScreenData {
    private JPanel VerSociosUI;
    private JList<Socio> listaSocios;
    private JButton volverBoton;

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



        listaSocios.setModel(model);
        listaSocios = new JList<Socio>(model);
        listaSocios.setSelectedIndex(0);

        volverBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GestionSociosUI(socios);
                dispose();
            }
        });
    }

}
