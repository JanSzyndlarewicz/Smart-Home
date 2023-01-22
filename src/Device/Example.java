package Device;

import DeviceProperty.*;

public abstract class Example extends Device {
    public Example(String alias) {
        super(alias);
        addProperty(new DevicePropertyToggle("Nazwa wlasciwosci 1", false));
        addProperty(new DevicePropertySlider("Nazwa wlasciwosci 2", 0));
        addProperty(new DevicePropertySensorSlider("Nazwa wlasciwosci 3"));
    }

}
