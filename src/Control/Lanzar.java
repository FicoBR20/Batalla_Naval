package Control;

import Modelo.Tablero;
import vista.FondoPanel;
import vista.GUI;

import javax.swing.*;
import java.awt.*;

public class Lanzar {
    private GUI gui;
    private FondoPanel fondoPanel; // maneja la asignacion de imagenes
    private Tablero tablero;

    public Lanzar() {
        gui = new GUI();
        fondoPanel = new FondoPanel();
        tablero = new Tablero();

        JButton button = new JButton();
        button.setPreferredSize(new Dimension(50,50));

        fondoPanel = new FondoPanel();
        fondoPanel.set_ruta_fondo("/recursos/fondo_1.png");

        fondoPanel.add(tablero, BorderLayout.CENTER);


        gui.add(fondoPanel, BorderLayout.CENTER);
        gui.setVisible(true);
    }

    public static void main(String[] args) {
        Lanzar lanzar = new Lanzar();
    }
}
