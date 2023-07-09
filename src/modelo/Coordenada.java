package modelo;

import java.util.LinkedList;

/**
 * Clase que maneja las coordenadas
 * [numero_Fila, numero_columna]
 */
public class Coordenada {
    /**
     * Atributo que se refiere a la fila
     * rango [0,9] 10 filas
     */
    private int numero_Fila;

    /**
     * Atributo numerico que se refiere a la
     * columna. rango [0,9] 10 columnas
     */
    private int numero_Columna;

    /**
     * Atributo String que se refiere a la columna
     * valores [ A, B, C, D, E, F, G, H, I, J ]
     */
    private String letra_Columna;

    /**
     * Metodo que entrega el numero de la fila
     * @return
     */
    public int getNumero_Fila() {
        return numero_Fila;
    }

    /**
     * Metodo que configura el numero de la fila
     * @param numero_Fila
     */
    public void setNumero_Fila(int numero_Fila) {
        this.numero_Fila = numero_Fila;
    }

    /**
     * Metodo que entrega el numero de la columna
     * @return
     */
    public int getNumero_Columna() {
        return numero_Columna;
    }

    /**
     * Metodo que configura el numero de la columna
     * recibiendo un numero entero.
     * @param numero_Columna
     */
    public void setNumero_Columna(int numero_Columna) {
        this.numero_Columna = numero_Columna;
    }

    /**
     * Metodo SOBRECARGADO para configurar el numero de una
     * columna recibiendo un dato string.
     * @param letra_ingresada
     */
    public void setNumero_columna_campo(String letra_ingresada) {
        String [] simbolos_colomnas = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        LinkedList<String> letras_Columnas = new LinkedList<String>();
        for (int i = 0; i < simbolos_colomnas.length; i++) {
            letras_Columnas.add(i,simbolos_colomnas[i]);
        }
        if (letras_Columnas.contains(letra_ingresada)){
            numero_Columna =letras_Columnas.indexOf(letra_ingresada);
        }

    }

    /**
     * Metodo que retorna la letra de una Columna
     * @return
     */
    public String getLetra_Columna() {
        return letra_Columna;
    }

    /**
     * Metodo que configura la letra de una columna
     * @param letra_Columna
     */
    public void setLetra_Columna(String letra_Columna) {
        this.letra_Columna = letra_Columna;
    }


    /**
     * Metodo constructor
     */
    public Coordenada(){
        numero_Fila =99;// valor sin semantica..solo para inicializar.
        numero_Columna =99; // valor sin semantica..solo para inicializar.
        letra_Columna ="";
    }
}
