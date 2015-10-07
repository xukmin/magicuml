package patterns.builder;

import uml.Role;

@Role(role = "Builder:Builder")
public interface Builder {
  void buildPartA();
  void buildPartB();
  void buildPartC();
}
