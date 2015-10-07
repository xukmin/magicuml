package uml;

import java.lang.annotation.Annotation;

public class MutableUmlAnnotation extends MutableUmlEntity implements UmlAnnotation {
  public MutableUmlAnnotation(Annotation annotation) {
    super(annotation.annotationType().getCanonicalName());
    this.annotation = annotation;
  }

  @Override
  public <T> T accept(GenericUmlVisitor<T> visitor) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <T extends Annotation> T getAnnotation() {
    return (T) annotation;
  }

  private Annotation annotation;
}
