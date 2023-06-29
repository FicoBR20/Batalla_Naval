package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JP_01_Info_Reglas_del_Juego extends JPanel {

    private Escucha escucha;

    private JPanel jPanel_Central;
    private JButton jButton;
    private JLabel jLabel;
    private JTextArea jTextArea;

    public JP_01_Info_Reglas_del_Juego(){
        init();
        this.setSize(600,350);
        this.setVisible(true);
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(600,350));


    }

    public void init(){
        escucha = new Escucha();

        String info = " la informacion...\n  mas info....\n mas info.";


        jButton = new JButton("ATRAS");
        jButton.addActionListener(escucha);

        jLabel = new JLabel(" info importante ");

        jTextArea = new JTextArea(" Las reglas ");
        jTextArea.setText(info);
        jTextArea.setSize(new Dimension(600,100));
        jTextArea.setEditable(false);
        jTextArea.setBounds(0,0,600,100);
        jTextArea.setForeground(new Color(234, 214, 79));
        jTextArea.setBackground(new Color(187, 48, 187));

        jPanel_Central = new JPanel();
        jPanel_Central.setSize(new Dimension(600,350));
        jPanel_Central.setEnabled(true);
        jPanel_Central.setOpaque(true);
        jPanel_Central.add(jTextArea, BorderLayout.CENTER);
        jPanel_Central.add(jLabel, BorderLayout.NORTH);



        this.add(jPanel_Central, BorderLayout.CENTER);
        this.add(jButton, BorderLayout.SOUTH);

    }

    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource()==jButton){

                jPanel_Central.setBackground(Color.GREEN);

                System.out.println(" en JP 01 - estoy escuchando bien");
            }

        }
    }

}
