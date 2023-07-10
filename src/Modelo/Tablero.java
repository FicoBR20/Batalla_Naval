package Modelo;

import vista.FondoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Tablero extends FondoPanel {

    private  Modelo.Casilla[][] casilla;
    private Escucha escucha;
    private int matris;
    private int daño;

    public Tablero() {
        matris = 12;
        daño = 0;
        casilla = new Modelo.Casilla[matris][matris];
        set_ruta_fondo("/recursos/fondo.png");
        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(new Color(0xF192C8));
        dibujar_tablero();
//        tablero_random();
        ubicar_flota_persona();
        dibijar_bloques();
//        bloquear_rejilla();
    }

    public void ocultar_flotas() {

    }

    public void dibujar_tablero() {
        GridBagConstraints gbc = new GridBagConstraints();

        escucha = new Escucha();

        for (int i = 0; i < matris; i++) {
            for (int j = 0; j < matris; j++) {
                casilla[i][j] = new Modelo.Casilla();
                casilla[i][j].set_estado(1);
                casilla[i][j].addActionListener(escucha);
                //nota set de datos de la casilla
//                casilla[i][j].set_fila_columna(j,i);
                casilla[i][j].recoger_datos(j,i,"",0);
                casilla[i][j].setFont(new Font(Font.SERIF,Font.BOLD,20));
                casilla[i][j].setForeground(new Color(0xFFFFFF));

                gbc.gridx=i; // columna 0
                gbc.gridy=j; // fila 0
                gbc.gridwidth=1; // ocupara 4 columnas
                gbc.gridheight=1; // ocupara 3 filas
                this.add(casilla[i][j],gbc);
            }
        }
    }

    public void dibijar_bloques() {
        for (int i = 0; i < matris; i++) {
            //Bloque vertical oeste del tablero
            casilla[0][i].setText(String.valueOf(i));
            casilla[0][i].setBorder(BorderFactory.createTitledBorder(""));
            casilla[0][i].bloque();
            casilla[0][i].set_estado(99);

            //Bloque vertical este del tablero
            casilla[11][i].bloque();
            casilla[11][i].set_estado(99);

            //Nota Letras de coordendas
            //Bloque horizontales norte del tablero
            char letra = (char) (64+i);
            casilla[i][0].setText(String.valueOf(letra));

//            casilla[i][0].setText(String.valueOf(i));
            casilla[i][0].bloque();
            casilla[i][0].set_estado(99);

            //Bloque horizontales sur del tablero
            casilla[i][11].bloque();
            casilla[i][11].set_estado(99);

            //Esquinas del tablero
            casilla[0][0].setText("");
            casilla[11][0].setText("");
            casilla[0][11].setText("");

        }
    }


    public void ubicar_flota_persona() {
        //Porta aviones
        rellenar_flota(1,1,"V",4);

//        //Submarinos
        rellenar_flota(8,5,"H",3);
        rellenar_flota(6,3,"V",3);
//
//        //Destructores
        rellenar_flota(2,5,"H",2);
        rellenar_flota(10,1,"H",2);
        rellenar_flota(5,5,"V",2);
//
//        //Fragatas
        rellenar_flota(4,9,"V",1);
        rellenar_flota(1,3,"V",1);
        rellenar_flota(1,8,"H",1);
        rellenar_flota(7,9,"H",1);
    }


    /**
     * Este metodo llena la casillas del tablero con el tipo de flota
     * @param fila
     * @param columna
     * @param orientacion
     * @param tamaño
     */
    public void set_flota(int fila, int columna, String orientacion, int tamaño) {
        int f = fila;
        int c = columna;
        if (orientacion == "V"){
            if (fila < matris - tamaño ){

                if (casilla[columna][fila].get_estado()!=1){
                        fila++;
                    for (int i = 0; i < tamaño; i++) {
                        casilla[columna][fila].set_estado(4);
                        casilla[columna][fila].flota(tamaño,i,orientacion);
                        casilla[columna][fila].recoger_datos(f,c,orientacion,tamaño);
                        columna++;
                    }
                }
                else {
                    for (int i = 0; i < tamaño; i++) {
                        casilla[columna][fila].set_estado(4);
                        casilla[columna][fila].flota(tamaño,i,orientacion);
                        casilla[columna][fila].recoger_datos(f,c,orientacion,tamaño);
                        fila++;
                    }

                }

            }else {
                JOptionPane.showMessageDialog(null, "Fuera de rango");
            }
        }

        else if (orientacion == "H"){
            if (columna < matris - tamaño ){

                if (casilla[columna][fila].get_estado()!=1){
                        columna++;
                    for (int i = 0; i < tamaño; i++) {
                        casilla[columna][fila].set_estado(4);
                        casilla[columna][fila].flota(tamaño,i,orientacion);
                        casilla[columna][fila].recoger_datos(f,c,orientacion,tamaño);
                        fila++;
                    }
                }
                else {
                    for (int i = 0; i < tamaño; i++) {
                        casilla[columna][fila].set_estado(4);
                        casilla[columna][fila].flota(tamaño,i,orientacion);
                        casilla[columna][fila].recoger_datos(f,c,orientacion,tamaño);
                        columna++;
                    }
                }
            } else {
            JOptionPane.showMessageDialog(null, "Fuera de rango");
            }
        }

    }
    public void rellenar_flota(int fila, int columna, String orientacion, int tamaño) {
        limite_flota( fila,  columna,  orientacion,  tamaño);
//        destruido( fila,  columna,  orientacion,  tamaño);
        set_flota( fila,  columna,  orientacion,  tamaño);
    }

    public void limite_flota(int fila, int columna, String orientacion, int tamaño) {
        if (orientacion == "V"){
            if (fila <= matris - tamaño ){
                columna--;
                fila--;
                for (int i = 0; i <= tamaño+1; i++) {
                    for (int j = 0; j < 3; j++) {
                        casilla[columna+j][fila+i].set_estado(0);
                        casilla[columna+j][fila+i].limite();
                    }
                }
                columna ++;
                fila++;
                for (int j = 0; j < tamaño; j++) {
                    casilla[columna][fila+j].set_estado(1);
                    casilla[columna][fila+j].agua();
                }
            }
        }
        else if (orientacion == "H"){
            if (columna <= matris - tamaño ){

                columna--;
                fila--;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j <= tamaño+1; j++) {
                        casilla[columna+j][fila+i].set_estado(0);
                        casilla[columna+j][fila+i].limite();
                    }
                }
                columna ++;
                fila++;
                for (int j = 0; j < tamaño; j++) {
                    casilla[columna+j][fila].set_estado(1);
                    casilla[columna+j][fila].agua();
                }
            }
        }
    }

    public void destruido(int fila, int columna, String orientacion, int tamaño) {
        if (orientacion == "V"){
            //verificador

            for (int i = 0; i < tamaño; i++) {
                if (casilla[columna][fila+i].get_estado()==3){
                    daño++;
                }
            }
//            JOptionPane.showMessageDialog(null,"Daño "+daño);
            //Nota bomba
//            if (fila <= matris - tamaño ){
            if (daño == tamaño){
                columna--;
                fila--;
                for (int i = 0; i <= tamaño+1; i++) {
                    for (int j = 0; j < 3; j++) {
                        casilla[columna+j][fila+i].set_estado(0);
                        casilla[columna+j][fila+i].equis();
                    }
                }
                columna ++;
                fila++;
                for (int j = 0; j < tamaño; j++) {
                    casilla[columna][fila+j].set_estado(99);
                    casilla[columna][fila+j].flota_derribada(tamaño,j,orientacion);
                }
                dibijar_bloques();

            }
        }
        else if (orientacion == "H"){

            for (int i = 0; i < tamaño; i++) {
                if (casilla[columna+i][fila].get_estado()==3){
                    daño++;
                }
            }
//                JOptionPane.showMessageDialog(null,"Daño "+daño);

            if (daño == tamaño){

                columna--;
                fila--;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j <= tamaño+1; j++) {
                        casilla[columna+j][fila+i].set_estado(99);
                        casilla[columna+j][fila+i].equis();
                    }
                }
                columna ++;
                fila++;
                for (int j = 0; j < tamaño; j++) {
                    casilla[columna+j][fila].set_estado(0);
                    casilla[columna+j][fila].flota_derribada(tamaño,j,orientacion);
                }
                dibijar_bloques();
            }
        }
        daño=0;
    }

    public void bloquear_rejilla() {
        for (int i = 0; i < matris; i++) {
            for (int j = 0; j < matris; j++) {
                casilla[i][j].agua();
            }
        }
        dibijar_bloques();
    }

    public void ver_etado_flota(int fila, int columna, String orientacion, int tamaño) {

        int daño = 0;
        for (int i = 0; i < matris; i++) {
            for (int j = 0; j < matris; j++) {
                if(casilla[fila][columna].get_estado() == 3){
                    daño ++;
                }else {
                    daño--;
                }
            }
        }
        if (daño == tamaño){

        }
    }

    public void tablero_random() {
        for (int i = 0; i < matris; i++) {
            Random random = new Random();
            int fila = random.nextInt(1,11);
            random = new Random();
            int columna = random.nextInt(1,11);
            random = new Random();
            int aleatorio = random.nextInt(1,10);
            String orientacion = "";
            if (aleatorio%2 == 1){
                orientacion = "H";
            }
            else if(aleatorio%2 == 0){
                orientacion = "V";
            }

            if (i<4) {
                rellenar_flota(fila,columna,orientacion,1);
            }
            else if (i < 7) {
                rellenar_flota(fila,columna,orientacion,2);
            }
            else if (i < 10) {
                rellenar_flota(fila,columna,orientacion,3);
            }
            else if (i < 11) {
                rellenar_flota(fila,columna,orientacion,4);
            }
        }
    }

    public class Escucha implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < matris; i++) {
                for (int j = 0; j < matris; j++) {

                    if (e.getSource()==casilla[i][j]){
                        //Obtengo la coordenada completa de la flota
                        int f = casilla[i][j].getFila();
                        int c = casilla[i][j].getColumna_int();
                        String o = casilla[i][j].get_orientacion();
                        int t = casilla[i][j].get_tamaño();


//                        JOptionPane.showMessageDialog(null,
//                                "tocado "+
//                                        "\nFila "+
//                                        casilla[i][j].getFila()+
//                                        "\nColumna "+
//                                        casilla[i][j].getColumna()+
//                                        "\nEstado de la casilla "+
//                                        casilla[i][j].get_estado()+
//                                        "\nTamaño "+
//                                        casilla[i][j].get_tamaño()+
//                                        "\nOrientacion "+
//                                        casilla[i][j].get_orientacion());

                        casilla[i][j].cambia_estado();
                        destruido(f,c,o,t);


                    }
                    else if (e.getSource() == casilla[0][0]){

                    }
                }
            }
        }
    }





















}