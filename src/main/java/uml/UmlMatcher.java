package uml;

@Role(role = "Interpreter:AbstractExpression")
public interface UmlMatcher {
  boolean matches(UmlEntity e);

  boolean matches(UmlClass c);

  boolean matches(UmlField f);

  boolean matches(UmlMethod m);

  boolean matches(UmlAnnotation a);
  
  boolean matchesFieldType();

  boolean matchesMethodReturnType();

  boolean matchesMethodParameterTypes();
}
