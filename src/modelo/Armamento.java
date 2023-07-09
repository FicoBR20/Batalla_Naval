package modelo;

import java.util.ArrayList;

/**
 * Clase que configura las neves y/o entes
 * que estaran presentes en la batalla naval.
 */
public class Armamento {

    /**
     * Atributo que representa la coordenada
     * [fila(int), columna(int / String)] de la parte delantera
     * de una nave
     *La columna se puede defiir con un entero o con un String*/
    private Coordenada coord_proa;
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
    private ArrayList<Object>fuselaje;
    /**
     * atributo que determina la configuracion
     * de una nave de combate    asi;
     * 0 -> es agua...por ahora no se usara.
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
     * Atributo que representa el impacto recibido
     * por una nave.
     * Acumulara 1 por cada impacto
     */
    private double impactada;
    /**
     * atributo que determina el limite de supervivencia
     * de una nave, el default es 100% se impactaron toda la nave
     */
    private double nivel_de_impactos;

    /**
     * atributo que define si una nave se hunde
     * segun el porcentaje de TOCADOS que reciba.
     */
    private Boolean nave_Hundida;

    /**
     * atributo que representa la cantidad de
     * casillas ocupadas por la nave en el sentido
     * del eje X osea HORIZONTALMENTE
     */
    private int espacio_ocupado_X;

    /**
     * atributo que representa la cantidad de
     * casillas ocupadas por la nave en el sentido
     * del eje Y osea VERTICALMENTE
     */private int espacio_ocupado_Y;

    //======================================================================= METODOS DE LA CLASE====================

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
     */
    public void setEspacio_libre() {
        espacio_libre=1;
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
     * de casillas TOCADAS que se acumulan en la variable
     * impactada
     */
    public void setNivel_de_impactos() {

        nivel_de_impactos = impactada/carroceria.size();
    }

    public double getImpactada() {
        return impactada;
    }

    /**
     * Metodo que actualiza el array de corroceria
     * asignandole al campo el valor de 3 en inicacion
     * que La nave fue TOCADA por el rival.
     * @param sito_del_disparo
     */
    public void setImpactada(Coordenada sito_del_disparo) {

        for (int i = 0; i < carroceria.size(); i++) {
            if (carroceria.contains(sito_del_disparo)){
                impactada+=1.0;
                System.out.println("..en setImpactada..van..cantidad de impactos.." + ((int) impactada));
            }

        }

    }

    /**
     * Atributo que retorna
     * true -> la nave fue hundida en la batalla.
     * false -> la nave NO esta hundida todavia.
     * @return
     */
    public Boolean getNave_Hundida() {
        return nave_Hundida;
    }

    /**
     * Metodo que define el humdimiento de una nave
     * segun el porcentaje del nievl de impacto (TOCADOS)
     */
    public void setNave_Hundida() {
        if (nivel_de_impactos==1.0){
            nave_Hundida=true;
        }
    }

    /**
     * Metodo que entrega el Arraylist fuselaje
     * @return
     */
    public ArrayList<Object> getFuselaje() {
        return fuselaje;
    }

    /**
     * Metodo que configura el Arraylist fuselaje
     * contiene 6 atributos de la clase distribuidos
     * en 6 campos.
     */
    public void setFuselaje() {
        fuselaje.add(nombre_Arma);// campo[0]
        // fuselaje.add(coord_proa);// campo [0]
       // fuselaje.add(carroceria);// campo[2]
       // fuselaje.add(is_rotate);// campo[3]
        //fuselaje.add(icono_asociado);// campo[4]
        //fuselaje.add(espacio_libre);// campo[5]

    }

    /**
     * Metodo que entrega el espacio ocupado en X -> HORIZONTALMENTE
     * por una nave.
     * @return
     */
    public int getEspacio_ocupado_X() {
        return espacio_ocupado_X;
    }

    /**
     * Metodo que configura el espacio ocupado
     * en X -> HORIZONTALMENTE por una nave.
     */
    public void setEspacio_ocupado_X() {
        if (is_rotate==true){
            espacio_ocupado_X=1;
        }
        else {
            espacio_ocupado_X=carroceria.size();
        }
    }

    /**
     * Metodo que entrega el espacio ocupado en Y -> VERTICALMENTE
     * por una nave.
     * @return
     */public int getEspacio_ocupado_Y() {
        return espacio_ocupado_Y;
    }

    /**
     * Metodo que configura el espacio ocupado
     * en Y -> VERTICALMENTE por una nave.
     */
    public void setEspacio_ocupado_Y() {
        if (is_rotate==true){
            espacio_ocupado_Y=carroceria.size();
        }
        else {
            espacio_ocupado_Y=1;
        }
    }

    //========================================================================METODO CONSTRUCTOR=============
    /**
     * Metodo constructor
     */
    public Armamento(){
        coord_proa = new Coordenada();
        nombre_Arma = " ";
        fuselaje=null;
        carroceria=null;
        is_rotate=false;
        icono_asociado=99; // valor de inicializacion sin SEMANTICA
        espacio_libre=1;
        impactada = 0; // la nave esta nueva no ha sido impactada
        nivel_de_impactos=100.0;
        nave_Hundida = false;

    }
    public Armamento(String nombre_Nave){
        this.nombre_Arma=nombre_Nave;
    }
}
