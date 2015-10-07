package patterns.abstractfactory;

import uml.Role;

@Role(role = "AbstractFactory:ConcreteProduct")
public class ProductB1 implements AbstractProductB {
  public ProductB1() {
    System.out.println("Create product B1.");
  }
}
