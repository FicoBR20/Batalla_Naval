package Modelo;

import java.util.Random;

public class Flota {
    private String tipo; //(Portaaviones, Submarino, Destructor, Fragata)
    private String orientacion; //(Horizontal o Vertical)
    private int tamano;
    private String estado; //(Intacto, Tocado, Hundido)
    private int[] coordenadas;

    // Constructor
    public Flota(String tipo, String orientacion, int tamano) {
        this.tipo = tipo;
        this.orientacion = orientacion;
        this.tamano = tamano;
        this.estado = "Intacto"; // Al crear un nuevo barco, su estado inicial es "Intacto"
        //this.coordenadas = generarCoordenadasAleatorias();
    }

//    private int[] generarCoordenadasAleatorias() {
  //      Random rand = new Random();
    //    int x = rand.nextInt(10);
      //  int y = rand.nextInt(10);
        //return new int[]{x, y};
   // }
    public String obtenerTipo() {
        return tipo;
    }
    public int obtenerTamano() {
        return tamano;
    }
    public String obtenerEstado() {
        return estado;
    }
    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }
}
