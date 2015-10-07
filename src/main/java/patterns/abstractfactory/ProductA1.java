package patterns.abstractfactory;

import uml.Role;

@Role(role = "AbstractFactory:ConcreteProduct")
public class ProductA1 implements AbstractProductA {
  public ProductA1() {
    System.out.println("Create product A1.");
  }
}
