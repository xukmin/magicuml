package uml;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public abstract class MutableUmlClass extends MutableUmlEntity implements UmlClass {
  public MutableUmlClass(String name) {
    super(name);
  }
  
  @Override
  public final String getSuperclass() {
    return superclass;
  }

  @Override
  public final List<String> getSuperinterfaces() {
    return superinterfaces;
  }

  @Override
  public final List<UmlField> getFields() {
    return fields;
  }

  @Override
  public final List<UmlMethod> getMethods() {
    return methods;
  }

  @Override
  public final List<UmlAnnotation> getAnnotations() {
    return annotations;
  }
  
  @Override
  public final boolean isPrimitive() {
    return false;
  }

  public void setSuperclass(String name) {
    superclass = name;
  }
  
  public void addSuperinterface(String name) {
    if (!superinterfaces.contains(name)) {
      superinterfaces.add(name);
    }
  }
  
  // TODO: Check duplicate using equals.
  public void addField(UmlField f) {
    if (!fields.contains(f)) {
      fields.add(f);
    }
  }
  
  // TODO: check duplicate using equals.
  public void addMethod(UmlMethod m) {
    if (!methods.contains(m)) {
      methods.add(m);
    }
  }

  public void addAnnotation(UmlAnnotation i) {
    this.annotations.add(i);
  }
 
  private String superclass;
  private List<String> superinterfaces = new ArrayList<String>();
  private List<UmlField> fields = new ArrayList<UmlField>();
  private List<UmlMethod> methods = new ArrayList<UmlMethod>();
  private List<UmlAnnotation> annotations = new ArrayList<UmlAnnotation>();
}
