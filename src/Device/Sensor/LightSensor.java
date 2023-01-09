package Device.Sensor;

import DeviceProperty.DevicePropertySlider;


public class LightSensor extends Sensor{

    public LightSensor(String alias){
        super(alias);
        addProperty(new DevicePropertySlider("Brightness", 0));

    }

}
