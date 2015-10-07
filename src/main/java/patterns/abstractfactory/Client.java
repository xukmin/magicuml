package patterns.abstractfactory;

import uml.Role;

@Role(role = "AbstractFactory:Client")
public class Client {
  public void create(AbstractFactory creator) {
    dealWithProductA(creator.createProductA());
    dealWithProductB(creator.createProductB());
  }

  public void dealWithProductA(AbstractProductA productA) {}
  
  public void dealWithProductB(AbstractProductB productB) {}
 
  // TODO: Remove the hack.
  private ConcreteFactory1 __invisible__noconstraint__concreteFactory1;
  private ConcreteFactory2 __invisible__noconstraint__concreteFactory2;
}
