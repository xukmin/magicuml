package uml;

public interface UmlEntity {
  String getName();

  int getModifiers();

  String getDeclaringClass();
  
  <T> T accept(GenericUmlVisitor<T> visitor);
}
