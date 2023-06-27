package modelo;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Clase que configura las neves que
 * van al combate.
 */
public class Armamento {
    /**
     * atributo que asigna un nombre
     * a un tipo de nave de combate.
     */
    private String nombre_Arma;
    /**
     * atributo integrador de las
     * naves de combate.
     * recepciona un Array de carroceria.
     */
    private LinkedList<Integer>fuselaje;
    /**
     * atributo que determina la configuracion
     * de una nave de combate asi;
     * 1 -> es metal
     * 0 -> es agua
     */
    private ArrayList<Integer>carroceria;
    /**
     * atributo que determina la rotacion
     * de una nave
     */
    private Boolean is_rotate;
    /**
     * atributo para asignacion del icono
     * representativo de la nave
     */
    private int Icon;
    /**
     * Atributo que asigna la distancia minima
     * entre los entes presentes en la batalla.
     */
    private int escudo;
    /**
     * atributo que determina el limite de supervivencia
     * de una nave
     */
    private double nivel_de_impactos;
}
