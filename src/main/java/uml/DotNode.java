package uml;

import java.util.Formatter;
import java.util.Map;

@Role(role = "Composite:Leaf")
public class DotNode extends DotElement {
  public DotNode(String name, Map<String, String> attributes) {
    super(attributes);
    this.name = name;
  }

  public DotNode(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  @Override
  public Formatter appendTo(Formatter formatter) {
    if (name.matches("^[a-zA-Z0-9]*$")) {
      formatter.format("  %s [\n", name);
    } else {
      formatter.format("  \"%s\" [\n", name);
    }
    super.appendTo(formatter);
    formatter.format("  ];\n\n");
    
    return formatter;
  }

  private String name;
}
