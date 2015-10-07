package uml;

import java.util.Formatter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class HtmlTableCell {
  public HtmlTableCell(Map<String, String> attributes) {
    this.attributes = attributes;
  }
 
  public HtmlTableCell() {
    this(new TreeMap<String, String>());
  }
  
  public HtmlTableCell addAttribute(String key, String value) {
    attributes.put(key, value);
    return this;
  }
  
  public HtmlTableCell addText(String text) {
    buffer.append(text);
    return this;
  }
  
  private void appendOpeningTag(Formatter formatter) {
    formatter.format("<tr>");
    if (attributes.isEmpty()) {
      formatter.format("<td>\n");
    } else {
      formatter.format("<td");
      for (Entry<String, String> entry : attributes.entrySet()) {
        formatter.format("  %1$s='%2$s'", entry.getKey(), entry.getValue());
      }
      formatter.format(">\n");
    }
  }
 
  private void appendClosingTag(Formatter formatter) {
    formatter.format("</td>\n");
    formatter.format("</tr>\n");
  }
  
  private void appendText(Formatter formatter) {
    formatter.format("%s\n", buffer.toString());
  }

  @Override
  public String toString() {
    Formatter formatter = new Formatter();
    appendOpeningTag(formatter);
    appendText(formatter);
    appendClosingTag(formatter);
    return formatter.toString();
  }
  
  private Map<String, String> attributes;
  private StringBuffer buffer = new StringBuffer();
}

