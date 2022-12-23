package Device.Sensor;

import Device.Device;
import DeviceProperty.DevicePropertySensorSlider;

public class AirHumiditySensor extends Sensor {

    public AirHumiditySensor(){

        addProperty(new DevicePropertySensorSlider("Humidity level: "));
    }
}
