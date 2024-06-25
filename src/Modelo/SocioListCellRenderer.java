package Modelo;

import javax.swing.*;
import java.awt.*;

public class SocioListCellRenderer extends DefaultListCellRenderer implements ListCellRenderer<Object>{


    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Socio){
            Socio socio = (Socio)value;
            setText("Nombre: "+socio.getNombre() + " - Apellido: " + socio.getApellido() + " - Situacion: " + socio.getClass().getName());
        }

        return this;
    }
}
