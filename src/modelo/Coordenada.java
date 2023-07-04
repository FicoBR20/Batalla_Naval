package modelo;

public class Coordenada {
    /**
     * Atributo que se refiere a la fila
     * rango [1,10]
     */
    private int fila_campo;

    /**
     * Atributo que se refiere a la columna
     * rango [ A, B, C, D, E, F, G, H, I, J ]
     */
    private String columna_campo;

    public int getFila_campo() {
        return fila_campo;
    }

    public void setFila_campo(int fila_campo) {
        this.fila_campo = fila_campo;
    }

    public String getColumna_campo() {
        return columna_campo;
    }

    public void setColumna_campo(String columna_campo) {
        this.columna_campo = columna_campo;
    }


    public Coordenada(){
        fila_campo=99;// valor sin semantica..solo para inicializar.
        columna_campo="";
    }
}
