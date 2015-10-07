package uml;

@Role(role = "Interpreter:TerminalExpression")
public class UmlMethodParameterTypesFilter extends AllUmlMatcher {
  @Override
  public boolean matchesMethodParameterTypes() {
    return false;
  }
}
