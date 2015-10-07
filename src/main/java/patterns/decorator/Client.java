package patterns.decorator;

@uml.Role(role = "Decorator:Client")
public class Client {
  public void handle(Component c) {}
 
  private ConcreteComponent __invisible__noconstraint__concreteComponent;
  private ConcreteDecoratorA __invisible__noconstraint__concreteDecoratorA;
  private ConcreteDecoratorB __invisible__noconstraint__concreteDecoratorB;
}
