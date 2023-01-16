package Device.Sensor;

import Device.Device;
import Observable.Subject;
import Observer.Observer;

import java.util.ArrayList;

public abstract class Sensor extends Device implements Subject{

    private ArrayList<Observer> observerList = new ArrayList<>();
    public Sensor(){
        super();
    }
    public Sensor(String alias){
        super(alias);
    }
    public Sensor(String alias,String location){
        super(alias,location);
    }

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


}
