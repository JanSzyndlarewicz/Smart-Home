package Device.Sensor;

import Device.Device;
import DeviceProperty.DevicePropertySensorSlider;

public class AirHumiditySensor extends Device {

    public AirHumiditySensor(){

        addProperty(new DevicePropertySensorSlider("Humidity level: "));
    }
}