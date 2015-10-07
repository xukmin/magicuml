package patterns.observer;

public class ConcreteObserver implements Observer {
  public void update() {}
  private SubjectState observerState;
  private ConcreteSubject subject;
}
