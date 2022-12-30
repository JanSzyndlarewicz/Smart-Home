package Device.Bulb;

import Device.Sensor.LightSensor;
import DeviceProperty.DeviceProperty;
import DeviceProperty.DevicePropertySlider;

public class BulbOneColor extends Bulb{

    public BulbOneColor(String alias, LightSensor lightSensor){
        super(alias, lightSensor);
        addProperty(new DevicePropertySlider("Brightness", 0));
    }

    public BulbOneColor(String alias, int brightness, LightSensor lightSensor){
        super(alias, lightSensor);
        if(0<=brightness && brightness<=100){
            addProperty(new DevicePropertySlider("Brightness", brightness));
        }
        else {
            new BulbOneColor(alias, lightSensor);
        }
    }

}
