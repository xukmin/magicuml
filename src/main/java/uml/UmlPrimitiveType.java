package uml;

import java.util.ArrayList;
import java.util.List;

public class UmlPrimitiveType implements UmlClass {
  public UmlPrimitiveType(String name) {
    this.name = name;
  }
  
  @Override
  public <T> T accept(GenericUmlVisitor<T> visitor) {
    return visitor.visit(this);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getModifiers() {
    return 0;
  }

  @Override
  public String getDeclaringClass() {
    return null;
  }
  
  @Override
  public List<UmlField> getFields() {
    return fields;
  }

  @Override
  public List<UmlMethod> getMethods() {
    return methods;
  }

  @Override
  public boolean isPrimitive() {
    return true;
  }

  @Override
  public String getSuperclass() {
    return null;
  }

  @Override
  public List<String> getSuperinterfaces() {
    return null;
  }

  @Override
  public List<UmlAnnotation> getAnnotations() {
    return null;
  }
  
  private String name;
  private List<UmlField> fields = new ArrayList<UmlField>();
  private List<UmlMethod> methods = new ArrayList<UmlMethod>();
}
