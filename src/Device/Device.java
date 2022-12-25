package Device;

import Device.Sensor.LightSensor;
import DeviceProperty.*;
import Control.Color.Color;
import Obeserver.Observer;
import Subject.Subject;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Device implements Subject, Observer{

    final private int MAX_NUMBER_OF_PROPERTIES = 1000;
    private DeviceProperty [] properties = new DeviceProperty[MAX_NUMBER_OF_PROPERTIES];
    private int propertiesCount = 0;
    private String alias;

    protected ArrayList<Observer> ObserverList = new ArrayList<>();
    protected Subject subject;

    @Override
    public ArrayList<Observer> getObserverList() {
        return (ArrayList<Observer>) ObserverList;
    }

    @Override
    public void update(DeviceProperty deviceProperty) {
        System.out.println("Update method");
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
    public void notifyObservers(DeviceProperty deviceProperty) {
        for (int i = 0; i < ObserverList.size(); i++) {
            ObserverList.get(i).update(deviceProperty);
        }
    }

    public Device(String alias){
        this.alias = alias;
    }
    protected void addProperty(DeviceProperty prop) {
        if(propertiesCount == MAX_NUMBER_OF_PROPERTIES) {
            System.err.printf("Error! Property %s (%s) could not be created because parent object reached limit of contained properties. Aborting", prop.getName(), prop.getType());
            return;
        }
        properties[propertiesCount] = prop;
        propertiesCount++;

    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setProperty(String name, boolean value) {
        for(int i=0; i<propertiesCount; i++) {
            if(Objects.equals(properties[i].getName(), name)) {
                if(!Objects.equals(properties[i].getType(), "Toggle")) {
                    System.err.println("Error! Types mismatch. Cannot assign boolean value to DeviceProperty"+properties[i].getType()+"! Aborting");
                    return;
                }
                ((DevicePropertyToggle)properties[i]).set(value);
                return;
            }
        }
        System.err.println("Error! Specified property does not exist. Aborting");
    }

    public void setProperty(String name, double value) {
        for(int i=0; i<propertiesCount; i++) {
            if(Objects.equals(properties[i].getName(), name)) {
                if(!Objects.equals(properties[i].getType(), "Slider")) {
                    System.err.println("Error! Types mismatch. Cannot assign double value to DeviceProperty"+properties[i].getType()+"! Aborting");
                    return;
                }
                ((DevicePropertySlider)properties[i]).set(value);
                return;
            }
        }
        System.err.println("Error! Specified property does not exist. Aborting");
    }


    public void setProperty(String name, Color value) {
        for(int i=0; i<propertiesCount; i++) {
            if(Objects.equals(properties[i].getName(), name)) {
                if(!Objects.equals(properties[i].getType(), "Color")) {
                    System.err.println("Error! Types mismatch. Cannot assign color to DeviceProperty"+properties[i].getType()+"! Aborting");
                    return;
                }
                ((DevicePropertyColor)properties[i]).set(value);
                return;
            }
        }
        System.err.println("Error! Specified property does not exist. Aborting");
    }

    public int getMAX_NUMBER_OF_PROPERTIES() {
        return MAX_NUMBER_OF_PROPERTIES;
    }

    public DeviceProperty[] getProperties() {
        return properties;
    }

    public void setProperties(DeviceProperty[] properties) {
        this.properties = properties;
    }

    public int getPropertiesCount() {
        return propertiesCount;
    }

    public void setPropertiesCount(int propertiesCount) {
        this.propertiesCount = propertiesCount;
    }

    public String toString() {
        String res = "Device\n\tAlias: "+getAlias()+"\n\tProperties:";
        for(int i=0; i<propertiesCount; i++)
            res+="\n\t\t"+properties[i].toString();
        return res;
    }



}
