package uml;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Role(role = "Interpreter:TerminalExpression")
public class UmlClassMatcher extends AllUmlMatcher {
  public UmlClassMatcher(Collection<String> classes) {
    for (String c : classes) {
      this.classes.add(c);
    }
  }

  @Override
  public boolean matches(UmlClass c) {
    return classes.contains(c.getName());
  }

  private Set<String> classes = new HashSet<String>();
}
