package Device.Sensor;
import DeviceProperty.DevicePropertySensorSlider;

public class AirHumiditySensor extends Sensor {

    public AirHumiditySensor(String alias){
        super(alias);
        addProperty(new DevicePropertySensorSlider("Humidity level:"));
    }

}
