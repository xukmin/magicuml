package uml;

// Filters all UML fields, matches everything else.
@Role(role = "Interpreter:TerminalExpression")
public class UmlFieldFilter extends AllUmlMatcher {
  @Override
  public boolean matches(UmlField f) {
    return false;
  }
}
