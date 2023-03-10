package Device.Sensor;
import DeviceProperty.DevicePropertySensorSlider;

public class AirHumiditySensor extends Sensor {

    public AirHumiditySensor(){
        super();
        addProperty(new DevicePropertySensorSlider("Humidity level:", 0, 100));
    }
    public AirHumiditySensor(String alias){
        super(alias);
        addProperty(new DevicePropertySensorSlider("Humidity level:", 0, 100));
    }
    public AirHumiditySensor(String alias,String location){
        super(alias,location);
        addProperty(new DevicePropertySensorSlider("Humidity level:", 0 , 100));
    }

}
