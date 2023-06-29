package Modelo;

import javax.swing.*;
import java.awt.*;


public class Casilla extends JButton {
    
    private  int estado;
    private  int turno;
    private int fila;
    private int columna;

    public Casilla() {
        iniciar();
    }

    public void iniciar() {
//        estado = 1;
        turno = 1;
        this.setPreferredSize(new Dimension(40,40));
        this.setBorder(BorderFactory.createTitledBorder(""));
        es_agua();
    }

    public void es_agua() {

//        ImageIcon imagen = new ImageIcon();
//        imagen = new ImageIcon(getClass().getResource("/recursos/agua.png"));
//        this.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(10,10,Image.SCALE_SMOOTH)));
//        this.setIcon(imagen);

        this.setBackground(new Color(0xBCEAC0));
        this.setIcon(new ImageIcon("recursos/agua.png"));
    }
    public void lock() {
        this.setBackground(new Color(150));
    }

    public void es_trampa() {
        this.setBackground(new Color(0x000000));
    }

    public void es_flota() {
        this.setBackground(new Color(0xFF0D407B, true));
    }

    public void esta_tocado() {
        this.setBackground(new Color(0xF37C43));
    }

    private void cayo_al_agua() {
        cambia_turno();
        this.setBackground(new Color(0x000000));
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

    public void cambia_estado() {
        if (estado == 1){
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

    private void poner_animacion() {
        switch (estado){
            case 1->{
                es_agua();
            }
            case 2->{
                cayo_al_agua();
            }
            case 3->{
                esta_tocado();
            }
            case 4->{
                es_flota();
            }
            case 5->{
                es_trampa();
            }
        }
    }

}
