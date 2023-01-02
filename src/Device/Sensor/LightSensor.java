package Device.Sensor;

import Device.Bulb.Bulb;
import DeviceProperty.DeviceProperty;
import DeviceProperty.DevicePropertySlider;
import Obeserver.Observer;
import Subject.Subject;

import java.util.ArrayList;


public class LightSensor extends Sensor{

    public LightSensor(String alias){
        super(alias);
        addProperty(new DevicePropertySlider("Brightness", 0));

    }

}
