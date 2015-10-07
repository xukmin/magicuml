package uml;

public abstract class MutableUmlEntity implements UmlEntity {
  public MutableUmlEntity(String name) {
    this.name = name;
  }
  
  @Override
  public final String getName() {
    return name;
  }
  
  @Override
  public final int getModifiers() {
    return modifiers;
  }
 
  @Override
  public final String getDeclaringClass() {
    return declaringClass;
  }
  
  public void setModifiers(int modifiers) {
    this.modifiers = modifiers;
  }
 
  public void setDeclaringClass(String declaringClass) {
    this.declaringClass = declaringClass;
  }
  
  private String name;
  private int modifiers;
  private String declaringClass;
}
