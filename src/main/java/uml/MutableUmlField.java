package uml;

public class MutableUmlField extends MutableUmlEntity implements UmlField {
  public MutableUmlField(String name, String type) {
    super(name);
    this.type = type;
  }
  
  @Override
  public String getType() {
    return type;
  }

  private String type;
}
