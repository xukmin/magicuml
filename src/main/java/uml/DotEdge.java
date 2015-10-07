package uml;

import java.util.Formatter;
import java.util.Map;

@Role(role = "Composite:Leaf")
public class DotEdge extends DotElement {
  public DotEdge(String src, String dst, Map<String, String> attributes) {
    super(attributes);
    this.src = src;
    this.dst = dst;
  }

  public DotEdge(String src, String dst) {
    this.src = src;
    this.dst = dst;
  }

  @Override
  public Formatter appendTo(Formatter formatter) {
    formatter.format(
        "  %s -> %s [\n",
        src.matches("^[a-zA-Z0-9]*$") ? src : String.format("\"%s\"", src),
        dst.matches("^[a-zA-Z0-9]*$") ? dst : String.format("\"%s\"", dst));
    super.appendTo(formatter);
    formatter.format("  ];\n\n");

    return formatter;
  }

  private String src;
  private String dst;
}