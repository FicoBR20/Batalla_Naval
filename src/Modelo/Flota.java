package modelo;
public class Flota {

    private String tipo; //(Portaaviones, Submarino, Destructor, Fragata)
    private String orientacion; //(Horizontal o Vertical)
    private int tamano;
    private String estado; //(Intacto, Tocado, Hundido)

    // Constructor
    public Flota(String tipo, String orientacion, int tamano) {
        this.tipo = tipo;
        this.orientacion = orientacion;
        this.tamano = tamano;
        this.estado = "Intacto"; // Al crear un nuevo barco, su estado inicial es "Intacto"
    }


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
