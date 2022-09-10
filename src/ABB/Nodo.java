package ABB;

/*
 *
 * @author Jose Mero
 * 
 */
public class Nodo {

 // creacion de los atributos del nodo
    private Nodo izquierdo, derecho;
    private int clave;
    private Object objeto;

// metodo constructor para inicializar variables.
    public Nodo(int clave, Object objeto) {
        this.izquierdo = null;
        this.derecho = null;
        this.clave = clave;
        this.objeto = objeto;
    }

// Metodos get y set para retornar o recibir los datos.
    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }
}
