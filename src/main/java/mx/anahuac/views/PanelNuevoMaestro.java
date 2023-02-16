package mx.anahuac.views;

import gui.PanelCentral;
import mx.anahuac.University.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class PanelNuevoMaestro extends JPanel  {
    JTextField nombreInput;
    JComboBox generoInput;

    JButton guardar;
    JButton cancelar;

    public PanelNuevoMaestro(){
        super();

        nombreInput=new JTextField("Ingresar Nombre");
        generoInput=new JComboBox();
        generoInput.addItem("Masculino");
        generoInput.addItem("Femenino");
        generoInput.addItem("Otro");
        guardar=new JButton("Guardar");
        cancelar=new JButton("Cancelar");
        this.setLayout(new GridLayout(0,1));
        this.add(nombreInput);
        this.add(generoInput);
        this.add(guardar);
        this.add(cancelar);

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreInput.setText("");
                generoInput.setSelectedItem("");

            }
        });

        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre=nombreInput.getText();
                String genero=generoInput.getSelectedItem().toString();
                Teacher t= new Teacher(nombre, genero,new Date());
                System.out.println(t.toString());
            }
        });
    }

}
