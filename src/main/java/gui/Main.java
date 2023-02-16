package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {

    public JLabel etiqueta;
    int contador = 0;

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getID());
        System.out.println(e.getSource());
        System.out.println(e.getActionCommand());
        if (e.getActionCommand()=="reiniciar"){
            contador=0;
        }else{
            contador = contador + 1;
        }
        this.etiqueta.setText("Texto modificado: " +e.getActionCommand()+"->"+ contador);
    }

    public static void main(String[] args) {

        Main m = new Main();
        JFrame ventana = new JFrame();
        ventana.setSize(300, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana.setLayout(new BorderLayout());

        m.etiqueta = new JLabel("hello world");
        JButton boton = new JButton("boton uno");
        JButton boton2 = new JButton("reiniciar");

        boton.addActionListener(m);
        boton2.addActionListener(m);

        PanelCentral panelCentro = new PanelCentral();
        panelCentro.add(boton2);
        ventana.add(m.etiqueta, BorderLayout.NORTH);
        ventana.add(boton, BorderLayout.SOUTH);
        ventana.add(panelCentro, BorderLayout.CENTER);

        ventana.setVisible(true);

    }

}
