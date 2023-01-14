package DeviceProperty;

import Control.Color.Color;

public class DevicePropertySensorSlider extends DeviceProperty {
    private double value;


    public DevicePropertySensorSlider(String name) {
        super(name, "SensorSlider");
        value = 0;
    }

    public double get() {
        return this.value;
    }

    public Double getValue(){
        return this.value;
    }

    public String getValueString() {
        return String.valueOf(value);
        //String.format("%.2f", value);
    }


    //=======// Debug methods //=======//

    public void debugSetSensor(double d) {
        this.value = d;
    }
}
