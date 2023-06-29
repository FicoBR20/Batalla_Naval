package Control;

import Modelo.Tablero;
import vista.FondoPanel;
import vista.GUI;

import javax.swing.*;
import java.awt.*;

public class Lanzar {
    private GUI gui;
    private FondoPanel fondoPanel;
    private Tablero tablero;

    public Lanzar() {
        gui = new GUI();
        fondoPanel = new FondoPanel();
        tablero = new Tablero();
        fondoPanel = new FondoPanel();
        fondoPanel.set_ruta_fondo("/recursos/fondo_1.png");

        fondoPanel.add(tablero, BorderLayout.CENTER);
        gui.add(fondoPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Lanzar lanzar = new Lanzar();
    }
}
