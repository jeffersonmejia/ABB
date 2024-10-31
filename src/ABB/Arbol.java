package ABB;

import java.awt.Color;
import javax.swing.JFrame;
import java.util.Scanner;

public class Arbol {

  private Nodo raiz;
  int info;
  Nodo izq, der;
  public boolean graficado = false;
  Scanner in = new Scanner(System.in);
  JFrame ventana;

  /**
   * Inicializa la raíz en nulo
   */
  public Arbol() {
    this.raiz = null;
  }

  /**
   *
   * Verifica si el árbol está vacío
   *
   * @param nodo recibe un nodo
   *
   * @return devuelve verdadero si está vacío
   */
  public boolean esVacio(Nodo nodo) {
    return nodo == null;
  }

  public boolean esVacio() {
    return this.raiz == null;
  }

  public void insertar(int clave, Object objeto) {
    if (this.raiz == null) {
      this.raiz = new Nodo(clave, objeto);
      System.out.println(">> Nodo insertado con éxito en la raíz padre del árbol");
      System.out.print("*Escribe 1 para continuar: ");
      int wait = in.nextInt();
    } else {
      this.insertarBinario(clave, objeto, this.raiz);
    }
  }

  private void insertarBinario(int clave, Object objeto, Nodo puntero) {
    Nodo nuevo = new Nodo(clave, objeto);
    // INSERTA A LA IZQUIERDA
    if (clave < puntero.getClave()) {
      if (puntero.getIzquierdo() == null) {
        puntero.setIzquierdo(nuevo);
        System.out.println(">> Nodo insertado con éxito a la izquierda");
        System.out.print("*Escribe 1 para continuar: ");
        int wait = in.nextInt();
      } else {
        this.insertarBinario(clave, objeto, puntero.getIzquierdo());
      }
    } // INSERTA A LA DERECHA
    else if (clave > puntero.getClave()) {
      if (puntero.getDerecho() == null) {
        puntero.setDerecho(nuevo);
        System.out.println(">> Nodo insertado con éxito a la derecha");
        System.out.print("*Escribe 1 para continuar: ");
        int wait = in.nextInt();
      } else {
        this.insertarBinario(clave, objeto, puntero.getDerecho());
      }
    } else {
      System.out.println("(x) Repetido. Nodo no insertado");
    }
  }

  /**
   *
   * @return devuelve la raiz principal del árbol
   */
  public Nodo getRaiz() {
    return raiz;
  }

  public int nodosCompletos(Nodo r) {
    if (r == null) {
      return 0;
    } else {
      if (r.getIzquierdo() != null && r.getDerecho() != null) {
        return nodosCompletos(r.getIzquierdo()) + nodosCompletos(r.getDerecho()) + 1;
      }
      return nodosCompletos(r.getIzquierdo()) + nodosCompletos(r.getDerecho());
    }
  }

  /**
   *
   * Grafica el árbol
   */
  public void graficar() {
    if (!esVacio(this.raiz)) {
      Graficar Migrafico = new Graficar(this);
      this.ventana = new JFrame("Árbol binario");

      this.ventana.setDefaultCloseOperation(3);
      this.ventana.setSize(800, 600);
      this.ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
      this.ventana.setLocationRelativeTo(null);
      this.ventana.setBackground(Color.black);
      this.ventana.getContentPane().add(Migrafico);
      this.ventana.setVisible(true);
      graficado = true;
    }
  }

  public void visibilizar(boolean status) {
    if (status) {
      this.ventana.setVisible(true);
    } else {
      this.ventana.setVisible(false);
    }
  }

  /**
   *
   * Llama al método que aplica la lógica de ordenamiento
   */
  public void mostraror() {
    mostraor(this.raiz);
  }

  /**
   *
   * Muestra los nodos del árbol en orden descendente
   *
   * @param nodo recibe un nodo inicial
   */
  public void mostraor(Nodo nodo) {
    if (!esVacio(nodo)) {
      mostraor(nodo.getDerecho());
      System.out.print("Clave: " + nodo.getClave() + " | Objeto: " + nodo.getObjeto() + " | ");
      mostraor(nodo.getIzquierdo());
    }
  }

  /**
   *
   * Muestra los nodos del subarbol izquierdo de la raiz
   */
  public void mostrarIzquierdo() {
    mostraIzquierdo(this.raiz.getIzquierdo());
  }

  // metedo con recursividad
  public void mostraIzquierdo(Nodo nodo) {
    if (!esVacio(nodo)) {
      if (nodo.getClave() < raiz.getClave()) {
        mostraIzquierdo(nodo.getDerecho());
      }
      mostraIzquierdo(nodo.getIzquierdo());
      System.out.print("Clave: " + nodo.getClave() + " | Objeto: " + nodo.getObjeto() + " | ");
    }
  }

  /**
   *
   * Metodo que sera llamado en la clase principal
   */
  public void mostrarDerecho() {
    mostrarDerecho(this.raiz.getDerecho());
  }

  //metodo recursividad
  public void mostrarDerecho(Nodo nodo) {
    if (!esVacio(nodo)) {
      if (nodo.getClave() > raiz.getClave()) {
        mostrarDerecho(nodo.getDerecho());
      }
      mostrarDerecho(nodo.getIzquierdo());
      System.out.print("Clave: " + nodo.getClave() + " | Objeto: " + nodo.getObjeto() + " | ");
    }
  }

  /**
   * @param referencia valor del nodo
   */
  public void consultarPorReferencia(int referencia) {
    consultarPorReferencia(this.raiz, referencia);
  }

  /**
   * @param referencia valor del nodo
   * @param nodo apunta al siguiente nodo para avanzar
   */
  private void consultarPorReferencia(Nodo puntero, int referencia) {
    if (puntero != null) {
      if (puntero.getClave() == referencia) {
        System.out.print("Clave: " + puntero.getClave() + " | Objeto: " + puntero.getObjeto() + " ");
      } else {
        if (referencia < puntero.getClave()) {
          consultarPorReferencia(puntero.getIzquierdo(), referencia);
        } else {
          consultarPorReferencia(puntero.getDerecho(), referencia);
        }
      }
    } else {
      System.out.println("(x) El nodo ingresado no existe");
    }
  }
}
