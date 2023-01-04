package Device.Sensor;

import Device.Device;
import DeviceProperty.DeviceProperty;
import DeviceProperty.DevicePropertySensorSlider;

public class AirHumiditySensor extends Sensor {

    public AirHumiditySensor(String alias){
        super(alias);
        addProperty(new DevicePropertySensorSlider("Humidity level:"));
    }

}
