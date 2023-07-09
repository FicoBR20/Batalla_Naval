package Modelo;

import modelo.Coordenada;
import vista.FondoPanel;
import modelo.Armamento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tablero extends FondoPanel {

    private Coordenada coordenada;

    private Armamento armamento;

    /**
     * Atributo que corresponde a un arreglo
     * bidiemensional de tipo Casilla.
     */
    private  Casilla[][] casilla;
    /**
     * Atributo de la  clase privada Escucha
     * que implementa el ActionLIstener.
     */
    private Escucha escucha;

    public Tablero() {
        coordenada=new Coordenada();
        armamento = new Armamento();
        set_ruta_fondo("/recursos/fondo.png");
        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(new Color(0xF192C8));
        set_tablero(); // configuracion inicial de los JButtons
        ubicar_flota_persona();
//        bloquear_rejilla();
//        tablero_random();
    }

    /**
     * Metodo que configura el estado inicial de
     * la cuadricula, compuesta por objetos tipo
     * Casilla los cuales extienden JButtons.
     */
    private void set_tablero() {
        GridBagConstraints gbc = new GridBagConstraints();
        casilla = new Casilla[11][11];
        escucha = new Escucha();

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                casilla[i][j] = new Casilla();
                casilla[i][j].set_estado(1);
                casilla[i][j].addActionListener(escucha);
                casilla[i][j].set_fila_columna(j,i);
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

    private void re_ubicar_Flota(){
        armamento.setNombre_Arma("PortaAviones");
        coordenada.setNumero_Fila(1);
        coordenada.setLetra_Columna("A");
        armamento.setProa_Nave(coordenada);//Bomper del Barco
        armamento.setIs_rotate();//va girado.




    }

    /**
     * Metodo alternativo para ubicar una "flota" o
     * un conjunto de Naves de combate.
     */
    private void ubicar_flota_persona() {
        rellenar(1,1,"v",4);
        rellenar(3,3,"h",3);
        rellenar(2,8,"h",3);
    }


    /**
     * Metodo alternativo para ubicacion de una nave en el
     * campo de batalla
     * @param fila
     * @param columna
     * @param orientacion
     * @param tamaño
     */
    private void rellenar(int fila, int columna, String orientacion, int tamaño) {
        if (orientacion == "v"){
            if (fila <= 11 - tamaño ){
                for (int i = 0; i < tamaño; i++) {
                    casilla[columna][fila].set_estado(4);
//                    casilla[columna][fila].es_flota();
                    fila++;
                }
            }else {
                JOptionPane.showMessageDialog(null, "Fuera de rango");
            }
        }
        else if (orientacion == "h"){
            if (columna <= 11 - tamaño ){
                for (int i = 0; i < tamaño; i++) {
                    casilla[columna][fila].set_estado(4);
                    columna++;
                }
            } else {
            JOptionPane.showMessageDialog(null, "Fuera de rango");
        }
        }
    }

    /**
     * Metodo que desabilita el tablero.
     * setEnable(false).
     */
    private void bloquear_rejilla() {
    }

    /**
     * Metodo que configura la flota del
     * jugador Random.
     */
    private void tablero_random() {
    }

    /**
     * Clase privada que configura la escucha
     * mediante la implementacion del Action listener.
     */
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
                                        "\nEstado de la casilla "+
                                        casilla[i][j].get_estado());

                        casilla[i][j].cambia_estado();

                    }
                }
            }
        }
    }
}