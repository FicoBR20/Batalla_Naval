package controlador;

import modelo.Tablero;
import vista.FondoPanel;
import vista.GUI_basica;

import javax.swing.*;
import java.awt.*;

public class Lanzar {
    private GUI_basica gui;
    private FondoPanel fondoPanel;
    private Tablero tablero;
    private Tablero tablero2;

    public Lanzar() {
        gui = new GUI_basica();
        fondoPanel = new FondoPanel();
        tablero = new Tablero();
        tablero.bloquear_rejilla();
        tablero2 = new Tablero();

        JButton button = new JButton();
        button.setPreferredSize(new Dimension(50,50));

        fondoPanel = new FondoPanel();
        fondoPanel.set_ruta_fondo("/recursos/fondo_1.png");

        fondoPanel.add(tablero, BorderLayout.CENTER);
        fondoPanel.add(tablero2, BorderLayout.CENTER);


        gui.add(fondoPanel, BorderLayout.CENTER);
        gui.setVisible(true);
    }

    public static void main(String[] args) {
        Lanzar lanzar = new Lanzar();
    }
}
