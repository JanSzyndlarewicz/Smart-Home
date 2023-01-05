package Device.Sensor;

import DeviceProperty.DevicePropertySensorSlider;

public class TemperatureSensor extends Sensor{

    public TemperatureSensor(String alias) {
        super(alias);
        addProperty(new DevicePropertySensorSlider("Temperature:"));
    }
}
