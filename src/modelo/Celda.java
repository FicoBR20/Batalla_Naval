package modelo;

import javax.swing.*;
import java.awt.*;


/**
 * Clase que configura el JButton
 * que se usara en la Clase Tablero
 */
public class Celda extends JButton {

    /**
     * Atributo [fila, columna] de
     * una Celda.
     */
    private Coordenada ubicacion_Celda;

    /**
     * Atributo usado para la asignacion especifica de
     * una imagen a un objeto de tipo Casilla
     */
    private  int estado;

    /**
     * Atributo que representa la imagen
     * definida por el valor del atributo
     * estado.
     */
    private ImageIcon imageIcon;

    /**
     * Metodo constructor que configura
     * los atributos iniciales de un JButton
     */
    public Celda() {

        //this.setBackground(null);
//        this.setContentAreaFilled(false);
        //this.setBorderPainted(false);
       // this.setBorder(BorderFactory.createEmptyBorder());
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setFocusable(true); //Quita linea de los botones
        this.setVisible(true);
        this.setEnabled(true);
        this.setOpaque(true);
        this.setFont(new Font(Font.DIALOG,Font.BOLD,6));
        this.setPreferredSize(new Dimension(80,80));
        iniciar();
    }

    /**
     * Metodo que inicializa la variable estado
     * y configura el size de una celda.
     * Metodo presente en el constructor de la clase.
     */
    public void iniciar() {
        ubicacion_Celda = new Coordenada();
        estado = 1;// Semantica -> es Agua
    }

//    public void ubicar_Celda(){
//
//    }

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
     * JButton ubicado en los margenes asi:
     * Ubicacion TOP -> JButtons con las letras de las Columnas
     * Ubicacion lEFT -> JButtons con los numeros de las filas.
     */
    public void recuadro_Decorativo() {
        imageIcon = new ImageIcon(getClass().getResource("/recursos/coordenadas.png"));
        this.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH)));
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
        this.setBackground(new Color(0x000000));
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
     * estado, el cual asigna una imagen a un JButton
     * segun el entero recibido como parametro.
     * @param estado
     */
    public void set_estado(int estado) {
        this.estado = estado;
    }



    /**
     * Metodo que retorna un String correspondiente
     * a la letra de la columna segun su ubicacion
     * consecutiva.
     * @return
     */
    public String letra_Para_Columnas(int auxiliar) {
        char letra = (char) ((char)64+auxiliar);
        String letra2 = String.valueOf(letra);
        return letra2;
    }


    /**
     * Metodo que asigna una imagen
     * segun el valor de la variable estado.
     */
    private void asignar_imagen() {
        switch (estado){
            case 1->{
                es_agua();
            }
            case 2->{
                es_flota();
            }
            case 3->{
                esta_tocado();
            }
        }
    }

    /**
     * Metodo que ubica una Celda
     * segun una Coordenada rebibida
     * @param coord
     */
    public void ubicar_Celda(Coordenada coord){
        this.setBounds(coord.getNumero_Fila(), coord.getNumero_Columna(),
                this.getWidth(), this.getWidth());
    }

//    public void recoger_datos(int fila, int columna, String orientacion, int tamaño) {
//        this.fila = fila;
//        this.columna = columna;
//        this.orientacion = orientacion;
//        this.tamaño = tamaño;
//    }

}
