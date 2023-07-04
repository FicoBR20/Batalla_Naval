package modelo;

public class RobotCPU {
    private String nombre;
    private Tablero tablero;

    /**
     * Constructor de la clase Robot.
     * @param nombre El nombre del robot.
     * @param tablero El tablero del robot.
     */
    public RobotCPU(String nombre, Tablero tablero) {
        this.nombre = nombre;
        this.tablero = tablero;

    }

    /**
     * Método para colocar un barco en el tablero del robot.
     * @param flota La flota a colocar.
     * @param fila La fila donde colocar el barco.
     * @param columna La columna donde colocar el barco.
     * @param horizontal Si el barco se coloca de manera horizontal o vertical.
     */
    public void colocarBarco(Flota flota, int fila, int columna, boolean horizontal) {
        // Verificar si el barco cabe en el tablero
        if (horizontal) {
            if (columna + flota.obtenerTamano() > tablero.getColumnas()) {
                System.out.println("El barco no cabe en el tablero");
                return;
            }
        } else {
            if (fila + flota.obtenerTamano() > tablero.getFilas()) {
                System.out.println("El barco no cabe en el tablero");
                return;
            }
        }

        // Verificar si el barco se superpone con otro barco
        for (int i = 0; i < flota.obtenerTamano(); i++) {
            if (horizontal) {
                if (tablero.getCasilla(fila, columna + i).getBarco() != null) {
                    System.out.println("El barco se superpone con otro barco");
                    return;
                }
            } else {
                if (tablero.getCasilla(fila + i, columna).getBarco() != null) {
                    System.out.println("El barco se superpone con otro barco");
                    return;
                }
            }
        }

        // Colocar el barco en el tablero
        for (int i = 0; i < flota.obtenerTamano(); i++) {
            if (horizontal) {
                tablero.getCasilla(fila, columna + i).setBarco(flota);
            } else {
                tablero.getCasilla(fila + i, columna).setBarco(flota);
            }
        }
    }

    /**
     * Método para atacar una casilla del tablero enemigo.
     * @param fila La fila de la casilla a atacar.
     * @param columna La columna de la casilla a atacar.
     */
    public void atacar(int fila, int columna) {
        Casilla casilla = tablero.getCasilla(fila, columna);
        if (casilla.isAtacada()) {
            System.out.println("La casilla ya ha sido atacada");
            return;
        }

        casilla.setAtacada(true);
        if (casilla.getBarco() != null) {
            System.out.println("¡Tocado!");
            casilla.getBarco().tocado();
            if (casilla.getBarco().isHundido()) {
                System.out.println("¡Hundido!");
            }
        } else {
            System.out.println("Agua");
        }
    }
}
