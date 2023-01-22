package Device.Sensor;

import Device.Device;
import DeviceProperty.DevicePropertySensorSlider;
import DeviceProperty.DevicePropertySensorToggle;
import Observable.Subject;
import Observer.Observer;

import java.util.ArrayList;
import java.util.Objects;

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

    public void setProperty(String name, String value) {
        for (int i = 0; i < propertiesCount; i++) {
            if (Objects.equals(properties[i].getName(), name)) {
                switch (properties[i].getType()) {
                    case "Slider" -> ((DevicePropertySensorSlider) properties[i]).debugSetSensor(Double.parseDouble(value));
                    case "Toggle" -> ((DevicePropertySensorToggle) properties[i]).debugSetSensor(value.charAt(0) == '1' | value.equals("true") | value.equals("True"));
                    default -> {
                    }
                }
                return;
            }
        }
        System.err.println("Error! Specified property does not exist. Aborting");
    }
}
