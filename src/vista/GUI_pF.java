package vista;

import modelo.Grid_escenario;
import modelo.Mar_abierto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used for ...
 * @autor Carlos Felipe Montoya carlos.felipe.montoya@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI_pF extends JFrame {

    private JPanel jP_escenario;

    private Grid_escenario grid_escenario;

    private JP_01_Info_Reglas_del_Juego jp01;

    /**
     * Clase Escucha implementa Action listener
     */
    private Escucha escucha;

    private Header headerProject;
    private JButton jButton_Next;
    private JPanel jPanel_Inicio;

    /**
     * Constructor of GUI class
     */
    public GUI_pF(){
        initGUI();

        grid_escenario = new Grid_escenario();


        //Default JFrame configuration
        this.setTitle("Batalla Naval");
        this.setSize(600,600);
        //this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {

        grid_escenario = new Grid_escenario();
        grid_escenario.setVisible(true);
        grid_escenario.setOpaque(true);
        grid_escenario.setEnabled(true);
        grid_escenario.setBackground(Color.CYAN);

        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        jP_escenario = new JPanel();
        jP_escenario.setSize(400,400);
        jP_escenario.setPreferredSize(new Dimension(400,400));
        jP_escenario.setBackground(Color.RED);
        //jP_escenario.add(grid_escenario, BorderLayout.CENTER);


        jp01 = new JP_01_Info_Reglas_del_Juego();
        jp01.setVisible(true);
        jp01.setOpaque(true);
        jp01.setEnabled(true);


        escucha = new Escucha();


        jButton_Next = new JButton("next");
        jButton_Next.setVisible(true);
        jButton_Next.setBackground(Color.BLUE);
        jButton_Next.setForeground(Color.white);

        jButton_Next.addActionListener(escucha);

        jPanel_Inicio = new JPanel();
        jPanel_Inicio.setSize(new Dimension(600,480));
        jPanel_Inicio.setVisible(true);
        jPanel_Inicio.setBackground(Color.ORANGE);
        jPanel_Inicio.setEnabled(true);


        headerProject = new Header("The naval WAR game", Color.BLACK);

        this.add(headerProject,BorderLayout.NORTH);
        this.add(jButton_Next, BorderLayout.SOUTH);
        //this.add(jPanel_Inicio, BorderLayout.CENTER);
        this.add(grid_escenario, BorderLayout.CENTER);
    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI_pF miBatalla = new GUI_pF();
        });
    }

    /**
     * Metodo que actualiza el jPanel_Inicio
     * @param jPanel_new
     */
    public void cambiarPaneles( JPanel jPanel_new){

        this.remove(jPanel_Inicio);
        //jPanel_Inicio.add(jPanel_new, BorderLayout.CENTER);
        //jPanel_Inicio.add(jPanel_new, BorderLayout.CENTER);
        this.add(jPanel_new,BorderLayout.NORTH);

        repaint();


    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener {




        @Override
        public void actionPerformed(ActionEvent e) {

            JButton [][] cuadriculo = new JButton[Mar_abierto.FILAS_ESCENARIO][Mar_abierto.COLUMNAS_ESCENARIO];

            if (e.getSource()==jButton_Next){

                cambiarPaneles(grid_escenario);

                repaint();


                System.out.println(" ..domingo ok Gracias a Dios");
            }


        }


    }

}
