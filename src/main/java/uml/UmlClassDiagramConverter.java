package uml;

import java.util.List;

@Role(role = "Adapter.Adaptee")
public interface UmlClassDiagramConverter {
  void convertAll(List<UmlClass> classes);
  
  void convert(UmlEntity e);

  void convert(UmlClass c);
  
  void convert(UmlInterface i);

  void convert(UmlAbstractClass c);

  void convert(UmlConcreteClass c);

  void convert(UmlField f);

  void convert(UmlMethod m);
}
