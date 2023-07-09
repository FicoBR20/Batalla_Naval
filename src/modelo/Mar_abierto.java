package modelo;

import vista.Header;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que configura el escenario
 * del mar en donde se escenificara
 * el juego.
 */
public class Mar_abierto extends JPanel {

    private static final int FILAS_ESCENARIO = 10; // contidad de filas

    private static final int COLUMNAS_ESCENARIO = 10;// cantidad de colomnas

    private static final int X_PUNTO_INICAL = 30; // inicio de regilla en eje X

    private static final int Y_PUNTO_INICAL = 30; // inicio de regilla en eje Y

    private Coordenada sitio_Inicial; // punto referencial de inicio.

    private Header header;

    private JPanel jP_Letras_Columnas;

    private JPanel jP_numeros_Filas;

    private JPanel jP_Naves_Dispuestas;

    private JPanel jP_info_Flota;

    private JButton jB_porta_Aviones;

    private JButton jB_submarino;

    private JButton jB_destructor;

    private JButton jB_fragata;

    public Mar_abierto(){
        //Default JFrame configuration

        this.setSize(800,600);

    }



}
