package uml;

@Role(role = "Interpreter:NonterminalExpression")
public class AndUmlMatcher implements UmlMatcher {
  public AndUmlMatcher(UmlMatcher lhs, UmlMatcher rhs) {
    this.lhs = lhs;
    this.rhs = rhs;
  }
  
  @Override
  public boolean matches(UmlEntity e) {
    return lhs.matches(e) && rhs.matches(e);
  }

  @Override
  public boolean matches(UmlClass c) {
    return lhs.matches(c) && rhs.matches(c);
  }

  @Override
  public boolean matches(UmlField f) {
    return lhs.matches(f) && rhs.matches(f);
  }

  @Override
  public boolean matches(UmlMethod m) {
    return lhs.matches(m) && rhs.matches(m);
  }

  @Override
  public boolean matches(UmlAnnotation a) {
    return lhs.matches(a) && rhs.matches(a);
  }
  
  @Override
  public boolean matchesFieldType() {
    return lhs.matchesFieldType() && rhs.matchesFieldType();
  }

  @Override
  public boolean matchesMethodReturnType() {
    return lhs.matchesMethodReturnType() && rhs.matchesMethodReturnType();
  }

  @Override
  public boolean matchesMethodParameterTypes() {
    return lhs.matchesMethodParameterTypes() && rhs.matchesMethodParameterTypes();
  }
  
  private UmlMatcher lhs;
  private UmlMatcher rhs;
}
