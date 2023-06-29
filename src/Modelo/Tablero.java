package Modelo;

import vista.FondoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tablero extends FondoPanel {

    private  int fila;
    private  int columna;
    private  Casilla[][] casilla;
    private Escucha escucha;

    public Tablero() {
//        set_ruta_fondo("/recursos/fondo.png");
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(new Color(0xF192C8));
        set_tablero();
        iniciar();
//        ubicar_flota_persona();
//        bloquear_rejilla();
//        tablero_random();
    }

    private void iniciar() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                this.add(casilla[i][j],BorderLayout.CENTER);
            }
        }
    }

    private void set_tablero() {
        casilla = new Casilla[11][11];
        escucha = new Escucha();

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                casilla[i][j] = new Casilla();
                casilla[i][j].set_estado(1);
                casilla[i][j].addActionListener(escucha);
                casilla[i][j].set_fila_columna(i,j);
                casilla[i][j].set_estado(3);
                casilla[i][j].setFont(new Font(Font.SERIF,Font.BOLD,20));
                casilla[i][j].setForeground(new Color(0xFFFFFF));

                char letra = (char) (64+j);
                casilla[0][j].setText(String.valueOf(letra));
                casilla[0][j].lock();
            }
                casilla[i][0].setText(String.valueOf(i));
                casilla[i][0].lock();
        }
    }

    private void ubicar_flota_persona() {
    }

    private void bloquear_rejilla() {
    }

    private void tablero_random() {
    }

    public class Escucha implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 11; j++) {
                    if (e.getSource()==casilla[i][j]){

                        JOptionPane.showMessageDialog(null,
                                "tocado "+
                                        "\nFila "+
                                        casilla[i][j].getFila()+
                                        "\nColumna "+
                                        casilla[i][j].getColumna()+
                                        "\nEStado "+
                                        casilla[i][j].get_estado());

                        casilla[i][j].cambia_estado();

                        JOptionPane.showMessageDialog(null,
                                        "\nNuevo EStado "+
                                        casilla[i][j].get_estado());
                    }
                }
            }
        }
    }
}