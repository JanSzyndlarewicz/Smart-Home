package Subject;

import DeviceProperty.DeviceProperty;
import Obeserver.Observer;

import java.util.ArrayList;

public interface ExtendedSubject extends Subject {

    @Override
    ArrayList<Observer> getObserverList();

    @Override
    void registerObserver(Observer observer);

    @Override
    void removeObserver(Observer observer);

    @Override
    void notifyObservers(DeviceProperty deviceProperty);




}
