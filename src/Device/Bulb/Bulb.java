package Device.Bulb;

import Device.Device;
import DeviceProperty.DevicePropertyToggle;
import Subject.Subject;

public abstract class Bulb extends Device {

    public Bulb(String alias){
        super(alias);
        addProperty(new DevicePropertyToggle("Is turned on", false));
    }


}
