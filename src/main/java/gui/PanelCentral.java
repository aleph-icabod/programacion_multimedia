package gui;

import javax.swing.*;
import java.awt.*;

public class PanelCentral extends JPanel {

    public PanelCentral(){
        super();

        JLabel etiqueta1=new JLabel("Escribe tu nombre");
        JLabel etiqueta2=new JLabel("Escribe tu nombre 2");
        JTextField input1=new JTextField();

        this.setLayout(new GridLayout(1,2));

        JPanel panelIzquierdo=new JPanel();

        JComboBox comboBox=new JComboBox();
        JCheckBox checkbox=new JCheckBox("Checkbox");

        comboBox.addItem("Opcion 1");
        comboBox.addItem("Opcion 2");
        comboBox.addItem("Opcion 3");

        panelIzquierdo.add(etiqueta1);
        panelIzquierdo.add(etiqueta2);
        panelIzquierdo.add(comboBox);
        panelIzquierdo.add(checkbox);
        this.add(panelIzquierdo);
        this.add(input1);
    }
}
