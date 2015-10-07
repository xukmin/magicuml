package patterns.decorator;

@uml.Role(role = "Decorator:ConcreteDecorator")
public class ConcreteDecoratorA implements Decorator {
  @Override
  public void operation() {
  }
  
  private int addedState;
}
