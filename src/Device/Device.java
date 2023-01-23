package Device;

import DeviceProperty.*;
import Home.Home;

import java.util.Objects;
import java.io.Serializable;

public abstract class Device implements Serializable {

    final private int MAX_NUMBER_OF_PROPERTIES = 1000;
    protected DeviceProperty [] properties = new DeviceProperty[MAX_NUMBER_OF_PROPERTIES];
    protected int propertiesCount = 0;
    private String alias;
    private String location;

    public Device() {
    	this.alias="";
    	this.location ="";
    }
    public Device(String alias){
        this.alias = alias;
        this.location= "pozdrawiam <3";
    }
    public Device(String alias, String location) {
    	this.alias = alias;
    	this.location=location;
        if(!Home.getCurrentLocationList().contains(this.location)){
            Home.getCurrentLocationList().add(this.location);
        }
    }



    protected void addProperty(DeviceProperty prop) {
        if (propertiesCount == MAX_NUMBER_OF_PROPERTIES) {
            System.err.printf("Error! Property %s (%s) could not be created because parent object reached limit of contained properties. Aborting", prop.getName(), prop.getType());
            return;
        }
        properties[propertiesCount] = prop;
        propertiesCount++;

    }

    public abstract void setProperty(String name, String value);

    public DeviceProperty getProperty(String name){
        DeviceProperty querried = null;

        for(int i=0; i<properties.length; i++){
            if(properties[i]!=null){
                if(properties[i].getName().equals(name)){
                    querried = properties[i];
                }
            }
        }

        return querried;
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

    public String toString() {
        StringBuilder res = new StringBuilder("Device\n\tAlias: " + getAlias() + "\n\tProperties:");
        for (int i = 0; i < propertiesCount; i++)
            res.append("\n\t\t").append(properties[i].toString());
        return res.toString();
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        if(!Home.getCurrentLocationList().contains(this.location)){
            Home.getCurrentLocationList().add(this.location);
        }
    }

}
