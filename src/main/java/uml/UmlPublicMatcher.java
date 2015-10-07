package uml;

import java.lang.reflect.Modifier;

/**
 * This class matches all public UML entities, and filters everything else.
 *
 */
@Role(role = "Interpreter:TerminalExpression")
public class UmlPublicMatcher extends AllUmlMatcher {

  @Override
  public boolean matches(UmlEntity e) {
    return Modifier.isPublic(e.getModifiers());
  }

  @Override
  public boolean matches(UmlClass c) {
    return matches((UmlEntity) c);
  }

  @Override
  public boolean matches(UmlField f) {
    return matches((UmlEntity) f);
  }

  @Override
  public boolean matches(UmlMethod m) {
    return matches((UmlEntity) m);
  }

}
