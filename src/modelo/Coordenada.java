package modelo;

import java.util.LinkedList;

/**
 * Clase que maneja las coordenadas
 * es una LinkedList de 2 campos.
 * [numero_Fila, numero_columna] o tambien
 * [numero_Fila, letra_columna]
 */
public class Coordenada {

    /**
     * Coordenada [fila, columna]
     */
    private LinkedList<Object> ubicacion_coordenada;
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
     * Metodo que entrega la lista de la coordenada
     * con los 2 campos
     * @El campo [0] -> int -> numero de la fila
     * @El campo [1] puede ser de dos tipos;
     *              @String -> letra que indica la columna
     *              @int -> numero que indica la columna
     * @return
     */
    public LinkedList<Object> getUbicacion_coordenada() {
        return ubicacion_coordenada;
    }


    /**
     * Metodo que configura lo lista de los datos de una coordenada.
     * Usa un String para determinar la columna
     * [0] -> int que indica la fila
     * [1] -> String que indica la columna
     * @param nunFila
     * @param letColumna
     */
    public void setUbicacion_coordenada(int nunFila, String letColumna) {
        ubicacion_coordenada.add(0,nunFila);
        ubicacion_coordenada.add(1,letColumna);
    }

    /**
     * Metodo que configura lo lista de los datos de una coordenada.
     * Usa un int para determinar la columna
     * [0] -> int que indica la fila
     * [1] -> int que indica la columna
     * @param nunFila
     * @param numColumna
     */
    public void setUbicacion_coordenada(int nunFila, int numColumna) {
        ubicacion_coordenada.add(0,nunFila);
        ubicacion_coordenada.add(1,numColumna);
    }

    /**
     * Metodo constructor
     */
    public Coordenada(){
        ubicacion_coordenada = new LinkedList<Object>();
        numero_Fila =99;// valor sin semantica..solo para inicializar.
        numero_Columna =99; // valor sin semantica..solo para inicializar.
        letra_Columna ="";
    }
}
