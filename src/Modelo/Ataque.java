package modelo;

import java.util.Random;

public class Ataque {
    private int disparoX;
    private int disparoY;

    /**
     * Constructor de la clase Ataque.
     */
    public Ataque() {
        this.disparoX = -1;
        this.disparoY = -1;
    }

    /**
     * Método para generar un disparo aleatorio.
     * @param filas El número de filas del tablero.
     * @param columnas El número de columnas del tablero.
     */
    public void ataqueRandom(int filas, int columnas) {
        Random rand = new Random();
        this.disparoX = rand.nextInt(filas);
        this.disparoY = rand.nextInt(columnas);
    }

    /**
     * Método para especificar las coordenadas del disparo.
     * @param x La coordenada x del disparo.
     * @param y La coordenada y del disparo.
     */
    public void ataqueCoordenadas(int x, int y) {
        this.disparoX = x;
        this.disparoY = y;
    }

    /**
     * Método para obtener la coordenada x del disparo.
     * @return La coordenada x del disparo.
     */
    public int getDisparoX() {
        return disparoX;
    }

    /**
     * Método para obtener la coordenada y del disparo.
     * @return La coordenada y del disparo.
     */
    public int getDisparoY() {
        return disparoY;
    }
}
