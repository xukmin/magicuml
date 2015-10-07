package patterns.visitor;

public class ConcreteElementB implements Element {

  @Override
  public void Accept(Visitor v) {
    v.VisitorConcreteElementB(this);
  }
  
  public void OperationB() {
    
  }

}
