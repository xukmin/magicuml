package uml;

import java.util.Map;
import java.util.TreeMap;

@Role(role = "Decorator:ConcreteComponent")
public class DefaultDotUmlClassDiagramStyle implements DotUmlClassDiagramStyle {
  @Override
  public Map<String, String> getDiagramStyle() {
    Map<String, String> attributes = new TreeMap<String, String>();
    attributes.put("rankdir", "BT");
    
    return attributes;
  }

  private Map<String, String> getClassStyle() {
    Map<String, String> attributes = new TreeMap<String, String>();
    attributes.put("shape", "plaintext");
    attributes.put("fontsize", "9");
    return attributes;
  }
  
  @Override
  public Map<String, String> getInterfaceStyle() {
    return getClassStyle();
  }

  @Override
  public Map<String, String> getAbstractClassStyle() {
    return getClassStyle();
  }

  @Override
  public Map<String, String> getConcreteClassStyle() {
    return getClassStyle();
  }

  private Map<String, String> getRelationStyle() {
    Map<String, String> attributes = new TreeMap<String, String>();
    // Set minimum length to 2 (default is 1) to avoid too short edge which
    // causes arrowhead and tail be cluttered together (e.g. for
    // getContainsStyle()).
    attributes.put("minlen", "2");
    attributes.put("fontsize", "9");
    
    return attributes;
  }
  
  @Override
  public Map<String, String> getImplementsStyle() {
    Map<String, String> attributes = getRelationStyle();
    attributes.put("arrowhead", "empty");
    attributes.put("style", "dashed");
    
    return attributes;
  }

  @Override
  public Map<String, String> getExtendsStyle() {
    Map<String, String> attributes = getRelationStyle();
    attributes.put("arrowhead", "empty");
    
    return attributes;
  }

  @Override
  public Map<String, String> getContainsStyle() {
    Map<String, String> attributes = getRelationStyle();
    attributes.put("dir", "both");
    attributes.put("arrowhead", "vee");
    attributes.put("arrowtail", "odiamond");
    attributes.put("constraint", "false");
    
    return attributes;
  }

  @Override
  public Map<String, String> getUsesStyle() {
    Map<String, String> attributes = getRelationStyle();
    attributes.put("arrowhead", "vee");
    attributes.put("arrowtail", "empty");
    attributes.put("constraint", "false");
    
    return attributes;
  }

  @Override
  public Map<String, String> getCreatesStyle() {
    Map<String, String> attributes = getRelationStyle();
    attributes.put("arrowhead", "vee");
    attributes.put("arrowtail", "empty");
    attributes.put("constraint", "false");
    attributes.put("style", "dashed");
    
    return attributes;
  }

  private Map<String, String> getClassFrameStyle() {
    Map<String, String> attributes = new TreeMap<String, String>();
    attributes.put("border", "0");
    attributes.put("cellborder", "1");
    attributes.put("cellspacing", "0");
    
    return attributes; 
  }
  
  @Override
  public Map<String, String> getInterfaceFrameStyle() {
    Map<String, String> attributes = getClassFrameStyle();
    attributes.put("border", "0");
    attributes.put("cellborder", "1");
    attributes.put("cellspacing", "0");
    
    return attributes;
  }

  @Override
  public Map<String, String> getAbstractClassFrameStyle() {
    Map<String, String> attributes = getClassFrameStyle();
    attributes.put("border", "0");
    attributes.put("cellborder", "1");
    attributes.put("cellspacing", "0");
    
    return attributes;
  }

  @Override
  public Map<String, String> getConcreteClassFrameStyle() {
    Map<String, String> attributes = getClassFrameStyle();
    
    return attributes;
  }
  
  @Override
  public Map<String, String> getInterfaceNameStyle() {
    return new TreeMap<String, String>();
  }

  @Override
  public Map<String, String> getAbstractClassNameStyle() {
    return new TreeMap<String, String>();
  }

  @Override
  public Map<String, String> getConcreteClassNameStyle() {
    return new TreeMap<String, String>();
  }

  @Override
  public Map<String, String> getInterfaceFieldStyle() {
    return new TreeMap<String, String>();
  }

  @Override
  public Map<String, String> getAbstractClassFieldStyle() {
    return new TreeMap<String, String>();
  }

  @Override
  public Map<String, String> getConcreteClassFieldStyle() {
    return new TreeMap<String, String>();
  }

  @Override
  public Map<String, String> getInterfaceMethodStyle() {
    return new TreeMap<String, String>();
  }

  @Override
  public Map<String, String> getAbstractClassMethodStyle() {
    return new TreeMap<String, String>();
  }

  @Override
  public Map<String, String> getConcreteClassMethodStyle() {
    return new TreeMap<String, String>();
  }
  
  @Override
  public Map<String, String> getInvisibleStyle() {
    Map<String, String> attributes = new TreeMap<String, String>();
    attributes.put("style", "invisible");
    attributes.put("arrowhead", "none");
    attributes.put("arrowtail", "none");
    attributes.put("constraint", "true");
    
    return attributes;
  }
  
  @Override
  public Map<String, String> getInvisibleNoConstraintStyle() {
    Map<String, String> attributes = new TreeMap<String, String>();
    attributes.put("style", "invisible");
    attributes.put("arrowhead", "none");
    attributes.put("arrowtail", "none");
    attributes.put("constraint", "false");
    
    return attributes;
  }

  @Override
  public Map<String, String> getCommentStyle() {
    Map<String, String> attributes = getClassStyle();
    attributes.put("style", "filled");
    attributes.put("fillcolor", "#FFF9C4");
    attributes.put("shape", "note");
    
    return attributes; 
  }

  @Override
  public Map<String, String> getCommentsStyle() {
    Map<String, String> attributes = getRelationStyle();
    attributes.put("style", "dashed");
    attributes.put("arrowhead", "none");
    attributes.put("constraint", "false");
    
    return attributes;
  }
}
