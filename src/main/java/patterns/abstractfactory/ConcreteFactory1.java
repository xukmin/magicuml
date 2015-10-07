package patterns.abstractfactory;

import uml.Role;

@Role(role = "AbstractFactory:ConcreteFactory")
public class ConcreteFactory1 implements AbstractFactory {
  @Override
  public ProductA1 createProductA() {
    return new ProductA1();
  }

  @Override
  public ProductB1 createProductB() {
    return new ProductB1();
  }
}
