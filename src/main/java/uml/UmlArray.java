package uml;

import java.util.List;

public class UmlArray implements UmlClass {
  public UmlArray() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public <T> T accept(GenericUmlVisitor<T> visitor) {
    return visitor.visit(this);
  }

  @Override
  public List<UmlField> getFields() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<UmlMethod> getMethods() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isPrimitive() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return null;
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
  public String getSuperclass() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<String> getSuperinterfaces() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<UmlAnnotation> getAnnotations() {
    // TODO Auto-generated method stub
    return null;
  }
}
