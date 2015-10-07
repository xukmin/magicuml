package uml;

@Role(role = "Visitor.Visitor")
@Role(role = "Adapter.Target")
public interface GenericUmlVisitor<T> {
  T visit(UmlEntity e);
  T visit(UmlClass c);
  T visit(UmlInterface i);
  T visit(UmlAbstractClass c);
  T visit(UmlConcreteClass c);
  T visit(UmlField f);
  T visit(UmlMethod m);
  T visit(UmlPrimitiveType p);
}
