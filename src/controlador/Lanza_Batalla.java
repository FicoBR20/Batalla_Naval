package controlador;

import modelo.Armamento;
import vista.GUI_pF;

import java.awt.*;

/**
 * Clase que coordina la ejecucion de la
 * app.
 */
public class Lanza_Batalla {

    private GUI_pF guiPF;
    private Armamento armamento;

    /**
     * Metodo constructor
     */
    public Lanza_Batalla(){
        init();
    }

    /**
     * Metodo que iniciliza los atributos
     * de la clase.
     */
    public void init(){
        guiPF = new GUI_pF();
        armamento = new Armamento();

        enfrentamiento();

    }

    public void enfrentamiento(){

        System.out.println(" Se inicia el juego Batalla Naval desde\n" +
                "Lanza_Batalla");
    }

    /**
     * Metodo que ejecuta la clase
     * @param args
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            Lanza_Batalla nueva_Batalla = new Lanza_Batalla();
        });
    }
}
