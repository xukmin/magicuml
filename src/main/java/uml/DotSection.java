package uml;

import java.util.Formatter;

@Role(role = "Composite:Leaf")
public class DotSection extends DotElement {
  @Override
  public Formatter appendTo(Formatter formatter) {
    formatter.format("  {\n");
    super.appendTo(formatter);
    formatter.format("  };\n");
    
    return formatter;
  }
}
