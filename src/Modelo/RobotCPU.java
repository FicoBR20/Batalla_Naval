package Modelo;

import java.util.Random;

public class RobotCPU {
    private Modelo.Tablero tablero;
    private Modelo.Casilla casilla;
    private int limiteFilas = 10;
    private int limiteColumnas = 10;


    /**
     * Constructor de la clase Robot.
     * @param tablero El tablero del robot.
     */
    public RobotCPU(Modelo.Tablero tablero) {
        this.tablero = tablero;
    }

    /**
     * Método para colocar un barco en el tablero de la personaReal de forma aleatoria.
     *
     */
    public void ubicar_naves_aleatoriamente() {
        Random random = new Random();
        int filaNave = random.nextInt();
        int columnaNave = random.nextInt();
    }

    /**
     * Metodo para atacar una casilla en el tablero de la personaReal de forma aleatoria
     */
    public void  atacarAleatoriamente(){

    }


}
