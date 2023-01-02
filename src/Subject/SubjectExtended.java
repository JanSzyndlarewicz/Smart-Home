package Subject;

import DeviceProperty.DeviceProperty;
import Obeserver.Observer;

import java.util.ArrayList;

public class SubjectExtended implements Subject{

    private final Subject subject;
    private ArrayList<Observer> observerList = new ArrayList<>();
    private final String checkAlias;


    public SubjectExtended(){
        subject = null;
        observerList = null;
        checkAlias = "";

    }

    public SubjectExtended(Subject subject, String checkAlias){
        this.subject = subject;
        this.checkAlias = checkAlias;
    }



    @Override
    public ArrayList<Observer> getObserverList() {
        return observerList;
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(DeviceProperty deviceProperty) {
        for (int i = 0; i < observerList.size(); i++) {
            observerList.get(i).update(deviceProperty);
        }
    }

    @Override
    public String toString() {
        return "SubjectExtended{" +
                "subject=" + subject +
                ", observerList=" + observerList +
                ", checkAlias='" + checkAlias + '\'' +
                '}';
    }


}
