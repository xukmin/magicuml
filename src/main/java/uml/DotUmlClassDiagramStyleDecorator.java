package uml;

import java.util.Map;

@Role(role = "Decorator:Decorator")
public class DotUmlClassDiagramStyleDecorator implements DotUmlClassDiagramStyle {
  DotUmlClassDiagramStyleDecorator(DotUmlClassDiagramStyle style) {
    this.style = style; 
  }
  
  @Override
  public Map<String, String> getDiagramStyle() {
    return style.getDiagramStyle();
  }

  @Override
  public Map<String, String> getInterfaceStyle() {
    return style.getInterfaceStyle();
  }

  @Override
  public Map<String, String> getAbstractClassStyle() {
    return style.getAbstractClassStyle();
  }

  @Override
  public Map<String, String> getConcreteClassStyle() {
    return style.getConcreteClassStyle();
  }

  @Override
  public Map<String, String> getImplementsStyle() {
    return style.getImplementsStyle();
  }

  @Override
  public Map<String, String> getExtendsStyle() {
    return style.getExtendsStyle();
  }

  @Override
  public Map<String, String> getContainsStyle() {
    return style.getContainsStyle();
  }

  @Override
  public Map<String, String> getUsesStyle() {
    return style.getUsesStyle();
  }

  @Override
  public Map<String, String> getCreatesStyle() {
    return style.getCreatesStyle();
  }

  @Override
  public Map<String, String> getInterfaceFrameStyle() {
    return style.getInterfaceFrameStyle();
  }

  @Override
  public Map<String, String> getAbstractClassFrameStyle() {
    return style.getAbstractClassFrameStyle();
  }

  @Override
  public Map<String, String> getConcreteClassFrameStyle() {
    return style.getConcreteClassFrameStyle();
  }
  
  @Override
  public Map<String, String> getInterfaceNameStyle() {
    return style.getInterfaceNameStyle();
  }

  @Override
  public Map<String, String> getAbstractClassNameStyle() {
    return style.getAbstractClassNameStyle();
  }

  @Override
  public Map<String, String> getConcreteClassNameStyle() {
    return style.getConcreteClassNameStyle();
  }

  @Override
  public Map<String, String> getInterfaceFieldStyle() {
    return style.getInterfaceFieldStyle();
  }

  @Override
  public Map<String, String> getAbstractClassFieldStyle() {
    return style.getAbstractClassFieldStyle();
  }

  @Override
  public Map<String, String> getConcreteClassFieldStyle() {
    return style.getConcreteClassFieldStyle();
  }

  @Override
  public Map<String, String> getInterfaceMethodStyle() {
    return style.getInterfaceMethodStyle();
  }

  @Override
  public Map<String, String> getAbstractClassMethodStyle() {
    return style.getAbstractClassMethodStyle();
  }

  @Override
  public Map<String, String> getConcreteClassMethodStyle() {
    return style.getConcreteClassMethodStyle();
  }
 
  @Override
  public Map<String, String> getInvisibleStyle() {
    return style.getInvisibleStyle();
  }
  
  @Override
  public Map<String, String> getInvisibleNoConstraintStyle() {
    return style.getInvisibleNoConstraintStyle();
  }
  
  private DotUmlClassDiagramStyle style;

  @Override
  public Map<String, String> getCommentStyle() {
    return style.getCommentStyle();
  }

  @Override
  public Map<String, String> getCommentsStyle() {
    return style.getCommentsStyle();
  }
}
