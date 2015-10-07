package uml;

import java.util.List;

public interface UmlClass extends UmlEntity {

  public String getName();
  
  public String getSuperclass();

  public List<String> getSuperinterfaces();

  public List<UmlField> getFields();
  
  public List<UmlMethod> getMethods();
  
  public List<UmlAnnotation> getAnnotations();

  public boolean isPrimitive();
}
