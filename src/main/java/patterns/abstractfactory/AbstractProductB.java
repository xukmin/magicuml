package patterns.abstractfactory;

import uml.Role;

@Role(role = "AbstractFactory:AbstractProduct")
public interface AbstractProductB {
  // TODO: Remove the hack.
  static ProductA1 __invisible__productA1 = null;
  static ProductA2 __invisible__productA2 = null;
}
