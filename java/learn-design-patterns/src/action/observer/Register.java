package action.observer;

public interface Register {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

}
