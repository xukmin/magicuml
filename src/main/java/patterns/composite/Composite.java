package patterns.composite;

import java.util.Vector;
import java.util.Enumeration;

@uml.Role(role = "Composite:Composite")
public class Composite implements Component {
  public void sampleOperation() {
    java.util.Enumeration enumeration = components();
    while (enumeration.hasMoreElements()) {
      ((Component) enumeration.nextElement()).sampleOperation();
    }
  }

  public void add(Component component) {
    componentVector.addElement(component);
  }

  public void remove(Component component) {
    componentVector.removeElement(component);
  }

  public Enumeration components() {
    return componentVector.elements();
  }

  public Composite() {
    System.out.println("Composite created");
  }

  private Vector componentVector = new java.util.Vector();
  private Component child1;
  private Component child2;
}
