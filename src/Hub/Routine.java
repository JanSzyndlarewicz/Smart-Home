package Hub;

import Observable.Subject;
import Observer.Observer;

import java.io.Serializable;
import java.util.ArrayList;


public abstract class Routine implements Subject,Observer, Serializable {

    private String alias;
    protected String outputProperty;
    private ArrayList<Observer> observerList = new ArrayList<>();

    public Routine(String alias, Subject input, Observer output, String outputProperty) {
        this.alias=alias;
        this.outputProperty=outputProperty;
        input.registerObserver(this);
        registerObserver(output);

    }

    @Override
    public ArrayList<Observer> getObserverList() {
        return observerList;
    }

    @Override
    public void notifyObservers(String outputProperty, String outputValue) {
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

    public String getAlias() {
        return alias;
    }

    public String getOutputProperty() {
        return outputProperty;
    }
}
