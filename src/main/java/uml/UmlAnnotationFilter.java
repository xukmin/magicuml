package uml;

@Role(role = "Interpreter:TerminalExpression")
public class UmlAnnotationFilter extends AllUmlMatcher {
  @Override
  public boolean matches(UmlAnnotation a) {
    return false;
  }
}
