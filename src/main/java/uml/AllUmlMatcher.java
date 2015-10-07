package uml;

@Role(role = "Interpreter:TerminalExpression")
public class AllUmlMatcher implements UmlMatcher {
  @Override
  public boolean matches(UmlEntity e) {
    return true;
  }

  @Override
  public boolean matches(UmlClass c) {
    return true;
  }

  @Override
  public boolean matches(UmlField f) {
    return true;
  }

  @Override
  public boolean matches(UmlMethod m) {
    return true;
  }

  @Override
  public boolean matches(UmlAnnotation a) {
    return true;
  }
  
  @Override
  public boolean matchesFieldType() {
    return true;
  }

  @Override
  public boolean matchesMethodReturnType() {
    return true;
  }

  @Override
  public boolean matchesMethodParameterTypes() {
    return true;
  }
}
