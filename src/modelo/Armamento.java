package modelo;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Clase que configura las neves y/o entes
 * que estaran presentes en la batalla naval.
 */
public class Armamento {

    /**
     * atributo que representa la coordenada
     * x,y de la proa de una nave o cualquier
     * ente presente an la batalla.
     */
    private Point sitio_proa;
    /**
     * atributo que asigna un nombre
     * a un tipo de nave de combate o
     * ente presente en la batalla naval.
     */
    private String nombre_Arma;
    /**
     * atributo integrador de las
     * naves de combate y entes.
     * recepciona un Array de carroceria.
     */
    private LinkedList<Object>fuselaje;
    /**
     * atributo que determina la configuracion
     * de una nave de combate    asi;
     * 0 -> es agua
     * 1 -> es metal
     * 2 -> fue tocado o impactado por el rival.
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
    private int espacio_libre;
    /**
     * atributo que determina el limite de supervivencia
     * de una nave
     */
    private double nivel_de_impactos;
}
