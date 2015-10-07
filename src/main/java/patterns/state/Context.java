package patterns.state;

public class Context {
  public void request() {
    state.handle();
  }

  public void setState(State state) {
    this.state = state;
  }
  
  private State state;
}
