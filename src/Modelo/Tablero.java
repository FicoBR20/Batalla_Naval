package modelo;

import vista.FondoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Tablero extends FondoPanel {

    private  Casilla[][] casilla;
    private Escucha escucha;
    private int matris;
    private int posicionesDeDisparosHechos[][];
    private int flota_cpu;
    private int tamaño_flota_cpu;
    private int daño;
    private int estado_tablero;
    /**
     * cantidad de cuadritos de la nave
     */
    private int tamaño;
    private int contador;
    private int toques;
    private int fragata_count;
    private int destru_count;
    private int subma_count;
    private int porta_count;
    private String orientacion;

    public Tablero() {
        escucha = new Escucha();
        contador =0;
        toques =0;

        fragata_count =0;
        destru_count =0;
        subma_count =0;
        porta_count =0;

        flota_cpu = 10;
        tamaño_flota_cpu = 1;
        tamaño =3;
        estado_tablero = 0;
        matris = 12;
        daño = 0;
        casilla = new Casilla[matris][matris];
        set_ruta_fondo("/recursos/fondo.png");
        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
        this.setPreferredSize(new Dimension(350,350));
        this.setBackground(new Color(0xF192C8));
        this.setFocusable(true);
        dibujar_tablero();
        dibijar_bloques();
    }

    public void dibujar_tablero() {
        int count = 0;
        GridBagConstraints gbc = new GridBagConstraints();
        for (int fila = 0; fila < matris; fila++) {
            for (int columna = 0; columna < matris; columna++) {
                casilla[fila][columna] = new Casilla();
                casilla[fila][columna].set_estado(1);
                casilla[fila][columna].addActionListener(escucha);
                casilla[fila][columna].addMouseListener(escucha);
                //nota set de datos de la casilla
//                casilla[i][j].set_fila_columna(j,i);
                casilla[fila][columna].recoger_datos(fila,columna,"",0);
                casilla[fila][columna].setFont(new Font(Font.SERIF,Font.BOLD,10));
                casilla[fila][columna].setForeground(new Color(0xFFFFFF));

                gbc.gridx=columna; // columna 0
                gbc.gridy=fila; // fila 0
                gbc.gridwidth=1; // ocupara 4 columnas
                gbc.gridheight=1; // ocupara 3 filas
                this.add(casilla[fila][columna],gbc);
            }
        }
    }

    public void dibijar_bloques() {
        for (int i = 0; i < matris; i++) {
            char letra = (char) (64+i);
            //Bloque vertical oeste del tablero
            casilla[0][i].setText(String.valueOf(letra));
            casilla[0][i].setBorder(BorderFactory.createTitledBorder(""));
            casilla[0][i].bloque();
            casilla[0][i].set_estado(99);

            //Bloque vertical este del tablero
            casilla[11][i].bloque();
            casilla[11][i].set_estado(99);

            //Bloque horizontales norte del tablero
            casilla[i][0].setText(String.valueOf(i));

            casilla[i][0].bloque();
            casilla[i][0].set_estado(99);

            //Bloque horizontales sur del tablero
            casilla[i][11].bloque();
            casilla[i][11].set_estado(99);

            //Esquinas del tablero
            casilla[0][0].setText("");
            casilla[11][0].setText("");
            casilla[0][11].setText("");
            casilla[i][11].setText("");
            casilla[11][i].setText("");

        }
    }

    public int comprobar_set_flota(int fila, int columna, String orientacion, int tamaño) {
        if (orientacion == "V"){
            contador = 0;
            for (int i = 0; i < tamaño; i++) {
                if (fila+i < matris){
                    if (casilla[fila+i][columna].get_estado()!=1){
                        contador++;
                    }
                }
            }

        }
        if (orientacion == "H"){
            contador = 0;
            for (int i = 0; i < tamaño; i++) {
                if (columna+i < matris){
                    if (casilla[fila][columna+i].get_estado()!=1){
                        contador++;
                    }
                }
            }
        }

        return contador;
    }

    public void poner_flota(int fila, int columna, String orientacion, int tamaño) {
        if (orientacion == "V"){
            if (fila <= matris - tamaño ){
                fila--;
                columna--;
                for (int i = 0; i <= tamaño+1; i++) {
                    for (int j = 0; j < 3; j++) {
                        if(fila+i<matris && columna+j<matris){
                            casilla[fila+i][columna+j].set_estado(0);
                            casilla[fila+i][columna+j].limite();

                        }
                    }
                }
                columna ++;
                fila++;
                for (int j = 0; j < tamaño; j++) {
                    if(fila+j<matris){
                        casilla[fila+j][columna].set_estado(4);
                        casilla[fila+j][columna].flota(tamaño,j,orientacion);

                    }
                }
            }
        }
        if (orientacion == "H"){
            if (columna <= matris - tamaño ){
                fila--;
                columna--;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j <= tamaño+1; j++) {
                        if(fila+i<matris && columna+j<matris){
                            casilla[fila+i][columna+j].set_estado(0);
                            casilla[fila+i][columna+j].limite();

                        }
                    }
                }
                columna ++;
                fila++;
                for (int j = 0; j < tamaño; j++) {
                    if(columna+j<matris){
                        casilla[fila][columna+j].set_estado(4);
                        casilla[fila][columna+j].flota(tamaño,j,orientacion);

                    }
                }
            }
        }


//        else if (orientacion == "H"){
//            if (columna <= matris - tamaño ){
//
//                fila--;
//                columna--;
//                for (int i = 0; i < 3; i++) {
//                    for (int j = 0; j <= tamaño+1; j++) {
//                        casilla[fila+i][columna+j].set_estado(0);
//                        casilla[fila+i][columna+j].limite();
//                    }
//                }
//                columna ++;
//                fila++;
//                for (int i = 0; i < tamaño; i++) {
//                    casilla[fila][columna+i].set_estado(4);
//                    casilla[fila][columna+i].flota(tamaño,i,orientacion);
//                }
//            }
//        }
    }

    public void tablero_random() {
        while (flota_cpu > 0) {
            Random random = new Random();
            int fila = random.nextInt(1,10);
            random = new Random();
            int columna = random.nextInt(1,10);
            random = new Random();
            int aleatorio = random.nextInt(1,10);
            String orientacion = "";

            if (aleatorio%2 == 1){
                orientacion = "H";
            }
            else if(aleatorio%2 == 0){
                orientacion = "V";
            }

            if (orientacion == "V" && fila < matris - tamaño_flota_cpu){
                if (comprobar_set_flota(fila,columna,orientacion,tamaño_flota_cpu)==0){

                    if (flota_cpu<=4) {
                        tamaño_flota_cpu = 1;
                        poner_flota(fila,columna,orientacion,tamaño_flota_cpu);
                    }
                    else if (flota_cpu <= 7) {
                        tamaño_flota_cpu = 2;
                        poner_flota(fila,columna,orientacion,tamaño_flota_cpu);
                    }
                    else if (flota_cpu <= 9) {
                        tamaño_flota_cpu = 3;
                        poner_flota(fila,columna,orientacion,tamaño_flota_cpu);
                    }
                    else if (flota_cpu == 10) {
                        tamaño_flota_cpu = 4;
                        poner_flota(fila,columna,orientacion,tamaño_flota_cpu);
                    }
                    flota_cpu--;
                }
                else {
                    tablero_random();
                }

            }
            else if(orientacion == "H" && columna < matris - tamaño_flota_cpu){
                if (comprobar_set_flota(fila,columna,orientacion,tamaño_flota_cpu)==0){

                    if (flota_cpu<=4) {
                        tamaño_flota_cpu = 1;
                        poner_flota(fila,columna,orientacion,tamaño_flota_cpu);
                    }
                    else if (flota_cpu <= 7) {
                        tamaño_flota_cpu = 2;
                        poner_flota(fila,columna,orientacion,tamaño_flota_cpu);
                    }
                    else if (flota_cpu <= 9) {
                        tamaño_flota_cpu = 3;
                        poner_flota(fila,columna,orientacion,tamaño_flota_cpu);
                    }
                    else if (flota_cpu == 10) {
                        tamaño_flota_cpu = 4;
                        poner_flota(fila,columna,orientacion,tamaño_flota_cpu);
                    }
                    flota_cpu--;
                }
                else {
                    tablero_random();
                }
            }


        }
    }

    //________________________________________________________________
    public void inicializarDisparosRealizados(){
        for (int j=0; j<11;j++){
            for (int i=0; i<11; i++){
                posicionesDeDisparosHechos[j][i]=0;
            }
        }
    }

    public boolean preguntarPorDisparo(int fila,int columna) {
        boolean seDisparo = true;
        if (posicionesDeDisparosHechos[fila][columna] == 0) {
            seDisparo = false;
        } else if (posicionesDeDisparosHechos[fila][columna] == 1) {
            seDisparo = true;
        }
        return seDisparo;
    }

    public void disparar(Tablero unTablero){

        Random randomfila = new Random();
        int fila = randomfila.nextInt( 10- 1 + 1) + 1;

        Random randomColumna = new Random();
        int columna = randomColumna.nextInt( 10- 1 + 1) + 1;

        while (preguntarPorDisparo(fila,columna)){
            fila = randomfila.nextInt( 10- 1 + 1) + 1;
            columna = randomColumna.nextInt( 10- 1 + 1) + 1;
        }

        posicionesDeDisparosHechos[fila][columna]=1;
        (unTablero.getCasilla())[fila][columna].cambia_estado();

    }

    //________________________________________________________________

    public void ocultar_rejillas() {
        for (int fila = 1; fila < matris-1; fila++) {
            for (int columna = 1; columna < matris-1; columna++) {
                casilla[fila][columna].agua();
            }
        }
    }

    public void limpiar_tablero() {
        for (int fila = 0; fila < matris; fila++) {
            for (int columna = 0; columna < matris; columna++) {
                casilla[fila][columna].set_estado(1);
                casilla[fila][columna].agua();
            }
        }
    }



    public void set_flota(int fila, int columna, String orientacion, int tamaño) {
//        int f = fila;
//        int c = columna;
//        if (orientacion == "V"){
//            if (fila < matris - tamaño ){
//                if (casilla[columna][fila].get_estado()==1){
//                    for (int i = 0; i < tamaño; i++) {
//                        casilla[columna][fila].set_estado(4);
//                        casilla[columna][fila].flota(tamaño,i,orientacion);
//                        casilla[columna][fila].recoger_datos(f,c,orientacion,tamaño);
//                        fila++;
//                    }
//                }
//            }
//        }
//
//        else if (orientacion == "H"){
//            if (columna < matris - tamaño ){
//
//                if (casilla[columna][fila].get_estado()==1){
//                    for (int i = 0; i < tamaño; i++) {
//                        casilla[columna][fila].set_estado(4);
//                        casilla[columna][fila].flota(tamaño,i,orientacion);
//                        casilla[columna][fila].recoger_datos(f,c,orientacion,tamaño);
//                        columna++;
//                    }
//                }
//            }
//        }
    }

    public void destruido(int fila, int columna, String orientacion, int tamaño) {
//        if (orientacion == "V"){
//            //verificador
//
//            for (int i = 0; i < tamaño; i++) {
//                if (casilla[fila][columna+i].get_estado()==3){
//                    daño++;
//                }
//            }
////            JOptionPane.showMessageDialog(null,"Daño "+daño);
//            //Nota bomba
////            if (fila <= matris - tamaño ){
//            if (daño == tamaño){
//                columna--;
//                fila--;
//                for (int i = 0; i <= tamaño+1; i++) {
//                    for (int j = 0; j < 3; j++) {
//                        casilla[fila+i][columna+j].set_estado(0);
//                        casilla[fila+i][columna+j].equis();
//                    }
//                }
//                columna ++;
//                fila++;
//                for (int j = 0; j < tamaño; j++) {
//                    casilla[fila][columna+j].set_estado(99);
//                    casilla[fila][columna+j].flota_derribada(tamaño,j,orientacion);
//                }
//                dibijar_bloques();
//
//            }
//        }
//        else if (orientacion == "H"){
//
//            for (int i = 0; i < tamaño; i++) {
//                if (casilla[fila+i][columna].get_estado()==3){
//                    daño++;
//                }
//            }
////                JOptionPane.showMessageDialog(null,"Daño "+daño);
//
//            if (daño == tamaño){
//
//                columna--;
//                fila--;
//                for (int i = 0; i < 3; i++) {
//                    for (int j = 0; j <= tamaño+1; j++) {
//                        casilla[fila+i][columna+j].set_estado(99);
//                        casilla[fila+i][columna+j].equis();
//                    }
//                }
//                columna ++;
//                fila++;
//                for (int j = 0; j < tamaño; j++) {
//                    casilla[fila+j][columna].set_estado(0);
//                    casilla[fila+j][columna].flota_derribada(tamaño,j,orientacion);
//                }
//                dibijar_bloques();
//            }
//        }
//        daño=0;
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


    public void sest_tamaño_HV(int tamaño, String orientacion) {
        this.tamaño=tamaño;
        this.orientacion=orientacion;
    }

    public int get_estado() {
        return estado_tablero;
    }

    public void set_estado(int estado_tablero) {
        this.estado_tablero = estado_tablero;
    }

    public int get_tamaño() {
        return  tamaño;
    }

    public Casilla[][] getCasilla() {
        return casilla;
    }

    public int gettoques() {
        return  toques;
    }


    public class Escucha implements ActionListener, MouseListener {


        @Override
        public void actionPerformed(ActionEvent e) {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            //Estado "0" el tablero permite setear las casillas
            if (estado_tablero == 0){
                for (int i = 0; i < matris; i++) {
                    for (int j = 0; j < matris; j++) {

                        if (e.getSource()==casilla[i][j]){
                            int test = comprobar_set_flota(i,j,orientacion,tamaño);
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

//                        System.out.println("POS "+comprobar_set_flota(i,j,orientacion,tamaño));
                            if (test == 0) {
                                poner_flota(i, j, orientacion, tamaño);
                            }

                        }
                    }
                }
            }

            //Estado "1" el tablero permite jugar
            else if (estado_tablero == 1){
                for (int i = 0; i < matris; i++) {
                    for (int j = 0; j < matris; j++) {

                        if (e.getSource()==casilla[i][j]){
                            //Obtengo la coordenada completa de la flota
                            int f = casilla[i][j].getFila();
                            int c = casilla[i][j].getColumna_int();
                            String o = casilla[i][j].get_orientacion();
                            int t = tamaño;

                            casilla[i][j].cambia_estado();
                            destruido(f,c,o,t);
                        }
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

            if (estado_tablero == 0){
                for (int i = 1; i < matris-1; i++) {
                    for (int j = 1; j < matris-1; j++) {
                        if (e.getSource()==casilla[i][j]
                                && (j < matris - tamaño || i < matris - tamaño)
                                && comprobar_set_flota(i,j,orientacion,tamaño)==0){

                            //Rellena con el tamaño de lanflota
                            for (int k = 0; k < tamaño; k++) {
                                if ( orientacion == "H"){
                                    casilla[i][j+k].flota(tamaño,k,orientacion);
                                }
                                else if ( orientacion == "V" ){
                                    casilla[i+k][j].flota(tamaño,k,orientacion);
                                }
                            }
                        }
                    }
                }

            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (estado_tablero == 0){
                for (int i = 1; i < matris-1; i++) {
                    for (int j = 1; j < matris-1; j++) {
                        if (e.getSource()==casilla[i][j]
                                && (j < matris - tamaño || i < matris - tamaño)
                                && comprobar_set_flota(i,j,orientacion,tamaño)==0){
                            //Rellena con el tamaño de lanflota
                            for (int k = 0; k < tamaño; k++) {
                                if ( orientacion == "H" ){
                                    casilla[i][j+k].agua();
                                }
                                else if ( orientacion == "V"){
                                    casilla[i+k][j].agua();
                                }
                            }
                        }
                    }
                }

            }
        }
    }
}