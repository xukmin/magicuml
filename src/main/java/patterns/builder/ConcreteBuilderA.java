package patterns.builder;

import uml.Role;

@Role(role = "Builder:ConcreteBuilder")
public class ConcreteBuilderA implements Builder {
  @Override
  public void buildPartA() {
  }

  @Override
  public void buildPartB() {
  }

  @Override
  public void buildPartC() {
  }
  
  ProductA getResult() {
    return null;
  }
}
