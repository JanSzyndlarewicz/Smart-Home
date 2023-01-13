package Device.Bulb;

import Device.Device;
import DeviceProperty.DeviceProperty;
import DeviceProperty.DevicePropertyToggle;

import Observable.ExtendedSubject;


import java.util.ArrayList;

public abstract class Bulb extends Device {

    public Bulb(String alias) {
        super(alias);
        addProperty(new DevicePropertyToggle("Is turned on", false));
    }
}
