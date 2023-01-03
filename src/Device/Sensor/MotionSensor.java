package Device.Sensor;

import DeviceProperty.DevicePropertySensorToggle;

public class MotionSensor extends Sensor{

    public MotionSensor(String alias) {
        super(alias);
        addProperty(new DevicePropertySensorToggle("Is motion detected?"));
    }
}
