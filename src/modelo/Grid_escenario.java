package modelo;

import vista.GUI_pF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grid_escenario extends JPanel {

    private JButton jButton;

    private Celda celda;

    //private JButton [][] cuadricula_fC;

    private JPanel jP_central;

    private Escucha escucha;

    public Grid_escenario(){
        inicio();
        //this.setSize(new Dimension(440,440));
        this.setPreferredSize(new Dimension(440, 440));
        this.setBackground(Color.GREEN);



    }

    public void inicio(){

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
        jP_central.setBounds(50,50,440,440);
        jP_central.setBackground(Color.BLUE);
        jP_central.setVisible(true);
        jP_central.setOpaque(true);
        jP_central.setEnabled(true);
        jP_central.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        Celda [][] cuadricula_fC = new Celda [Mar_abierto.FILAS_ESCENARIO] [Mar_abierto.COLUMNAS_ESCENARIO];

        int auxiliar=40;

        for (int i = 0; i < Mar_abierto.FILAS_ESCENARIO;i++) {

            for (int j = 0; j < Mar_abierto.COLUMNAS_ESCENARIO; j++) {

                cuadricula_fC[i][j] = new Celda();
                cuadricula_fC[i][j].setText( String.valueOf(j+1) + " " + String.valueOf(i+1));
                cuadricula_fC[i][j].setBounds(50+i*auxiliar, 50+i*auxiliar, celda.getWidth(), celda.getWidth());

                jP_central.add(cuadricula_fC[i][j]);

            }

        }
//        celda.setText("primera");
//        jP_central.add(celda, BorderLayout.CENTER);


        this.add(celda, BorderLayout.NORTH);
        this.add(jButton, BorderLayout.SOUTH);
        this.add(jP_central, BorderLayout.CENTER);

    }

    public void generar_tendido(int datoX, int datoY){

       // JButton [] [] grilla_final = new JButton[datoX] [datoY];

        for (int i = 0; i < datoX;i++) {
            celda.setText(String.valueOf(i+1));
            celda.addActionListener(escucha);
            jP_central.add(celda);
            for (int j = 0; j < datoY; j++){
                celda.setText(String.valueOf(j+1));
                celda.addActionListener(escucha);
                jP_central.add(celda);
            }
        }
        //return grilla_final;
    }

    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public static void main(String[] args){


            GUI_pF miBatalla = new GUI_pF();

            Grid_escenario ge = new Grid_escenario();

            miBatalla.add(ge, BorderLayout.CENTER);

            miBatalla.setVisible(true);


    }


}
