package mx.anahuac.views;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame ventana=new JFrame();
        ventana.setSize(200,300);
        ventana.setLayout(new BorderLayout());

        PanelNuevoMaestro panel=new PanelNuevoMaestro();
        ventana.add(panel,BorderLayout.CENTER);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
