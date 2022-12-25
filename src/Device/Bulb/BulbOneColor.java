package Device.Bulb;

import DeviceProperty.DeviceProperty;
import DeviceProperty.DevicePropertySlider;

public class BulbOneColor extends Bulb{

    public BulbOneColor(String alias){
        super(alias);
        addProperty(new DevicePropertySlider("Brightness", 0));
    }

    public BulbOneColor(String alias, int brightness){
        super(alias);
        if(0<=brightness && brightness<=100){
            addProperty(new DevicePropertySlider("Brightness", brightness));
        }
        else {
            new BulbOneColor(alias);
        }
    }

}
