package modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grid_escenario extends JPanel {

    private Celda celda;

    private JPanel jP_central;

    private Escucha escucha;

    public Grid_escenario(){
        inicio();
        this.setSize(new Dimension(440,440));
        this.setPreferredSize(new Dimension(440,440));

    }

    public void inicio(){
        escucha = new Escucha();

        celda = new Celda();
        celda.addActionListener(escucha);

        generar_tendido();


        jP_central = new JPanel();
        jP_central.add(generar_tendido(), BorderLayout.CENTER);

    }

    public JButton[][] generar_tendido(int datoX, int datoY){

        JButton [] [] grilla_final = new JButton[datoX] [datoY];

        for (int i = 0; i < datoX;i++) {
            new Celda().setText(String.valueOf(i+1));
            for (int j = 0; j < datoY; j++){
                new Celda().setText(String.valueOf(j+1));
            }
        }
    }

    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


}
