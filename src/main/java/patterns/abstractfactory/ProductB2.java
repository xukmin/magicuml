package patterns.abstractfactory;

import uml.Role;

@Role(role = "AbstractFactory:ConcreteProduct")
public class ProductB2 implements AbstractProductB {
  public ProductB2() {
    System.out.println("Create product B2.");
  }
}
