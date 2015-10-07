package uml;

import java.lang.annotation.Annotation;

@Role(role = "Builder:Builder")
public interface UmlClassDiagramBuilder {
  UmlClassDiagramBuilder addInterface(String name);
  
  UmlClassDiagramBuilder addAbstractClass(String name);
  
  UmlClassDiagramBuilder addConcreteClass(String name);
  
  UmlClassDiagramBuilder setSuperclass(String name);

  UmlClassDiagramBuilder addSuperinterface(String name);

  UmlClassDiagramBuilder addMethod(String name);

  UmlClassDiagramBuilder setReturnType(String type);

  UmlClassDiagramBuilder addParameter(String type);

  UmlClassDiagramBuilder addField(String name, String type);

  UmlClassDiagramBuilder setModifiers(int modifiers);

  UmlClassDiagramBuilder addAnnotation(Annotation i);
}
