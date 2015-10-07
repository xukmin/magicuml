package patterns.composite;

@uml.Role(role = "Composite:Client")
public class Client {
  public void handleComponent(Component component) {}
  
  private Composite __invisible__noconstraint__composite;
  private Leaf __invisible__noconstraint__leaf;
}
