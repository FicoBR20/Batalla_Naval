package Modelo;

/**
 * Clase que configura la nave
 * Porta_Aviones.
 * Es un Armamento - extends
 */
public class Porta_Aviones extends Armamento{
    /**
     * Atributo que determina
     * la medida en X (horizontalmente)
     * de la nave
     */
    int ancho_en_X;


    /**
     * Constructor
     */
    public Porta_Aviones(){
        super("Porta_Aviones");
        ancho_en_X=4;

    }


    /**
     * Sobreescritura del metodo heredado
     * SetCarroceria_Basica, construye el Array Carroceria
     * @param medida_en_X
     */
    @Override
    public void setCarroceria_Basica(int medida_en_X) {
        super.setCarroceria_Basica(ancho_en_X);
    }
}
