package patterns.observer;

public class ConcreteSubject implements Subject {
  public SubjectState getState() {
    return subjectState;
  }
  
  public void setState(SubjectState state) {
    subjectState = state;
  }

  public void attach(Observer observer) {
  }

  public void detach(Observer observer) {
  }

  public void notifyObservers() {
  }

  private SubjectState subjectState;
}
