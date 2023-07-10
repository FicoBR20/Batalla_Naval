package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Robot_organiza {

    private Armamento armamento;

    private int filaNave;

    private int columnaNav;

    private String direccion;

    private Coordenada coordenada;

    private ArrayList<Armamento> flota;

    public int getFilaNave() {
        return filaNave;
    }

    public void setFilaNave() {
        Random random=new Random();
        int filaNave = random.nextInt(10);
        this.filaNave = filaNave;
    }

    public int getColumnaNav() {
        return columnaNav;
    }

    public void setColumnaNav() {
        Random random=new Random();
        int columnaNav = random.nextInt(10);
        this.columnaNav = columnaNav;
    }

    /**
     * Entrega la direccion
     * @return
     */
    public String getDireccion() {
        return direccion;
    }



    /**
     * Metodo que entrega un String
     * h -> va horizontal
     * v -> va vertical
     * @return
     */
    public void setDireccion() {
        //obtiene la hora
        LocalDateTime horaActual = LocalDateTime.now();

        // Obtiene el minuto actual de la hora
        int segundoActual = horaActual.getMinute();

        String orientacion;
        if (segundoActual % 2 == 0) {
            orientacion = "h";
        } else {
            orientacion = "v";
        }
        direccion = orientacion;

    }

    /**
     * Constructor
     */
    public Robot_organiza(){

        armamento.setNombre_Arma("PortaAviones");
        armamento.setCarroceria_Basica(4);

    }
    private void init(){
        armamento = new Armamento();
        filaNave = 99;
        columnaNav =99;
        direccion=" ";
        coordenada = new Coordenada();
        flota = new ArrayList<Armamento>(10);

    }
//oleano cabeoNO ( int(flota[0].size), Coordena Proa(x,y). int Direccion){

    /**
     * Metodo que decide true o false si una nave cabe o no
     * ya sea en una colomna o en una fila.
     * @param tamanoArma
     * @param proa
     * @param sentido
     * @return
     */
    public boolean cabe(int tamanoArma, Coordenada proa, String sentido){//proa(fila, columna)

        int auxiliar=99;

        if (sentido=="v"){

            auxiliar = proa.getNumero_Fila();

            //necesitamos saber si la cantidad de ceros es menor o igual
            // al int tamano Area



        }
        else if (sentido=="H"){

        }
        return true; /// verificar.

    }



}
