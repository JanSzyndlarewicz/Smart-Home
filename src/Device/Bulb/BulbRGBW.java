package Device.Bulb;

import DeviceProperty.DevicePropertySlider;

public class BulbRGBW extends Bulb{

    public BulbRGBW(String alias) {
        super(alias);
        addProperty(new DevicePropertySlider("Hue", 0));
        addProperty(new DevicePropertySlider("Saturation", 0));
    }

}
