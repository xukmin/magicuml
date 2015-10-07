package uml;

@Role(role = "Interpreter:NonterminalExpression")
public class NotUmlMatcher implements UmlMatcher {
  public NotUmlMatcher(UmlMatcher matcher) {
    this.matcher = matcher;
  }
  
  @Override
  public boolean matches(UmlEntity e) {
    return !matcher.matches(e);
  }

  @Override
  public boolean matches(UmlClass c) {
    return !matcher.matches(c);
  }

  @Override
  public boolean matches(UmlField f) {
    return !matcher.matches(f);
  }

  @Override
  public boolean matches(UmlMethod m) {
    return !matcher.matches(m);
  }

  @Override
  public boolean matches(UmlAnnotation a) {
    return !matcher.matches(a);
  }
  
  @Override
  public boolean matchesFieldType() {
    return !matcher.matchesFieldType();
  }

  @Override
  public boolean matchesMethodReturnType() {
    return !matcher.matchesMethodReturnType();
  }

  @Override
  public boolean matchesMethodParameterTypes() {
    return !matcher.matchesMethodParameterTypes();
  }
  
  private UmlMatcher matcher;  
}
