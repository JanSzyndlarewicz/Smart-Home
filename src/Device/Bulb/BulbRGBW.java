package Device.Bulb;

import Control.Color.ColorRGBW;
import DeviceProperty.DevicePropertyColor;
import Subject.SubjectExtended;

public class BulbRGBW extends Bulb{
    public BulbRGBW(String alias){
        super(alias);
        addProperty(new DevicePropertyColor("Color", new ColorRGBW()));
    }

    public BulbRGBW(String alias, SubjectExtended lightSensor){
        super(alias, lightSensor);
        addProperty(new DevicePropertyColor("Color", new ColorRGBW()));
    }


    public BulbRGBW(String alias, int r, int g, int b, int w, SubjectExtended lightSensor) {
        super(alias, lightSensor);
        addProperty(new DevicePropertyColor("Color", new ColorRGBW(r, g, b, w)));
    }


}
