package patterns.builder;

import uml.Role;

@Role(role = "Builder:Director")
public class Director {
  public void construct(Builder builder) {}
  
  private static ConcreteBuilderA __invisible__noconstraint__concreteBuilderA;
  private static ConcreteBuilderB __invisible__noconstraint__concreteBuilderB;
}
