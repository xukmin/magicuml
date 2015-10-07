package uml;

// FIXME: Maybe remove this class.
@Role(role = "Adapter.Adapter")
public class UmlVisitorAdapter implements GenericUmlVisitor<Void> {
  public UmlVisitorAdapter(UmlVisitor visitor) {
    this.visitor = visitor;
  }
  
  public Void visit(UmlEntity e) {
    visitor.visit(e);
    return null;
  }

  public Void visit(UmlClass c) {
    visitor.visit(c);
    return null;
  }
 
  public Void visit(UmlInterface i) {
    visitor.visit(i);
    return null;
  }
  
  public Void visit(UmlAbstractClass c) {
    visitor.visit(c);
    return null;
  }
  
  public Void visit(UmlConcreteClass c) {
    visitor.visit(c);
    return null;
  }
  
  public Void visit(UmlField f) {
    visitor.visit(f);
    return null;
  }
  
  public Void visit(UmlMethod m) {
    visitor.visit(m);
    return null;
  }
      
  @Override
  public Void visit(UmlPrimitiveType p) {
    return null;
  }
  
  private UmlVisitor visitor;
}
