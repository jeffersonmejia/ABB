package ABB;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Graficar extends JPanel {

  //ATRIBUTOS
  private final Arbol arbol;
  public static final int DIAMETRO = 40;
  public static int RADIO = DIAMETRO / 2;
  public static final int ANCHO = 50;
  private JLabel label;

  //CONSTRUCTOR
  public Graficar(Arbol miArbol) {
    this.arbol = miArbol;
    this.setBackground(Color.white);
    label = new JLabel("ABB");
    label.setForeground(Color.white);
    label.setBounds(0, 0, 0, 0);
    add(label);
    repaint();
  }

  //MÉTODO SOBRESCRITO
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    pintar(g, getWidth() / 2, 35, arbol.getRaiz());
  }

  //MÉTODO PRIVADO
  private void pintar(Graphics graphic, int x, int y, Nodo nodo) {
    if (nodo == null) {
      return;
    }
    graphic.setColor(Color.blue);
    int EXTRA = new Arbol().nodosCompletos(nodo) * (ANCHO / 2);

    graphic.fillOval(x, y, DIAMETRO, DIAMETRO);
    graphic.setColor(Color.white);
    graphic.drawString(nodo.getClave() + "", x + 12, y + 23);
    graphic.setColor(Color.blue);

    if (nodo.getIzquierdo() != null) {
      graphic.drawLine(x + RADIO - 5, y + RADIO + 15, x - ANCHO - EXTRA + RADIO, y - 15 + ANCHO + RADIO);
    }

    if (nodo.getDerecho() != null) {
      graphic.drawLine(x + RADIO - 5, y + RADIO + 15, x + ANCHO + EXTRA + RADIO, y - 15 + ANCHO + RADIO);
    }

    pintar(graphic, x - ANCHO - EXTRA, y + ANCHO, nodo.getIzquierdo());
    pintar(graphic, x + ANCHO + EXTRA, y + ANCHO, nodo.getDerecho());
  }
}
