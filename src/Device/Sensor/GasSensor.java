package Device.Sensor;

import Device.Device;
import DeviceProperty.DevicePropertySensorToggle;

public class GasSensor extends Sensor {

    public GasSensor(){

        addProperty(new DevicePropertySensorToggle("Is gas detected?"));
    }
}
