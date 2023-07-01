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
     * La ubicacion debe estar asociada al grid del Tablero
     * tomando en cuenta la medida de cada fila y columna
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
     * recepciona los atributos.
     */
    private LinkedList<Object>fuselaje;
    /**
     * atributo que determina la configuracion
     * de una nave de combate    asi;
     * 0 -> es agua
     * 1 -> es metal
     * ejemplo: [1,1,1] es el submarino
     */
    private ArrayList<Integer>carroceria;
    /**
     * atributo que determina la rotacion
     * de una nave. El valor default es false
     */
    private Boolean is_rotate;
    /**
     * atributo para asignacion del icono
     * representativo de la nave
     */
    private int icono_asociado;
    /**
     * Atributo que asigna la distancia minima
     * entre los entes presentes en la batalla.
     */
    private int espacio_libre;

    /**
     * Metodo que representa el impacto recibido
     * por una nave en una parte de su carroceria.
     */
    private int impactada;
    /**
     * atributo que determina el limite de supervivencia
     * de una nave, el default es 100% se impactaron toda la nave
     */
    private double nivel_de_impactos;

    /**
     * Metodo que retorna un objeto Point
     * de cordenadas (x,y).
     * @return
     */
    public Point getSitio_proa() {
        return sitio_proa.getLocation();
    }

    /**
     * Metodo que asigna los valores de las coordenadas
     * a un objeto Point.
     * @param varX
     * @param varY
     */
    public void setSitio_proa(int varX,int varY) {
        sitio_proa.setLocation(varX,varY);
    }

    /**
     * Metodo que retorna el nombre de
     * un Arma naval.
     * @return
     */
    public String getNombre_Arma() {
        return nombre_Arma;
    }

    /**
     * Metodo que asigna el nombre de
     * un arma naval.
     * @param nombre_Arma
     */
    public void setNombre_Arma(String nombre_Arma) {
        this.nombre_Arma = nombre_Arma;
    }

    /**
     * Metodo que retorna el array carroceria
     * @return
     */
    public ArrayList<Integer> getCarroceria() {
        return carroceria;
    }

    /**
     * Metodo que configura un Buque para la batalla
     * tomando como parametro la cantidad de celdas
     * @param celdas_X
     */
    public void setCarroceria_Basica(int celdas_X) {

        for (int i = 0; i < celdas_X; i++) {
            carroceria.add(1); // 1 -> Semantica es METAL osea, NO es AGUA.
        }
    }

    /**
     * Metodo que retorna la variable
     * is_rotate.
     * @return
     */
    public Boolean getIs_rotate() {
        return is_rotate;
    }

    /**
     * Metodo que modifica a true
     * la variable is_rotate.
     */
    public void setIs_rotate() {
        is_rotate=true;
    }

    /**
     * Metodo que retorna el entero asociado al
     * icono que usa la nave
     * @return
     */
    public int getIcono_asociado() {
        return icono_asociado;
    }

    /**
     * Metodo que asigna un entero asociado al icono
     * que usara la nave de combate.
     * @param icono_asociado
     */
    public void setIcono_asociado(int icono_asociado) {
        this.icono_asociado = icono_asociado;
    }

    /**
     * Metodo que retorna el valor del espacio
     * minimo entre las naves.
     * @return
     */
    public int getEspacio_libre() {
        return espacio_libre;
    }

    /**
     * Metodo que asigna el espacio minimo que debe
     * existir entre las naves
     * @param espacio_libre
     */
    public void setEspacio_libre(int espacio_libre) {
        this.espacio_libre = espacio_libre;
    }

    /**
     * Metodo que entrega el porcentaje impactado
     * sobre la nave, basado en las areas TOCADAS
     * @return
     */
    public double getNivel_de_impactos() {
        return nivel_de_impactos;
    }

    /**
     * Metodo que calcula el porcentaje de impactos
     * recibida por una nave, basandose en la cantidad
     * de casillas TOCADAS.
     */
    public void setNivel_de_impactos() {
        int auxiliar=0;
        for (int i = 0; i < carroceria.size(); i++) {
            if (carroceria.get(i)==3){
                auxiliar++;
            }
        }
        nivel_de_impactos = carroceria.size()/auxiliar;
    }

    //========================================================================
    /**
     * Metodo constructor
     */
    public Armamento(){
        sitio_proa.setLocation(0,0);
        nombre_Arma = " ";
        fuselaje=null;
        carroceria=null;
        is_rotate=false;
        icono_asociado=99;
        espacio_libre=1;
        nivel_de_impactos=100.0;

    }
}
