package Device.Sensor;

import DeviceProperty.DevicePropertySensorToggle;

public class MotionSensor extends Sensor{

    public MotionSensor() {
        super();
        addProperty(new DevicePropertySensorToggle("Motion detected"));
    }
    public MotionSensor(String alias) {
        super(alias);
        addProperty(new DevicePropertySensorToggle("Motion detected"));
    }
    public MotionSensor(String alias, String location) {
        super(alias,location);
        addProperty(new DevicePropertySensorToggle("Motion detected"));
    }
}
