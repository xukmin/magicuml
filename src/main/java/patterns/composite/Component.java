package patterns.composite;

import java.util.Enumeration;

@uml.Role(role = "Composite:Component")
public interface Component {
  void sampleOperation();

  void add(Component component);

  void remove(Component component);

  Enumeration components();
}
