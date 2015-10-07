package patterns.visitor;

public class ConcreteElementA implements Element {

  @Override
  public void Accept(Visitor v) {
    v.VisitorConcreteElementA(this);
  }
  
  public void OperationA() {
    
  }

}
