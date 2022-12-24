package Device.Sensor;

import Device.Device;
import DeviceProperty.DevicePropertySensorToggle;

public class SmokeSensor extends Sensor {

    public SmokeSensor(String alias){
        super(alias);
        addProperty(new DevicePropertySensorToggle("Is smoke detected?"));
    }

    @Override
    public void notifyObservers() {

    }
}
