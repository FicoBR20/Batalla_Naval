package Control;

import modelo.Tablero;
import vista.FondoPanel;
import vista.GUI;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class Alinear {
    private GUI gui;
    private FondoPanel fondoPanel;
    private Tablero tablero;


    private JPanel pane_flota;
    private JButton boton_porta;
    private JButton boton_sub;
    private JButton boton_des;
    private JButton boton_frag;
    private JButton boton_orientacion;
    private Escucha escucha;
    private String orientacion;



    public Alinear() {
        //Nota static responsive
        escucha = new Escucha();
        orientacion = "V";

        pane_flota = new JPanel();
        boton_porta = new JButton("Porta avion");
        boton_sub = new JButton("Submarino");
        boton_des = new JButton("Destructor");
        boton_frag = new JButton("Fragata");
        boton_orientacion = new JButton("Orientacion");

        boton_porta.addActionListener(escucha);
        boton_sub.addActionListener(escucha);
        boton_des.addActionListener(escucha);
        boton_frag.addActionListener(escucha);
        boton_orientacion.addActionListener(escucha);

        pane_flota.add(boton_frag);
        pane_flota.add(boton_des);
        pane_flota.add(boton_sub);
        pane_flota.add(boton_porta);
        pane_flota.add(boton_orientacion);


        gui = new GUI();
        fondoPanel = new FondoPanel();
        tablero = new Tablero();
//        tablero.bloquear_rejilla();


        JButton button = new JButton();
        button.setPreferredSize(new Dimension(50,50));

        fondoPanel = new FondoPanel();
        fondoPanel.set_ruta_fondo("/recursos/fondo_1.png");

        fondoPanel.add(tablero, BorderLayout.CENTER);

        gui.add(fondoPanel, BorderLayout.CENTER);
        gui.add(pane_flota, BorderLayout.SOUTH);
        gui.setSize(new Dimension(500,450));
        gui.setVisible(true);
    }

    public static void main(String[] args) {

        Alinear lanzar = new Alinear();
    }

    public class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == boton_frag){
                tablero.sest_tamaño_HV(1,orientacion);
                JOptionPane.showMessageDialog(null, "Fragata ");
                System.out.println("tobs");
            }
            if (e.getSource() == boton_des){
                tablero.sest_tamaño_HV(2,orientacion);
                JOptionPane.showMessageDialog(null, "Destructores ");
                System.out.println("tobs");
            }
            if (e.getSource() == boton_sub){
                tablero.sest_tamaño_HV(3,orientacion);
                JOptionPane.showMessageDialog(null, "Submarino ");
                System.out.println("tobs");
            }
            if (e.getSource() == boton_porta){
                tablero.sest_tamaño_HV(4,orientacion);
                JOptionPane.showMessageDialog(null, "Porta aviones ");
                System.out.println("tobs");
            }
            if (e.getSource() == boton_orientacion){
                if (orientacion == "H"){
                    orientacion = "V";
                }
                else if (orientacion == "V"){
                    orientacion = "H";
                }
                JOptionPane.showMessageDialog(null, "Orientacion ahora es "+orientacion);
            }
    }

    }
}
