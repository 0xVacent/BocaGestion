package Modelo;

import javax.swing.*;
import java.awt.*;

public class JugadorListCellRenderer extends DefaultListCellRenderer implements ListCellRenderer<Object>{
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Jugador){
            Jugador jugador = (Jugador) value;
            setText("Nombre: "+jugador.getNombre() + " - Apellido: " + jugador.getApellido() + " - Posicion: " + jugador.getPosicion() + " - Situacion: " + jugador.getClass().getName());

        }

        return this;
    }
}
