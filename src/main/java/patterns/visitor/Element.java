package patterns.visitor;

public interface Element {
  void Accept(Visitor v);
  
  // TODO: Remove the hack.
  static ConcreteVisitor1 __invisible__concreteVisitor1 = null;
  static ConcreteVisitor2 __invisible__concreteVisitor2 = null;
}
