package Device;

import DeviceProperty.*;
import java.util.Objects;
import java.io.Serializable;

public abstract class Device implements Serializable {

    final private int MAX_NUMBER_OF_PROPERTIES = 1000;
    private DeviceProperty [] properties = new DeviceProperty[MAX_NUMBER_OF_PROPERTIES];
    private int propertiesCount = 0;
    private String alias;
    private String location;

    public Device() {
    	this.alias="";
    	this.location ="";
    }
    public Device(String alias){
        this.alias = alias;
    }
    public Device(String alias, String location) {
    	this.alias = alias;
    	this.location=location;
    }



    protected void addProperty(DeviceProperty prop) {
        if (propertiesCount == MAX_NUMBER_OF_PROPERTIES) {
            System.err.printf("Error! Property %s (%s) could not be created because parent object reached limit of contained properties. Aborting", prop.getName(), prop.getType());
            return;
        }
        properties[propertiesCount] = prop;
        propertiesCount++;

    }

    public void setProperty(String name, boolean value) {
        for (int i = 0; i < propertiesCount; i++) {
            if (Objects.equals(properties[i].getName(), name)) {
                if (!Objects.equals(properties[i].getType(), "Toggle")) {
                    System.err.println("Error! Types mismatch. Cannot assign boolean value to DeviceProperty"
                            + properties[i].getType() + "! Aborting");
                    return;
                }
                ((DevicePropertyToggle) properties[i]).set(value);
                return;
            }
        }
        System.err.println("Error! Specified property does not exist. Aborting");
    }

    public void setProperty(String name, double value) {
        for (int i = 0; i < propertiesCount; i++) {
            if (Objects.equals(properties[i].getName(), name)) {
                if (!Objects.equals(properties[i].getType(), "Slider")) {
                    System.err.println("Error! Types mismatch. Cannot assign double value to DeviceProperty"
                            + properties[i].getType() + "! Aborting");
                    return;
                }
                ((DevicePropertySlider) properties[i]).set(value);
                return;
            }
        }
        System.err.println("Error! Specified property does not exist. Aborting");
    }

    public void setProperty(String name, String value) {
        for (int i = 0; i < propertiesCount; i++) {
            if (Objects.equals(properties[i].getName(), name)) {
                switch (properties[i].getType()) {
                    case "Slider" -> ((DevicePropertySlider) properties[i]).set(Double.parseDouble(value));
                    case "Toggle" -> ((DevicePropertyToggle) properties[i]).set(value.charAt(0) == '1' | value.equals("true") | value.equals("True"));
                    default -> {
                    }
                }
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
    }

}
