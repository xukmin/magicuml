package uml;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

// TODO: subgraph
@Role(role = "Composite:Composite")
public class DotGraph extends DotElement {
  public DotGraph() {
  }

  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    
    this.name = name;
  }

  public void addNode(DotNode node) {
    nodes.add(node);
  }

  public void addEdge(DotEdge edge) {
    edges.add(edge);
  }
 
  public void addSection(DotSection section) {
    sections.add(section);
    
  }
  
  @Override
  public Formatter appendTo(Formatter formatter) {
    formatter.format("digraph %s {\n", name);
    
    super.appendTo(formatter);
    
    for (DotNode node : nodes) {
      node.appendTo(formatter);
    }
    
    for (DotEdge edge : edges) {
      edge.appendTo(formatter);
    }
   
    for (DotSection section : sections) {
      section.appendTo(formatter);
    }
    
    formatter.format("}\n");
    
    return formatter;
  }

  private String name = "unnamed";
  private List<DotNode> nodes = new ArrayList<DotNode>();
  private List<DotEdge> edges = new ArrayList<DotEdge>();
  private List<DotSection> sections = new ArrayList<DotSection>();
}
