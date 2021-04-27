package gui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import pictures.RimplexIcon;

/**
 * @author Seth Roper
 * @version 4/26/2021
 * holds the jframe for the about window.
 *
 */
public class AboutFrame
{
  // English translation
  // I know these should honestly be read by a file, but Time is a little low so
  // this is what is happening.
  static final String ENGLISH = "  Rimplex is a  complex  number calculator software product"
      + "  developed by  Sagacious Media. Although developed primarily to handle complex "
      + "numbers, Rimplex can also perform operations on real numbers. Rimplex offers a "
      + "plethora of features that are useful when performing computations on real and complex "
      + "numbers. In addition to the ability to enter complex numbers into the calculator,"
      + "  It has support for the addition, subtraction, division, multiplication, division"
      + ",  exponentiation, logarithm,  converse, and polar form operators. Rimplex also"
      + " allows for the extraction of the real or imaginary parts of a complex number,"
      + " so that those can be calculated in isolation if desired. Rimplex can be operated"
      + " using a physical keyboard or with the provided virtual number pad.  The current"
      + " input can be cleared with the clear button, and the entire input can be reset"
      + " using the reset button.  Rimplex also automatically graphs all complex numbers"
      + " calculated onto a complex number plane, visible via the complex number plane display."
      + "  Rimplex automatically displays all calculations performed into the history display."
      + " The history can be printed to a printer through the print button. For the more complex"
      + " operations, Rimplex offers a display detailing the step by step processes used in order"
      + " to calculate the result. Rimplex also offers support for various different languages."
      + " Rimplex is a versatile complex number calculator with powerful computation features."
      + " We hope you enjoy using it.\r\n"
      + "";
  
  // French translation
  static final String FRENCH = "  Rimplex est un logiciel de calcul de nombre complexes, cr��"
      + " par Sagacious Media. M�me si c'�tait construit essentiellement pour se charger des"
      + " nombres complexes, Rimplex peut aussi r�aliser des op�rations sur des nombres r�els."
      + " Rimplex offre une pl�thore de fonctions qui sont utiles pour des computations avec"
      + " des nombres r�els et complexes. En plus de pouvoir mettre des num�ros complexes dans"
      + " la calculatrice, vous pouvez aussi faire de l�addition, soustraction, division,"
      + " multiplication, d'exponentiation, logarithme, r�ciproque, et utiliser les op�rateurs"
      + " a form polar. Rimplex permet �galement les extractions des parties r�elles ou imaginaires"
      + " d�un num�ro complexe, pour que vous puissiez le calculer tout seul, si vous le voulez."
      + " Rimplex peut fonctionner avec un vrai clavier ou virtuellement avec un pav� num�rique. "
      + "L'entr�e actuelle peut �tre d�gag�e avec le bouton \"d�gag�\", et toutes les entr�es "
      + "peuvent �tre remises � z�ro en utilisant le bouton \"r�initialiser\".  Rimplex aussi "
      + "trace automatiquement tous les nombres complexes calcul�s sur un plan num�rique complexe,"
      + " visible sur l'�cran de nombres complexes. La m�moire peut �tre imprim�e avec le bouton"
      + " �imprimer�. Pour les op�rations plus complexes, Rimplex offre un �cran qui explique �tape"
      + " par �tape le processus utilis� pour calculer le r�sultat. Rimplex peut aussi �tre utilis�"
      + " avec beaucoup de langues diff�rentes. Rimplex est une calculatrice de nombres complexes "
      + "a multiusage avec des �l�ments de computations tr�s puissants. "
      + "Nous esp�rons que vous l'aimerez! \r\n" + "";
  
  // SPanish translation
  static final String SPANISH = "  Rimplex es un calculadora de numeros complejos produce por"
      + " Sagacious Media. A�n que creado por numeros largos, Rimplex t�mbien tiene la capacidad "
      + "performa operaci�nes on numeros verdaderos. Rimplex ofrec� un pletor� de featuros que son"
      + " muy facil para utilzar cu�ndo performarando computaciones muy dificiles. T�mbien tiene"
      + " la abilidad para addicion, subtracion, divison, multiplicasion, exponentatacion, "
      + "logorithmas, conversos, y formas polares operaciones. Rimplex permite para la extraciones"
      + " de numeros imaginarios y verdaderos, entonces pueden islar la parte de numeros si quieres"
      + ".Rimplex Graphear todos los numeros complexos por el numero complexo. Rimplex mostra todos"
      + " los calculaciones en la histor�a. La Histor�a puede ser imprimido utilizando la but�n de "
      + "imprimir. Rimplex ofrece un ejemplo de los calculaciones m�s complicados Rimplex tiene "
      + "ayuda entre los lenguajes diferente. �Nosostros Oj�lamos que ustedes disfrutan "
      + "utilizando!\r\n"
      + "";

  private int width = 350;
  private int height = 200;
  private JTextPane pane;
  private JFrame frame;
  // the location of the calculator frame.
  private JFrame parentFrame;
  


  /**
   * creates a new about frame for the about window  with a JtextPane inside.
   * @param text the text for the about box.
   * @param parentFrame the main calculator's frame.
   */
  public AboutFrame(final String text, final JFrame parentFrame)
  {
    this.parentFrame = parentFrame;
    this.frame = new JFrame();
    this.pane = new JTextPane();
    this.pane.setEditable(false);
    this.pane.setBackground(Color.GRAY);
    JScrollPane scrollDisplay = new JScrollPane(this.pane);
    scrollDisplay.setViewportBorder(null);
    scrollDisplay.setBorder(null);
   // scrollDisplay.setPreferredSize(new Dimension(this.scrollWidth,this.scrollHeight));
    pane.setText(text);
   // this.frame.getContentPane().add(pane);
    this.frame.getContentPane().add(scrollDisplay);
  }
  

  /**
   * create the JFrame and makes it visible.
   */
  public void createFrame()
  {
    // set to dispose on close. 
    this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.frame.setSize(width, height);
    this.frame.setResizable(false);
    ImageIcon icon = new ImageIcon(RimplexIcon.class.getResource("/pictures/logoRimplex.png"));
    Image newimg = icon.getImage().getScaledInstance(1000, 1000, java.awt.Image.SCALE_SMOOTH);
    frame.setLocation(this.parentFrame.getX(),
        (int) (this.parentFrame.getY() + 0.5 * this.parentFrame.getHeight()));
    frame.setIconImage(newimg);
    frame.setVisible(true);
  }

  /**
   * @param text
   *          the about menu to change
   */
  public void changeText(final String text)
  {
    this.pane.setText(text);
  }
  
  /**
   * @param title the title of the jframe
   */
  public void changeTitle(final String title)
  {
    this.frame.setTitle(title);
  }
  
  
}
