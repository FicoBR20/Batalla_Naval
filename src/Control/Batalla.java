package Control;

import modelo.Casilla;
import modelo.Tablero;
import vista.FondoPanel;
import vista.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Batalla {
    private GUI gui;
    private FondoPanel fondoPanel;
    private Tablero tablero;
    private Tablero tablero2;
    private Escucha escucha;

    public Batalla() {
        gui = new GUI();
        fondoPanel = new FondoPanel();
        tablero = new Tablero();
        tablero.addMouseListener(escucha);
//        tablero.bloquear_rejilla();
        tablero2 = new Tablero();
        tablero2.addMouseListener(escucha);

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
        Batalla batalla = new Batalla();
    }

    public class Escucha implements MouseListener,ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }


        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
