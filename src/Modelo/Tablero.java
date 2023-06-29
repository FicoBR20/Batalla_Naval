package Modelo;

import vista.FondoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tablero extends FondoPanel {

    private  Casilla[][] casilla;
    private Escucha escucha;

    public Tablero() {
        set_ruta_fondo("/recursos/fondo.png");
        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(new Color(0xF192C8));
        set_tablero();
        ubicar_flota_persona();
//        bloquear_rejilla();
//        tablero_random();
    }

    private void set_tablero() {
        GridBagConstraints gbc = new GridBagConstraints();
        casilla = new Casilla[11][11];
        escucha = new Escucha();

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                casilla[i][j] = new Casilla();
                casilla[i][j].set_estado(1);
                casilla[i][j].addActionListener(escucha);
                casilla[i][j].set_fila_columna(i,j);
                casilla[i][j].set_estado(1);
                casilla[i][j].setFont(new Font(Font.SERIF,Font.BOLD,20));
                casilla[i][j].setForeground(new Color(0xFFFFFF));

                gbc.gridx=i; // columna 0
                gbc.gridy=j; // fila 0
                gbc.gridwidth=1; // ocupara 4 columnas
                gbc.gridheight=1; // ocupara 3 filas
                this.add(casilla[i][j],gbc);

                casilla[0][j].setText(String.valueOf(j));
                casilla[0][j].setBorder(BorderFactory.createTitledBorder(""));
                casilla[0][j].lock();
            }
                char letra = (char) (64+i);
                casilla[i][0].setText(String.valueOf(letra));
                casilla[i][0].setBorder(BorderFactory.createTitledBorder(""));
                casilla[i][0].lock();
        }
        casilla[0][0].setText("");
    }

    private void ubicar_flota_persona() {
        casilla[1][1].set_estado(3);
        casilla[3][3].set_estado(3);
        casilla[2][2].set_estado(4);
        casilla[5][1].set_estado(5);
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

//                        JOptionPane.showMessageDialog(null,
//                                        "\nNuevo EStado "+
//                                        casilla[i][j].get_estado());
                    }
                }
            }
        }
    }
}