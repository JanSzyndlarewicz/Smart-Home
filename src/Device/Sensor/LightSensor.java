package Device.Sensor;

import DeviceProperty.DevicePropertySlider;

public class LightSensor extends Sensor{

    public LightSensor(){
        addProperty(new DevicePropertySlider("Brightness", 0));
    }

}
