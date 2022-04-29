package wzorceProjektowe.behavioral.observer2;

public interface Observable {
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyObservers();
;
}
