package uml;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

@Role(role = "Composite:Component")
public class DotElement {
  public DotElement(Map<String, String> attributes) {
    this.attributes = attributes;
    this.statements = new ArrayList<String>();
  }
  
  public DotElement() {
    this(new TreeMap<String, String>());
  }
  
  public void addAttribute(String name, String value) {
    attributes.put(name, value);
  }
 
  public void addStatement(String statement) {
    statements.add(statement);
  }
  
  public Formatter appendTo(Formatter formatter) {
    for (Entry<String, String> entry : attributes.entrySet()) {
      formatter.format("    %s = ", entry.getKey());
      final String value = entry.getValue();      
      if (value.startsWith("<") && value.endsWith(">")) {
        // value is HTML.
        formatter.format("%s;\n", value);
      } else {
        // value is plain text.
        formatter.format("\"%s\";\n", value);
      }
    }
    formatter.format("\n");
    
    for (String statement : statements) {
      formatter.format("    %s;\n", statement);
    }
    return formatter;
  }

  @Override
  public String toString() {
    try (Formatter formatter = new Formatter()) {
      return appendTo(formatter).toString();
    }
  }

  private Map<String, String> attributes;
  private List<String> statements;
}
