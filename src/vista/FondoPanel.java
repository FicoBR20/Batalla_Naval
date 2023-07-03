package vista;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que maneja las imagenes que se
 * asignaran en el desarrollo del juego.
 */
public class FondoPanel extends JPanel {
    /**
     * Atributo que representa
     * una determinada imagen que
     * se usara.
     */
    private Image image;
    /**
     * Atributo que indica la ruta / directorio
     * de la imagen.
     */
    private String imageIcon;

    /**
     * Constructor
     * inicializa una ruta que corresponde a la ruta / directorio
     * de la imagen del agua.
     */
    public FondoPanel() {
       imageIcon = "/recursos/fondo_1.png";
    }

    @Override
    /**
     * Metodo paint que dibuja una imagen
     */
    public void paint(Graphics g) {
        image = new ImageIcon(getClass().getResource(get_ruta_icono())).getImage();
        g.drawImage(image,0,0,getWidth(),getHeight(),this);
        setOpaque(false);
        this.setBackground(null);
        super.paint(g);
    }

    /**
     * Metodo que entrega la ruta en donde
     * esta la imagen a ser usada.
     * @return
     */
    public String get_ruta_icono() {
        return this.imageIcon;
    }

    /**
     * Metodo en donde se asigna el String con
     * la ruta de la imagen deseada.
     * @param imageIcon
     */
    public void set_ruta_fondo(String imageIcon) {

        this.imageIcon = imageIcon;
    }

    /**
     * Metodo que recibe un entero que se
     * asocia con el nombre de la imagen para
     * seleccionarla.
     * @param index
     */
    public void set_ruta_fondo(int index) {
        this.imageIcon = "/resources/fondos/fondo_"+index+".png";
    }
}
