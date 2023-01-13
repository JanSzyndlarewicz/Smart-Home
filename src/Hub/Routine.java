package Hub;

import DeviceProperty.DeviceProperty;
import Observable.Subject;
import Observer.Observer;

import java.util.ArrayList;


public abstract class Routine implements Subject,Observer{
private String outputProperty, outputValue;
    private ArrayList<Observer> observerList = new ArrayList<>();

    public Routine(Subject input, Observer output, String inputProperty, String outputProperty, String outputValue) {
        input.registerObserver(this);
        registerObserver(output);
        this.outputProperty=outputProperty;
        this.outputValue=outputValue;

    }

    @Override
    public ArrayList<Observer> getObserverList() {
        return observerList;
    }

    @Override
    public void notifyObservers(DeviceProperty deviceProperty) {
        for (Observer observer : observerList) {
            observer.update(outputProperty, outputValue);
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
