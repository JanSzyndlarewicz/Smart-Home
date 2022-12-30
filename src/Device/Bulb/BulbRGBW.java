package Device.Bulb;

import Control.Color.ColorRGBW;
import Device.Sensor.LightSensor;
import DeviceProperty.DeviceProperty;
import DeviceProperty.DevicePropertyColor;

public class BulbRGBW extends Bulb{

    public BulbRGBW(String alias, LightSensor lightSensor){
        super(alias, lightSensor);
        addProperty(new DevicePropertyColor("Color", new ColorRGBW()));
    }


    public BulbRGBW(String alias, int r, int g, int b, int w, LightSensor lightSensor) {
        super(alias, lightSensor);
        addProperty(new DevicePropertyColor("Color", new ColorRGBW(r, g, b, w)));
    }

}
