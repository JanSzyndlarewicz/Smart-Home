package Device.Sensor;

import DeviceProperty.DevicePropertySensorSlider;

public class TemperatureSensor extends Sensor{

    public TemperatureSensor() {
        super();
        addProperty(new DevicePropertySensorSlider("Temperature:", -100, 100));
    }
    public TemperatureSensor(String alias) {
        super(alias);
        addProperty(new DevicePropertySensorSlider("Temperature:", -100, 100));
    }
    public TemperatureSensor(String alias, String location) {
        super(alias, location);
        addProperty(new DevicePropertySensorSlider("Temperature:", -100, 100));
    }
}
