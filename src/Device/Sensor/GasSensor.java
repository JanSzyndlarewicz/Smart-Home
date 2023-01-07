package Device.Sensor;

import Device.Device;
import DeviceProperty.DeviceProperty;
import DeviceProperty.DevicePropertySensorToggle;
import Subject.Subject;

public class GasSensor extends Sensor {

    public GasSensor(String alias){
        super(alias);
        addProperty(new DevicePropertySensorToggle("Is gas detected?"));
    }

}
