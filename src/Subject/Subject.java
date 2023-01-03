package Subject;

import DeviceProperty.DeviceProperty;
import Obeserver.Observer;

import java.util.ArrayList;

public interface Subject {

    ArrayList<Observer> getObserverList();
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(DeviceProperty deviceProperty);
}
