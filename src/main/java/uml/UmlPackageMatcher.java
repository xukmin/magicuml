package uml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

// Filters classes which are not in the specified package, matches everything else.
@Role(role = "Interpreter:TerminalExpression")
public class UmlPackageMatcher extends AllUmlMatcher {
  public UmlPackageMatcher(Collection<String> packageNames) {
    for (String p : packageNames) {
      packagePrefixes.add(String.format("%s.", p));
    }
  }
  public UmlPackageMatcher(String packageName) {
    this(Arrays.asList(packageName));
  }
  
  @Override
  public boolean matches(UmlClass c) {
    for (String prefix : packagePrefixes) {
      if (c.getName().startsWith(prefix)) {
        return true;
      }
    }
    return false;
  }

  public static UmlPackageMatcher createFromClasses(Collection<String> classes) {
    HashSet<String> packages = new HashSet<String>();
    for (String c : classes) {
      packages.add(c.substring(0, c.lastIndexOf('.')));
    }
    return new UmlPackageMatcher(packages);
  }

  private List<String> packagePrefixes = new ArrayList<String>();
}
