package Device.Bulb;

import Control.ColorRGBW;
import DeviceProperty.DevicePropertyColor;

public class BulbRGBW extends Bulb{

    public BulbRGBW(){
        super();
        addProperty(new DevicePropertyColor("Color", new ColorRGBW()));
    }


    public BulbRGBW(int r, int g, int b, int w) {
        super();
        addProperty(new DevicePropertyColor("Color", new ColorRGBW(r, g, b, w)));
    }


}
