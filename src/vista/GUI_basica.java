package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used for ...
 * @autor Carlos Felipe Montoya carlos.felipe.montoya@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI_basica extends JFrame {

    private JP_01_Info_Reglas_del_Juego jp01;

    /**
     * Clase Escucha implementa Action listener
     */

    private Header headerProject;
    private JButton jButton_Next;
    private JPanel jPanel_Inicio;

    /**
     * Constructor of GUI class
     */
    public GUI_basica(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("Batalla Naval");
        this.setSize(1100,600);
        //this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {

    }

}
