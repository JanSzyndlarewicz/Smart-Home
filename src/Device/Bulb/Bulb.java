package Device.Bulb;

import Device.Device;
import DeviceProperty.DevicePropertyToggle;

public abstract class Bulb extends Device {

    public Bulb(){
        addProperty(new DevicePropertyToggle("Is turned on", false));
    }
}
