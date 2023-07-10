package modelo;

import vista.GUI_pF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grid_escenario extends JPanel {

    /**
     * Atributo del inicio del
     * panel en sentido Horizontal
     */
    private int x_Inicial;

    /**
     * Atributo del inicio del
     * panel en el sentido Vertical
     */
    private int y_Inicial;

    private Coordenada coordenada;

    private JButton jButton;

    private Celda celda;

    //private JButton [][] cuadricula_fC;

    private JPanel jP_central;

    private Escucha escucha;

    public Grid_escenario(){
        inicio();
        //this.setSize(new Dimension(440,440));
        this.setPreferredSize(new Dimension(440, 440));
        this.setVisible(true);
        this.setOpaque(true);
        this.setEnabled(true);
        this.setBackground(Color.GREEN);



    }

    public void inicio(){

        coordenada = new Coordenada();
        coordenada.setUbicacion_coordenada(0,0);

        jButton = new JButton();
        jButton.setText(" Prueba ");

        //GridLayout gridLayout = new GridLayout(Mar_abierto.FILAS_ESCENARIO, Mar_abierto.COLUMNAS_ESCENARIO);


        escucha = new Escucha();
        celda = new Celda();
        celda.setVisible(true);
        celda.setEnabled(true);
        celda.setOpaque(true);
        celda.addActionListener(escucha);

        jP_central = new JPanel();
        jP_central.setBounds(0,0,400,400);
        jP_central.setBackground(Color.GRAY);
        jP_central.setVisible(true);
        jP_central.setOpaque(true);
        jP_central.setEnabled(true);
        jP_central.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        Celda [][] cuadricula_fC = new Celda [Mar_abierto.FILAS_ESCENARIO] [Mar_abierto.COLUMNAS_ESCENARIO];

        Celda [][] filadeCeldas = new Celda[10][10];

        Celda [] centenaria = new Celda[100];

        int limite_fila=0;
        int limite_columna=0;

        for (int i = 0; i < 100; i++) {

            centenaria[i] = new Celda();

        }

        for (int i = 0; i < 10; i++) {
            for (int j = i ; j < 10; j++) {


                filadeCeldas[i][j] = new Celda();
                filadeCeldas[i][j].setFont(new Font(Font.DIALOG, Font.BOLD, 10));

                filadeCeldas[i][j].addActionListener(escucha);
                filadeCeldas[i][j].setText("Fila\n" +String.valueOf(i) + "\n" + " Colomna" + String.valueOf(j));
                //filadeCeldas[i].setText("Filas");

                filadeCeldas[i][j].setBounds(coordenada.getNumero_Fila() * i, coordenada.getNumero_Columna() * i,
                        celda.getWidth(), celda.getWidth());
                jP_central.add(filadeCeldas[i][j]);
            }

        }


        this.add(jP_central, BorderLayout.CENTER);

    }


    /**
     * Clase que configura las escuchas del
     * Action Listener.
     */
    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println("estoy aqui escuchando todo..");

        }
    }
//
//    public static void main(String[] args){
//
//
//            Grid_escenario escena_1 = new Grid_escenario();
//
//
//
//
//    }


}
