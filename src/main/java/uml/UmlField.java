package uml;

public interface UmlField extends UmlEntity {
  String getType();
  
  @Override
  default <T> T accept(GenericUmlVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
