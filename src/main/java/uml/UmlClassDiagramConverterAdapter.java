package uml;

@Role(role = "Adapter.ConcreteAdaptee")
@Role(role = "Adapter.Adapter")
public class UmlClassDiagramConverterAdapter implements UmlVisitor {

  public UmlClassDiagramConverterAdapter(UmlClassDiagramConverter converter) {
    this.converter = converter;
  }

  @Override
  public void visit(UmlEntity e) {
    converter.convert(e); 
  }

  @Override
  public void visit(UmlClass c) {
    converter.convert(c); 
  }

  @Override
  public void visit(UmlInterface i) {
    converter.convert(i);
  }

  @Override
  public void visit(UmlAbstractClass c) {
    converter.convert(c);
  }

  @Override
  public void visit(UmlConcreteClass c) {
    converter.convert(c);
  }

  @Override
  public void visit(UmlField f) {
    converter.convert(f);
  }

  @Override
  public void visit(UmlMethod m) {
    converter.convert(m);
  }

  private UmlClassDiagramConverter converter;
}
