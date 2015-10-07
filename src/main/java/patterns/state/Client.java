package patterns.state;

public class Client {
	public void handleContext(Context context){
		State state1 = new ConcreteStateA();
		State state2 = new ConcreteStateB();
		
		context.setState(state1);
		context.request();
		
		context.setState(state2);
		context.request();
	}

	// TODO: Remove the hack.
	private ConcreteStateA __invisible__noconstraint__concreteStateA;
  private ConcreteStateB __invisible__noconstraint__concreteStateB;
}
