package Device.Sensor;
import DeviceProperty.DevicePropertySensorToggle;

public class SmokeSensor extends Sensor {

    public SmokeSensor(String alias){
        super(alias);
        addProperty(new DevicePropertySensorToggle("Is smoke detected?"));
    }
}
