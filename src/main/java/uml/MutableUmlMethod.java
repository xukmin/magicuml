package uml;

import java.util.ArrayList;
import java.util.List;

public class MutableUmlMethod extends MutableUmlEntity implements UmlMethod {
  public MutableUmlMethod(String name) {
    super(name);
  }
  
  @Override
  public String getReturnType() {
    return returnType;
  }

  @Override
  public List<String> getParameterTypes() {
    return parameterTypes;
  }

  public void setReturnType(String name) {
    returnType = name;
  }
  
  public void addParameter(String type) {
    parameterTypes.add(type);
  }
  
  private String returnType = "void";
  private List<String> parameterTypes = new ArrayList<String>();
}
