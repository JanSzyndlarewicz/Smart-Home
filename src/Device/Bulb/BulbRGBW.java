package Device.Bulb;

import DeviceProperty.DevicePropertySlider;

public class BulbRGBW extends Bulb{
	public BulbRGBW() {
        super();
        addProperty(new DevicePropertySlider("Hue", 0, 0, 360));
        addProperty(new DevicePropertySlider("Saturation", 0, 0, 100));
    }
    public BulbRGBW(String alias) {
        super(alias);
        addProperty(new DevicePropertySlider("Hue", 0, 0, 360));
        addProperty(new DevicePropertySlider("Saturation", 0, 0, 100));
    }
    public BulbRGBW(String alias,String location) {
        super(alias,location);
        addProperty(new DevicePropertySlider("Hue", 0, 0, 360));
        addProperty(new DevicePropertySlider("Saturation", 0, 0, 100));
    }

}
