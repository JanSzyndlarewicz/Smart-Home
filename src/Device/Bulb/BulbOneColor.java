package Device.Bulb;

import DeviceProperty.DevicePropertySlider;
import Observable.ExtendedSubject;


import java.util.ArrayList;

public class BulbOneColor extends Bulb{

    public BulbOneColor(String alias) {
        super(alias);
        addProperty(new DevicePropertySlider("Brightness", 0));
    }

}
