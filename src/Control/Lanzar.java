package Control;

import Modelo.Tablero;
import vista.GUI;

import javax.swing.*;
import java.awt.*;

public class Lanzar {
    public static void main(String[] args) {
        GUI gui = new GUI();
        Tablero tablero = new Tablero();
        Tablero tablero2 = new Tablero();
        JPanel panel = new JPanel();

        panel.add(tablero, BorderLayout.CENTER);
        panel.add(tablero2, BorderLayout.CENTER);

        gui.add(panel, BorderLayout.NORTH);
    }
}
