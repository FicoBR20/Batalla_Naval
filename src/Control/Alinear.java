package Control;

import modelo.Tablero;
import vista.FondoPanel;
import vista.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Alinear {
    private  int flota_jugador;

    private GUI gui;
    private FondoPanel fondoPanel;
    private Tablero tablero_jugador;
    private Tablero tablero_cpu;


    private JPanel pane_flota;
    private JButton boton_porta;
    private JButton boton_sub;
    private JButton boton_des;
    private JButton boton_frag;
    private JButton boton_rotar;
    private JButton boton_estado;
    private JButton boton_random;

    private Escucha escucha;
    private String orientacion;



    public Alinear() {
        //Nota static responsive
        escucha = new Escucha();
        orientacion = "V";
        flota_jugador = 0;

        pane_flota = new JPanel();
        boton_porta = new JButton("Porta avion");
        boton_sub = new JButton("Submarino");
        boton_des = new JButton("Empezar");
        boton_frag = new JButton("Fragarta ");
        boton_rotar = new JButton("rotar");
        boton_estado = new JButton("Jugar");
        boton_random = new JButton("Random");

        boton_porta.addActionListener(escucha);
        boton_sub.addActionListener(escucha);
        boton_des.addActionListener(escucha);
        boton_frag.addActionListener(escucha);
        boton_rotar.addActionListener(escucha);
        boton_estado.addActionListener(escucha);
        boton_random.addActionListener(escucha);

        pane_flota.add(boton_frag);
        pane_flota.add(boton_des);
        pane_flota.add(boton_sub);
        pane_flota.add(boton_porta);
        pane_flota.add(boton_estado);
        pane_flota.add(boton_rotar);
        pane_flota.add(boton_random);


        gui = new GUI();
        gui.addKeyListener(escucha);
        gui.setFocusable(true);
        fondoPanel = new FondoPanel();

        tablero_jugador = new Tablero();
        tablero_cpu = new Tablero();


        tablero_cpu = new Tablero();
        tablero_cpu.tablero_random();
//        tablero_cpu.ocultar_rejillas();
        tablero_cpu.dibijar_bloques();


        JButton button = new JButton();
        button.setPreferredSize(new Dimension(50,50));

        fondoPanel = new FondoPanel();
        fondoPanel.set_ruta_fondo("/recursos/fondo_1.png");

        fondoPanel.add(tablero_jugador, BorderLayout.CENTER);
        fondoPanel.add(tablero_cpu, BorderLayout.CENTER);

        gui.add(fondoPanel, BorderLayout.CENTER);
        gui.add(pane_flota, BorderLayout.SOUTH);
        gui.setSize(new Dimension(800,450));
        gui.setVisible(true);
    }

    public static void main(String[] args) {

        Alinear lanzar = new Alinear();
    }

    public class Escucha implements ActionListener, KeyListener, MouseListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == boton_frag){
                JOptionPane.showMessageDialog(null, "Edita tus flotas ");
                tablero_jugador.sest_tamaño_HV(1,orientacion);
            }
            if (e.getSource() == boton_des){
                tablero_jugador.sest_tamaño_HV(2,orientacion);
                JOptionPane.showMessageDialog(null, "Destructores ");
            }
            if (e.getSource() == boton_sub){
                tablero_jugador.sest_tamaño_HV(3,orientacion);
                JOptionPane.showMessageDialog(null, "Submarino ");
            }
            if (e.getSource() == boton_porta){
                tablero_jugador.sest_tamaño_HV(4,orientacion);
                JOptionPane.showMessageDialog(null, "Porta aviones ");
            }
            if (e.getSource() == boton_rotar){
                if (orientacion == "H"){
                    orientacion = "V";
//                    JOptionPane.showMessageDialog(null,
//                            "Orientacion ahora es "+orientacion+"ertical");
                }
                else if (orientacion == "V"){
                    orientacion = "H";
//                    JOptionPane.showMessageDialog(null,
//                            "Orientacion ahora es "+orientacion+"orizontal");
                }
                tablero_jugador.sest_tamaño_HV(tablero_jugador.get_tamaño(),orientacion);
            }
            if (e.getSource() == boton_estado){
                if (tablero_jugador.get_estado() == 0){
                    tablero_jugador.set_estado(1);
                    tablero_cpu.set_estado(1);
                    JOptionPane.showMessageDialog(null,
                            "Estado  "+tablero_jugador.get_estado()+" edicion");
                }
                else if (tablero_jugador.get_estado() == 1){
                    tablero_jugador.set_estado(0);
                    tablero_cpu.set_estado(0);
                    JOptionPane.showMessageDialog(null,
                            "Estado  "+tablero_jugador.get_estado()+" juego");
                }
            }

            if (e.getSource() == boton_random){
                tablero_jugador.limpiar_tablero();
//                tablero_jugador.dibujar_tablero();
                tablero_jugador.tablero_random();
                tablero_jugador.dibijar_bloques();

                JOptionPane.showMessageDialog(null, "Random" );
            }
    }



        @Override
        public void keyTyped(KeyEvent e) {

            if (e.getKeyChar() == 'r'){
                if (orientacion == "H"){
                    orientacion = "V";
//                    JOptionPane.showMessageDialog(null,
//                            "Orientacion ahora es "+orientacion+"ertical");
                }
                else if (orientacion == "V"){
                    orientacion = "H";
//                    JOptionPane.showMessageDialog(null,
//                            "Orientacion ahora es "+orientacion+"orizontal");
                }
                tablero_jugador.sest_tamaño_HV(tablero_jugador.get_tamaño(),orientacion);
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {

            for (int i = 1; i < 11; i++) {
                for (int j = 1; j < 11; j++) {

                    if (e.getSource()==tablero_jugador.getCasilla()[i][j]){
                        JOptionPane.showMessageDialog(null,"test");
                    }
                }
            }

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
