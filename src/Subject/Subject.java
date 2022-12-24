package Subject;

import Obeserver.Observer;

import java.util.ArrayList;

public interface Subject {

    public ArrayList<Observer> getObserverList();

    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();

    //public Observer getObserver();
}
