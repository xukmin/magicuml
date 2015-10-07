package uml;

import java.util.Map;

@Role(role = "Decorator:ConcreteDecorator")
public class ColoredDotUmlClassDiagramStyle extends DotUmlClassDiagramStyleDecorator {
  public ColoredDotUmlClassDiagramStyle(UmlClassDiagramPalette palette, DotUmlClassDiagramStyle style) {
    super(style);
    this.palette = palette;
  }
  
  public ColoredDotUmlClassDiagramStyle(UmlClassDiagramPalette palette) {
    super(new DefaultDotUmlClassDiagramStyle());
    this.palette = palette;
  }
  
  @Override
  public Map<String, String> getInterfaceNameStyle() {
    Map<String, String> attributes = super.getInterfaceNameStyle();
    attributes.put("bgcolor", palette.getInterfaceNameColor());
    
    return attributes;
  }

  @Override
  public Map<String, String> getAbstractClassNameStyle() {
    Map<String, String> attributes = super.getAbstractClassNameStyle();
    attributes.put("bgcolor", palette.getAbstractClassNameColor());
    
    return attributes;
  }

  @Override
  public Map<String, String> getConcreteClassNameStyle() {
    Map<String, String> attributes = super.getConcreteClassNameStyle();
    attributes.put("bgcolor", palette.getConcreteClassNameColor());
    
    return attributes;
  }
  
  @Override
  public Map<String, String> getInterfaceFieldStyle() {
    Map<String, String> attributes = super.getInterfaceFieldStyle();
    attributes.put("bgcolor", palette.getInterfaceFieldColor());
    
    return attributes;
  }

  @Override
  public Map<String, String> getAbstractClassFieldStyle() {
    Map<String, String> attributes = super.getAbstractClassFieldStyle();
    attributes.put("bgcolor", palette.getAbstractClassFieldColor());
    
    return attributes;
  }

  @Override
  public Map<String, String> getConcreteClassFieldStyle() {
    Map<String, String> attributes = super.getConcreteClassFieldStyle();
    attributes.put("bgcolor", palette.getConcreteClassFieldColor());
    
    return attributes;
  }
  
  @Override
  public Map<String, String> getInterfaceMethodStyle() {
    Map<String, String> attributes = super.getInterfaceMethodStyle();
    attributes.put("bgcolor", palette.getInterfaceMethodColor());
    
    return attributes;
  }

  @Override
  public Map<String, String> getAbstractClassMethodStyle() {
    Map<String, String> attributes = super.getAbstractClassMethodStyle();
    attributes.put("bgcolor", palette.getAbstractClassMethodColor());
    
    return attributes;
  }

  @Override
  public Map<String, String> getConcreteClassMethodStyle() {
    Map<String, String> attributes = super.getConcreteClassMethodStyle();
    attributes.put("bgcolor", palette.getConcreteClassMethodColor());
    
    return attributes;
  }
  
  private UmlClassDiagramPalette palette;
}
