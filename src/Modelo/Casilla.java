package Modelo;

import javax.swing.*;
import java.awt.*;


public class
Casilla extends JButton {
    
    private  int estado;
    private  int turno;
    private int fila;
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
//        estado = 1;
        turno = 1;
        this.setPreferredSize(new Dimension(40,40));
        es_agua();
    }

    /**
     * Metodo que asigna la imagen del agua a un
     * JButton.
     */
    public void es_agua() {
        imageIcon = new ImageIcon(getClass().getResource("/recursos/agua.png"));
        this.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
    }

    /**+
     * Metodo que asigna la imagen del recuadro a un
     * JButton
     */
    public void lock() {
        imageIcon = new ImageIcon(getClass().getResource("/recursos/coordenadas.png"));
        this.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
    }

    public void es_trampa() {
;
    }

    /**
     * Metodo que asigna el color azul a un
     * Jbutton
     */
    public void es_flota() {
        this.setBackground(new Color(0xFF0D407B, true));
    }

    /**
     * Metodo que asigna la imagen de una explosion a
     * un JButton
     */
    public void esta_tocado() {
        imageIcon = new ImageIcon(getClass().getResource("/recursos/tocado.png"));
        this.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
    }

    /**
     * Metodo que asigna la imagen de la X o un
     * JButton, cambia el turno  y set Background a Black
     */
    private void cayo_al_agua() {
        imageIcon = new ImageIcon(getClass().getResource("/recursos/equis.png"));
        this.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
        cambia_turno();
        this.setBackground(new Color(0x000000));
    }

    /**
     * Metodo que modifica el atributo turno
     * entre los valores 1 y 2.
     */
    public void cambia_turno() {
        if (turno == 1){
            turno = 2;
        }
        else if (turno == 2){
            turno = 1;
        }
    }


    /**
     * Metodo que retorna el valor del
     * atributo estado
     * @return
     */
    public int get_estado() {
        return estado;
    }

    /**
     * Metodo que actualiza el atributo
     * estado.
     * @param estado
     */
    public void set_estado(int estado) {
        this.estado = estado;
    }

    /**
     * metodo que actualiza los atributos
     * fila y columna.
     * @param fila
     * @param columna
     */
    public void set_fila_columna(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    /**
     * metodo que entrega el valor del
     * atributo fila.
     * @return
     */
    public int getFila() {
        return fila;
    }

    /**
     * Metodo que retorna un String correspondiente
     * a la letra de la columna segun su numero.
     * @return
     */
    public String getColumna() {
        char letra = (char) ((char)64+columna);
        String letra2 = String.valueOf(letra);
        return letra2;
    }

    /**
     * Metodo que actualiza el valor de la variable
     * estado, asignando una imagen segun corresponda
     */
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

    /**
     * Metodo que asigna una imagen
     * segun el valor de la variable estado.
     */
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
