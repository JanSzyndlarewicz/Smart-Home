package Subject;

import DeviceProperty.DeviceProperty;
import Obeserver.Observer;

import java.util.ArrayList;

public interface ExtendedSubject extends Subject {
  /*  String checkAlias = null;
    Subject subject = null;
*/
   /* public ExtendedSubject(Subject subject){
        this.subject = subject;
        checkAlias = null;
    }

    public ExtendedSubject(Subject subject, String checkAlias){
        this.subject = subject;
        this.checkAlias = checkAlias;
    }*/
    @Override
    public ArrayList<Observer> getObserverList();

    @Override
    public void registerObserver(Observer observer);

    @Override
    public void removeObserver(Observer observer);

    @Override
    public void notifyObservers(DeviceProperty deviceProperty);




}
