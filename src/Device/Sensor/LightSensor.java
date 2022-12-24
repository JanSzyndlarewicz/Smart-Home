package Device.Sensor;

import DeviceProperty.DeviceProperty;
import DeviceProperty.DevicePropertySlider;
import Obeserver.Observer;
import Subject.Subject;

import java.util.ArrayList;


public class LightSensor extends Sensor /*implements Subject */{

    ArrayList<Observer> ObserverList = new ArrayList<>();

    public LightSensor(String alias){
        super(alias);
        addProperty(new DevicePropertySlider("Brightness", 0));
    }

    @Override
    public void update(DeviceProperty deviceProperty) {

    }

    @Override
    public void registerObserver(Observer observer) {
        ObserverList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        ObserverList.remove(observer);
    }

    @Override
    public void notifyObservers() {
    }

    public ArrayList<Observer> getObserverList(){
        return ObserverList;
    }
}
