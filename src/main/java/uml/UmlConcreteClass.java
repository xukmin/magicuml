package uml;

public interface UmlConcreteClass extends UmlClass {
  @Override
  public default <T> T accept(GenericUmlVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
