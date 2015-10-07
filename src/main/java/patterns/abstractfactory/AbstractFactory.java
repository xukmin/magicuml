package patterns.abstractfactory;

import uml.Role;

@Role(role = "AbstractFactory:AbstractFactory")
public interface AbstractFactory {
  public AbstractProductA createProductA();

  public AbstractProductB createProductB();
}
