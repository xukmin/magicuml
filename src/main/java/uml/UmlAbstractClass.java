package uml;

// TODO: MutableUmlAbstractClass
public interface UmlAbstractClass extends UmlClass {
  @Override
  default <T> T accept(GenericUmlVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
