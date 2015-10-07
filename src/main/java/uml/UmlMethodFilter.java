package uml;

// Filters all UML methods, matches everything else.
@Role(role = "Interpreter:TerminalExpression")
public class UmlMethodFilter extends AllUmlMatcher {
  @Override
  public boolean matches(UmlMethod method) {
    return false;
  }
}
