package Modelo;

public class RobotCPU {
    private String nombre;
    private modelo.Tablero tablero;

    /**
     * Constructor de la clase Robot.
     * @param nombre El nombre del robot.
     * @param tablero El tablero del robot.
     */
    public RobotCPU(String nombre, modelo.Tablero tablero) {
        this.nombre = nombre;
        this.tablero = tablero;
    }

    /**
     * Método para colocar un barco en el tablero de la personaReal de forma aleatoria.
     *
     */
    public void colocarBarco(Flota flota) {
        // Colocar el barco en el tablero de forma aleatoria
        tablero.dibujar_tablero();
        tablero.bloquear_rejilla();

    }

    /**
     * Metodo para atacar una casilla en el tablero de la personaReal de forma aleatoria
     */
    public void  atacar(){

    }

}
