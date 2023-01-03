package Device.Bulb;

import Control.Color.ColorRGBW;
import Device.Sensor.LightSensor;
import DeviceProperty.DeviceProperty;
import DeviceProperty.DevicePropertyColor;
import Subject.Subject;
import Subject.ExtendedSubject;

public class BulbRGBW extends Bulb{

    public BulbRGBW(String alias, ExtendedSubject subject){
        super(alias, subject);
        addProperty(new DevicePropertyColor("Color", new ColorRGBW()));
    }


    public BulbRGBW(String alias, int r, int g, int b, int w, ExtendedSubject subject) {
        super(alias, subject);
        addProperty(new DevicePropertyColor("Color", new ColorRGBW(r, g, b, w)));
    }

}
