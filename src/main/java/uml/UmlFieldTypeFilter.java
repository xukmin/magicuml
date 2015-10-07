package uml;

@Role(role = "Interpreter:TerminalExpression")
public class UmlFieldTypeFilter extends AllUmlMatcher {
  @Override
  public boolean matchesFieldType() {
    return false;
  }
}
