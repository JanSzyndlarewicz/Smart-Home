package Device.Bulb;

import Device.OutputDevice;
import DeviceProperty.*;

public abstract class Bulb extends OutputDevice{
	public Bulb() {
        super();
        addProperty(new DevicePropertyToggle("Is turned on", false));
        addProperty(new DevicePropertySlider("Lightness", 0, 0, 100));
    }
    public Bulb(String alias) {
        super(alias);
        addProperty(new DevicePropertyToggle("Is turned on", false));
        addProperty(new DevicePropertySlider("Lightness", 0, 0, 100));
    }
    public Bulb(String alias,String location) {
        super(alias,location);
        addProperty(new DevicePropertyToggle("Is turned on", false));
        addProperty(new DevicePropertySlider("Lightness", 0, 0, 100));
    }
}
