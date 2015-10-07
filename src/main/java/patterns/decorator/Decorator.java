package patterns.decorator;

@uml.Role(role = "Decorator:Component")
public interface Decorator extends Component {
  @Override
  public void operation();
  
  public Component compt = null;
}
