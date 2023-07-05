package Modelo;

import javax.swing.*;
import java.awt.*;


public class Casilla extends JButton {
    
    private  int estado;
    private  int turno;
    private int fila;
    private int tamaño;
    private String orientacion;
    private int columna;
    private ImageIcon imageIcon;

    public Casilla() {

        this.setBackground(null);
//        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setFocusable(false); //Quita linea de los botones
        iniciar();
    }

    public void iniciar() {
        turno = 1;
        this.setPreferredSize(new Dimension(40,40));
        agua();
    }

    /**
     * Estados
     */
    public void limite() {
        imageIcon = new ImageIcon(getClass().getResource("/recursos/limite.png"));
        this.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
    }

    public void agua() {
        imageIcon = new ImageIcon(getClass().getResource("/recursos/agua.png"));
        this.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
    }

    public void bloque() {
        imageIcon = new ImageIcon(getClass().getResource("/recursos/coordenadas.png"));
        this.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
    }

    public void flota(int tamaño, int cuerpo, String orientacion) {
            imageIcon = new ImageIcon(getClass().getResource("/recursos/flotas/"+orientacion+"/"+tamaño+cuerpo+".png"));
            this.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
    }

    public void flota_derribada(int tamaño, int cuerpo, String orientacion) {
        imageIcon = new ImageIcon(getClass().getResource("/recursos/flotas_derribada/"+orientacion+"/"+tamaño+cuerpo+".png"));
        this.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
    }

    public void tocado() {
        imageIcon = new ImageIcon(getClass().getResource("/recursos/tocado.png"));
        this.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
    }

    public void equis() {
        imageIcon = new ImageIcon(getClass().getResource("/recursos/equis.png"));
        this.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
        cambia_turno();
    }

    public void cambia_turno() {
        if (turno == 1){
            turno = 2;
        }
        else if (turno == 2){
            turno = 1;
        }
    }


    public int get_estado() {
        return estado;
    }

    public void set_estado(int estado) {
        this.estado = estado;
    }

    public void recoger_datos(int fila, int columna, String orientacion, int tamaño) {
        this.fila = fila;
        this.columna = columna;
        this.orientacion = orientacion;
        this.tamaño = tamaño;
    }

    public void set_fila_columna(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public String getColumna() {
        char letra = (char) ((char)64+columna);
        String letra2 = String.valueOf(letra);
        return letra2;
    }

    public int getColumna_int() {
        return columna;
    }

    public void cambia_estado() {
        if (estado == 0){
            estado = 2;

        } else if (estado == 1){
            estado = 2;
        }
        else if (estado == 2){
            estado = 2;
        }
        else if (estado == 3){
            estado = 3;
        }
        else if (estado == 4){
            estado = 3;
        }
        else if (estado == 5){
            estado = 5;
        }
        poner_animacion();
    }

    public void poner_animacion() {
        switch (estado){
            case 0->{
                limite();
            }
            case 1->{
                agua();
            }
            case 2->{
                equis();
            }
            case 3->{
                tocado();
            }
            case 4->{
//                limite();
            }
        }
    }


    public int get_tamaño() {
        return  tamaño;
    }

    public String get_orientacion() {
        return  orientacion;
    }


}
