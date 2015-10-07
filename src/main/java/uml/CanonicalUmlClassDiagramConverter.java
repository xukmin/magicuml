package uml;

import java.util.List;

// TODO: implement
public class CanonicalUmlClassDiagramConverter implements UmlClassDiagramConverter {

  public CanonicalUmlClassDiagramConverter(UmlClassDiagramBuilder builder) {
    this.builder = builder;
  }

  @Override
  public void convertAll(List<UmlClass> classes) {
    // TODO Auto-generated method stub
    
  }
  
  public void convert(UmlEntity e) {
  }

  public void convert(UmlClass c) {
  }

  public void convert(UmlInterface i) {
  }

  public void convert(UmlAbstractClass c) {
  }

  public void convert(UmlConcreteClass c) {
  }

  public void convert(UmlField f) {
  }

  public void convert(UmlMethod m) {
  }

  private UmlClassDiagramBuilder builder;
}
