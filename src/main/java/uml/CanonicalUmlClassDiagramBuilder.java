package uml;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

@Role(role = "Builder:ConcreteBuilder")
public class CanonicalUmlClassDiagramBuilder implements UmlClassDiagramBuilder {
  public CanonicalUmlClassDiagramBuilder() {
    // TODO Auto-generated constructor stub
  }

  public List<UmlClass> getClasses() {
    return classes;
  }
 
  @Override
  public CanonicalUmlClassDiagramBuilder addInterface(String name) {
    // TODO: Check if the class already exists in classes.
    currentEntity = currentClass = new MutableUmlInterface(name);
    classes.add(currentClass);
    return this;
  }
  
  @Override
  public CanonicalUmlClassDiagramBuilder addAbstractClass(String name) {
    // TODO: Check if the class already exists in classes.
    currentEntity = currentClass = new MutableUmlAbstractClass(name);
    classes.add(currentClass);
    return this;
  }

  @Override
  public CanonicalUmlClassDiagramBuilder addConcreteClass(String name) {
    currentEntity = currentClass = new MutableUmlConcreteClass(name);
    classes.add(currentClass);
    return this;
  }

  @Override
  public CanonicalUmlClassDiagramBuilder setSuperclass(String name) {
    if (currentEntity == null || currentClass == null) {
      throw new IllegalStateException("setSuperclass() should only be called for a class.");
    }
    currentEntity = currentClass;
    currentClass.setSuperclass(name);
    return this;
  }

  @Override
  public CanonicalUmlClassDiagramBuilder addSuperinterface(String name) {
    if (currentEntity == null || currentClass == null) {
      throw new IllegalStateException("addInterface() should only be called for a class.");
    }
    currentEntity = currentClass;
    currentClass.addSuperinterface(name);
    return this;
  }

  @Override
  public CanonicalUmlClassDiagramBuilder addMethod(String name) {
    if (currentEntity == null || currentClass == null) {
      throw new IllegalStateException("addMethod() should only be called for a class.");
    }
    currentEntity = currentMethod = new MutableUmlMethod(name);
    currentMethod.setDeclaringClass(currentClass.getName());
    currentClass.addMethod(currentMethod);
    return this;
  }

  @Override
  public CanonicalUmlClassDiagramBuilder setReturnType(String type) {
    if (currentEntity == null || currentClass == null ||
        currentMethod == null || currentEntity != currentMethod) {
      throw new IllegalStateException("setReturnType() should only be called for a method.");
    }
    currentMethod.setReturnType(type);
    return this;
  }

  @Override
  public CanonicalUmlClassDiagramBuilder addParameter(String type) {
    if (currentEntity == null || currentClass == null ||
        currentMethod == null || currentEntity != currentMethod) {
      throw new IllegalStateException("addParameter() should only be called for a method.");
    }
    currentMethod.addParameter(type);
    return this;
  }

  @Override
  public CanonicalUmlClassDiagramBuilder addField(String name, String type) {
    if (currentEntity == null || currentClass == null) {
      throw new IllegalStateException("addMethod() should only be called for a class.");
    }
    currentEntity = currentField = new MutableUmlField(name, type);
    currentField.setDeclaringClass(currentClass.getName());
    currentClass.addField(currentField);
    return this;
  }

  @Override
  public UmlClassDiagramBuilder setModifiers(int modifiers) {
    currentEntity.setModifiers(modifiers);
    return this;
  }

  @Override
  public UmlClassDiagramBuilder addAnnotation(Annotation i) {
    if (currentEntity == null || currentClass == null) {
      // TODO: Allow annotations for fields and methods.
      throw new IllegalStateException("addAnnotation() should only be called for a class.");
    }
    MutableUmlAnnotation annotation = new MutableUmlAnnotation(i);
    annotation.setDeclaringClass(currentClass.getName());
    currentClass.addAnnotation(annotation);
    return this;
  }
  
  private List<UmlClass> classes = new ArrayList<UmlClass>();
  
  private MutableUmlEntity currentEntity = null;
  private MutableUmlClass currentClass = null;
  private MutableUmlMethod currentMethod = null;
  private MutableUmlField currentField = null;
}
