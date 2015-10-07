package uml;

import java.util.List;

public interface UmlMethod extends UmlEntity {
  public String getName();
  
  public String getReturnType();

  public List<String> getParameterTypes();

  @Override
  public default <T> T accept(GenericUmlVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
