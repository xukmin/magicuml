package uml;

public interface UmlInterface extends UmlClass {
  @Override
  public default <T> T accept(GenericUmlVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
