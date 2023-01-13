package Device.Bulb;

import Control.Color.ColorRGBW;
import DeviceProperty.DevicePropertyColor;
import Observable.ExtendedSubject;
import java.util.ArrayList;

public class BulbRGBW extends Bulb{

    public BulbRGBW(String alias) {
        super(alias);
        addProperty(new DevicePropertyColor("Color", new ColorRGBW()));
    }

}
