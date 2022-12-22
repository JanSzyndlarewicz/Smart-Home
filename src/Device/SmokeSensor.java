package Device;

import DeviceProperty.DevicePropertySensorToggle;

public class SmokeSensor extends Device {

    public SmokeSensor(){

        addProperty(new DevicePropertySensorToggle("Is smoke detected?"));
    }

}
