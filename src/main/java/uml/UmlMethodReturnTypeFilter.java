package uml;

@Role(role = "Interpreter:TerminalExpression")
public class UmlMethodReturnTypeFilter extends AllUmlMatcher {
  @Override
  public boolean matchesMethodReturnType() {
    return false;
  }
}
