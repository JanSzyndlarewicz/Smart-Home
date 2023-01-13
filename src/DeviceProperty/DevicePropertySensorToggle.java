package DeviceProperty;

public class DevicePropertySensorToggle extends DeviceProperty {
    private boolean value;


    public DevicePropertySensorToggle(String name) {
        super(name, "SensorToggle");
        value = false;
    }

    public Boolean getValue(){
        return this.value;
    }

    public boolean get() {
        return this.value;
    }

    public String getValueString() {
        return (value ? "True" : "False");
    }


    //=======// Debug methods //=======//

    public void debugSetSensor(boolean d) {
        this.value = d;
    }
}
