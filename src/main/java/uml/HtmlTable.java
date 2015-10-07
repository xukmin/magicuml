package uml;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

// We intentionally skipped the HTML table row concept, since in our case each
// row only has a single column.
public class HtmlTable {
  public HtmlTable(Map<String, String> attributes) {
    this.attributes = attributes;
  }
 
  public HtmlTable() {
    this(new TreeMap<String, String>());
  }
  
  public void addAttribute(String key, String value) {
    attributes.put(key, value);
  }
  
  public HtmlTableCell addCell(Map<String, String> attributes) {
    HtmlTableCell cell = new HtmlTableCell(attributes);
    cells.add(cell);
    return cell;
  }
 
  public HtmlTableCell addCell() {
    return addCell(new TreeMap<String, String>());
  }
  
  private void appendOpeningTag(Formatter formatter) {
    if (attributes.isEmpty()) {
      formatter.format("<table>\n");
    } else {
      formatter.format("<table");
      for (Entry<String, String> entry : attributes.entrySet()) {
        formatter.format("  %s='%s'", entry.getKey(), entry.getValue());
      }
      formatter.format(">\n");
    }
  }
 
  private void appendClosingTag(Formatter formatter) {
    formatter.format("</table>\n");  
  }
  
  private void appendCells(Formatter formatter) {
    for (HtmlTableCell cell : cells) {
      formatter.format("%s", cell.toString());
    }
  }

  @Override
  public String toString() {
    Formatter formatter = new Formatter();
    appendOpeningTag(formatter);
    appendCells(formatter);
    appendClosingTag(formatter);
    return formatter.toString();
  }
  
  private Map<String, String> attributes;
  private List<HtmlTableCell> cells = new ArrayList<HtmlTableCell>();
}
