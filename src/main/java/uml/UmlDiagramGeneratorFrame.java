package uml;

import javax.swing.JFrame;

/**
 * 
 */
@SuppressWarnings("serial")
public class UmlDiagramGeneratorFrame extends JFrame {
  public UmlDiagramGeneratorFrame() {
    setTitle("UML Diagram Generator");
    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    add(new UmlDiagramGeneratorPanel(this));
    setLocationRelativeTo(null);
  }

  public static final int DEFAULT_WIDTH = 800;
  public static final int DEFAULT_HEIGHT = 600;
}
