package patterns.abstractfactory;

import uml.Role;

@Role(role = "AbstractFactory:ConcreteProduct")
public class ProductA2 implements AbstractProductA {
  public ProductA2() {
    System.out.println("Create product A2.");
  }
}
