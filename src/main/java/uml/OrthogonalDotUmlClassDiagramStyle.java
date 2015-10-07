package uml;

import java.util.Map;

@Role(role = "Decorator:ConcreteDecorator")
public class OrthogonalDotUmlClassDiagramStyle extends DotUmlClassDiagramStyleDecorator {
  public OrthogonalDotUmlClassDiagramStyle(DotUmlClassDiagramStyle style) {
    super(style);
  }

  @Override
  public Map<String, String> getDiagramStyle() {
    Map<String, String> attributes = super.getDiagramStyle();
    attributes.put("splines", "ortho");
    
    return attributes;
  }
}
