package Hub;

import DeviceProperty.DeviceProperty;
import Observable.Subject;
import Observer.Observer;

import java.util.ArrayList;

public abstract class Routine implements Subject,Observer{

    private ArrayList<Observer> observerList = new ArrayList<>();

    public Routine(Subject input, Observer output) {

    }

    @Override
    public ArrayList<Observer> getObserverList() {
        return observerList;
    }

    @Override
    public void notifyObservers(DeviceProperty deviceProperty) {
        for (Observer observer : observerList) {
            observer.update(deviceProperty);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void update(String propertyName, String newValueForProperty) {}
}
