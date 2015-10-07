package uml;

import java.util.Map;

@Role(role = "Decorator:Component")
public interface DotUmlClassDiagramStyle {
  Map<String, String> getDiagramStyle();

  Map<String, String> getInterfaceStyle();

  Map<String, String> getAbstractClassStyle();

  Map<String, String> getConcreteClassStyle();

  Map<String, String> getImplementsStyle();

  Map<String, String> getExtendsStyle();

  Map<String, String> getContainsStyle();

  Map<String, String> getUsesStyle();

  Map<String, String> getCreatesStyle();
 
  Map<String, String> getInterfaceFrameStyle();
  
  Map<String, String> getAbstractClassFrameStyle();
  
  Map<String, String> getConcreteClassFrameStyle();
  
  Map<String, String> getInterfaceNameStyle();
  
  Map<String, String> getAbstractClassNameStyle();
  
  Map<String, String> getConcreteClassNameStyle();

  Map<String, String> getInterfaceFieldStyle();
  
  Map<String, String> getAbstractClassFieldStyle();
  
  Map<String, String> getConcreteClassFieldStyle();
  
  Map<String, String> getInterfaceMethodStyle();
  
  Map<String, String> getAbstractClassMethodStyle();
  
  Map<String, String> getConcreteClassMethodStyle();
  
  Map<String, String> getInvisibleStyle();

  Map<String, String> getInvisibleNoConstraintStyle();

  Map<String, String> getCommentStyle();
  
  Map<String, String> getCommentsStyle();
}
