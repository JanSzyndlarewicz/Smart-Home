package Hub;

import DeviceProperty.DeviceProperty;
import Observable.Subject;
import Observer.Observer;

import java.util.ArrayList;

public abstract class Routine implements Subject,Observer{

    protected ArrayList<Observer> observerList = new ArrayList<>();


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
    public void update(DeviceProperty deviceProperty) {}
}
