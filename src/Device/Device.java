package Device;

import DeviceProperty.*;
import Control.Color.Color;
import Obeserver.Observer;
import Subject.Subject;
import Subject.ExtendedSubject;


import java.util.ArrayList;
import java.util.Objects;

public abstract class Device implements ExtendedSubject, Observer{

    final private int MAX_NUMBER_OF_PROPERTIES = 1000;
    private DeviceProperty [] properties = new DeviceProperty[MAX_NUMBER_OF_PROPERTIES];
    private int propertiesCount = 0;
    private String alias;
    protected ArrayList<Observer> observerList = new ArrayList<>();
    //protected ArrayList<String> checkAliasArrayList = new ArrayList<>();
    protected ArrayList<ExtendedSubject> extendedSubjectArrayList = new ArrayList<>();

    protected ArrayList<ArrayList<String>> checkAliasArrayList;


    public Device(String alias){
        this.alias = alias;
        checkAliasArrayList = null;
    }

    public Device(String alias, ArrayList<ExtendedSubject> extendedSubjectArrayList){
        this.alias = alias;
        this.extendedSubjectArrayList = extendedSubjectArrayList;
        checkAliasArrayList = null;
        for(int i=0; i<extendedSubjectArrayList.size(); i++){
            this.extendedSubjectArrayList.get(i).registerObserver(this);
        }
    }

    public Device(String alias, ArrayList<ExtendedSubject> extendedSubjectArrayList, ArrayList<ArrayList<String>> checkAliasArrayList){
        this.alias = alias;
        this.extendedSubjectArrayList = extendedSubjectArrayList;
        this.checkAliasArrayList = checkAliasArrayList;
        for(int i=0; i<extendedSubjectArrayList.size(); i++){
            for(int j=0; j<checkAliasArrayList.get(i).size(); j++){
                if(checkAliasArrayList.get(i)!=null){
                    if(alias.contains(checkAliasArrayList.get(i).get(j))){
                        this.extendedSubjectArrayList.get(i).registerObserver(this);
                    }
                }
            }

        }
    }

    @Override
    public void update(DeviceProperty deviceProperty) {
        System.out.println("Update method");
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




    protected void addProperty(DeviceProperty prop) {
        if(propertiesCount == MAX_NUMBER_OF_PROPERTIES) {
            System.err.printf("Error! Property %s (%s) could not be created because parent object reached limit of contained properties. Aborting", prop.getName(), prop.getType());
            return;
        }
        properties[propertiesCount] = prop;
        propertiesCount++;

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



    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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

    public void setObserverList(ArrayList<Observer> observerList) {
        this.observerList = observerList;
    }

    public ArrayList<ArrayList<String>> getCheckAliasArrayList() {
        return checkAliasArrayList;
    }

    public void setCheckAliasArrayList(ArrayList<ArrayList<String>> checkAliasArrayList) {
        this.checkAliasArrayList = checkAliasArrayList;
    }

    public ArrayList<ExtendedSubject> getExtendedSubjectArrayList() {
        return extendedSubjectArrayList;
    }

    public void setExtendedSubjectArrayList(ArrayList<ExtendedSubject> extendedSubjectArrayList) {
        this.extendedSubjectArrayList = extendedSubjectArrayList;

    }

    public String toString() {
        StringBuilder res = new StringBuilder("Device\n\tAlias: " + getAlias() + "\n\tProperties:");
        for(int i=0; i<propertiesCount; i++)
            res.append("\n\t\t").append(properties[i].toString());
        return res.toString();
    }
}
