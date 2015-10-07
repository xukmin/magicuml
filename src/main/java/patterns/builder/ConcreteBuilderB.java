package patterns.builder;

import uml.Role;

@Role(role = "Builder:ConcreteBuilder")
public class ConcreteBuilderB implements Builder {
  @Override
  public void buildPartA() {
  }

  @Override
  public void buildPartB() {
  }

  @Override
  public void buildPartC() {
  }
  
  public ProductB getResult() {
    return null;
  }
}
