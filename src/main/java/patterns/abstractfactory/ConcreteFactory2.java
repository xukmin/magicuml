package patterns.abstractfactory;

import uml.Role;

@Role(role = "AbstractFactory:ConcreteFactory")
public class ConcreteFactory2 implements AbstractFactory {
  @Override
  public ProductA2 createProductA() {
    return new ProductA2();
  }

  @Override
  public ProductB2 createProductB() {
    return new ProductB2();
  }
}
