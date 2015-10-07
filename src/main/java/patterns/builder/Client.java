package patterns.builder;

public class Client {
  public void handle(ConcreteBuilderA a) {}
  public void handle(ConcreteBuilderB b) {}
  private Director director;
  private Builder builder;
}
