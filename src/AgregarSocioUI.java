import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarSocioUI extends JFrame implements ScreenData{
    private JPanel AgregarSocioUI;
    private JRadioButton isAdherente;
    private JRadioButton isActivo;
    private JRadioButton isVitalicio;
    private JPanel textFieldsPanel;
    private JTextField idField;
    private JTextField nameField;
    private JTextField apellidoField;
    private JTextField edadField;
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel apellidoLabel;
    private JLabel edadLabel;
    private JButton aceptarBoton;
    private JButton volverBoton;

    public AgregarSocioUI(GestionSocios<Socio> socios) {
        setTitle("Agregar Socio");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(AgregarSocioUI);
        setLocation((width/2) - 250,(height/2) - 300);
        setResizable(false);
        setVisible(true);
        setSize(500, 600);
        volverBoton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                new GestionSociosUI(socios);
                dispose();
            }
        });
        aceptarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!idField.getText().isEmpty() && !nameField.getText().isEmpty() && !apellidoField.getText().isEmpty() && !edadField.getText().isEmpty()){


                    if (isAdherente.isSelected()) {
                        SocioAdherente newSocio = new SocioAdherente(0, Integer.parseInt(idField.getText()), nameField.getText(), apellidoField.getText(), Integer.parseInt(edadField.getText()));
                        socios.addSocio(newSocio);
                        JOptionPane.showMessageDialog(null, "Socio agregado exitosamente");
                    } else if (isActivo.isSelected()) {
                        SocioActivo newSocio = new SocioActivo(0, Integer.parseInt(idField.getText()), nameField.getText(), apellidoField.getText(), Integer.parseInt(edadField.getText()));
                        socios.addSocio(newSocio);
                        JOptionPane.showMessageDialog(null, "Socio agregado exitosamente");
                    } else if (isVitalicio.isSelected()) {
                        SocioVitalicio newSocio = new SocioVitalicio(0, Integer.parseInt(idField.getText()), nameField.getText(), apellidoField.getText(), Integer.parseInt(edadField.getText()));
                        socios.addSocio(newSocio);
                        JOptionPane.showMessageDialog(null, "Socio agregado exitosamente");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un valor valido");
                }
            }
        });
        isAdherente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isVitalicio.setSelected(false);
                isActivo.setSelected(false);
            }
        });
        isVitalicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                isAdherente.setSelected(false);
                isActivo.setSelected(false);
            }
        });

        isActivo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                isAdherente.setSelected(false);
                isVitalicio.setSelected(false);
            }
        });
    }

}
