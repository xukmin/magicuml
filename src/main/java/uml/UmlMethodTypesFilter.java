package uml;

@Role(role = "Interpreter:TerminalExpression")
public class UmlMethodTypesFilter extends AndUmlMatcher {
  public UmlMethodTypesFilter() {
    super(new UmlMethodReturnTypeFilter(), new UmlMethodParameterTypesFilter());
  }
}
