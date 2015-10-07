package uml;

@Role(role = "Adapter.Adaptee")
@Role(role = "Adapter.Target")
public interface UmlVisitor {
  void visit(UmlEntity e);

  void visit(UmlClass c);

  void visit(UmlInterface i);

  void visit(UmlAbstractClass c);

  void visit(UmlConcreteClass c);

  void visit(UmlField f);

  void visit(UmlMethod m);
}
