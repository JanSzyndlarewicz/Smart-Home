package Device;

import DeviceProperty.*;

public class Example extends Device {
    public Example() {
        addProperty(new DevicePropertyToggle("Nazwa wlasciwosci 1", false));
        addProperty(new DevicePropertySlider("Nazwa wlasciwosci 2", 0));
        addProperty(new DevicePropertySensorSlider("Nazwa wlasciwosci 3"));
    }
    
}
