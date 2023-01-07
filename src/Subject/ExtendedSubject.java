package Subject;

import DeviceProperty.DeviceProperty;
import Obeserver.Observer;

import java.util.ArrayList;

public interface ExtendedSubject  {

    ArrayList<Observer> getObserverList();

    void registerObserver(Observer observer);

    void registerObserver(Observer observer, ArrayList<String> checkAliasArrayList);

    void removeObserver(Observer observer);

    void removeObserver(Observer observer, ArrayList<String> checkAliasArrayList);

    void notifyObservers(DeviceProperty deviceProperty);

}
