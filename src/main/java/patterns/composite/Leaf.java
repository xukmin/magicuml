package patterns.composite;

import java.util.Enumeration;
import java.util.Vector;

@uml.Role(role = "Composite:Leaf")
public class Leaf implements Component {
  public void sampleOperation() {
    // Write your code here
  }

  public void add(Component component) {
    componentVector.addElement(component);
  }

  public void remove(Component component) {
    componentVector.removeElement(component);
  }

  public Enumeration components() {
    // Write your code here
    return null;
  }

  private Vector componentVector = new java.util.Vector();

  public Leaf() {
    System.out.println("Leaf created");
  }
}
