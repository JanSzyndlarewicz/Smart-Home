package Device.Bulb;

import Control.Color.ColorRGBW;
import DeviceProperty.DevicePropertyColor;

public class BulbRGBW extends Bulb{

    public BulbRGBW(String alias){
        super(alias);
        addProperty(new DevicePropertyColor("Color", new ColorRGBW()));
    }


    public BulbRGBW(String alias, int r, int g, int b, int w) {
        super(alias);
        addProperty(new DevicePropertyColor("Color", new ColorRGBW(r, g, b, w)));
    }


    @Override
    public void notifyObservers() {

    }
}
