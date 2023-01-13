package Observable;

import Observer.Observer;

import java.util.ArrayList;

public interface Subject {

    ArrayList<Observer> getObserverList();
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);
    void notifyObservers(String outputProperty, String outputValue);
}
