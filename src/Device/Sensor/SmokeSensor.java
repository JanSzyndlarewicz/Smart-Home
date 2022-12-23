package Device.Sensor;

import Device.Device;
import DeviceProperty.DevicePropertySensorToggle;

public class SmokeSensor extends Sensor {

    public SmokeSensor(){

        addProperty(new DevicePropertySensorToggle("Is smoke detected?"));
    }

}
