package Device.Sensor;

import Device.Device;
import DeviceProperty.DevicePropertySensorToggle;

public class GasSensor extends Sensor {

    public GasSensor(String alias){
        super(alias);
        addProperty(new DevicePropertySensorToggle("Is gas detected?"));
    }

    @Override
    public void notifyObservers() {

    }
}
