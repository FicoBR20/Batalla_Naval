package controlador;

import modelo.Armamento;
import modelo.Coordenada;
import vista.GUI_pF;

import java.awt.*;

/**
 * Clase que coordina la ejecucion de la
 * app.
 */
public class Lanza_Batalla {
    private Coordenada coordenada;

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
        coordenada = new Coordenada();
        guiPF = new GUI_pF();
        armamento = new Armamento();

        enfrentamiento();

    }

    /**
     * Metodo que inicia el juego.
     */
    public void enfrentamiento(){

        String prueba_cordenada = "J";
        coordenada.setNumero_columna_campo(prueba_cordenada);

        System.out.println("A la columna de letra " + prueba_cordenada +
                " le corresponde el numero " + coordenada.getNumero_Columna());

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
