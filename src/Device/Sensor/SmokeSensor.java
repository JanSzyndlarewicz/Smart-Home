package Device.Sensor;
import DeviceProperty.DevicePropertySensorToggle;

public class SmokeSensor extends Sensor {

    public SmokeSensor(){
        super();
        addProperty(new DevicePropertySensorToggle("Is smoke detected?"));
    }
    public SmokeSensor(String alias){
        super(alias);
        addProperty(new DevicePropertySensorToggle("Is smoke detected?"));
    }
    public SmokeSensor(String alias, String location){
        super(alias, location);
        addProperty(new DevicePropertySensorToggle("Is smoke detected?"));
    }
}
