package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Robot_organiza {

    private int filaNave;

    private int ColumnaNav;

    private String direccion;

    private Coordenada coordenada;

    private ArrayList<Armamento> flota;

    public int getFilaNave() {
        return filaNave;
    }

    public void setFilaNave(int filaNave) {
        Random random=new Random();
        filaNave = random.nextInt(10);
        this.filaNave = filaNave;
    }

    public int getColumnaNav() {
        return ColumnaNav;
    }

    public void setColumnaNav(int columnaNav) {
        Random random=new Random();
        columnaNav = random.nextInt(10);
        ColumnaNav = columnaNav;
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

    }



}
