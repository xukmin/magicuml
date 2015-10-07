package uml;

import java.lang.annotation.Annotation;

public interface UmlAnnotation extends UmlEntity {
  <T extends Annotation> T getAnnotation();
  
  @Override
  default <T> T accept(GenericUmlVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
