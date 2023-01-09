package Observable;

import DeviceProperty.DeviceProperty;
import Observer.Observer;

import java.util.ArrayList;

public interface Subject {
    //Interface currently not used

    ArrayList<Observer> getObserverList();
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);
    void notifyObservers(DeviceProperty deviceProperty);
}
