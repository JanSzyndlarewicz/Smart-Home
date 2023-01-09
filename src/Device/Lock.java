package Device;

import DeviceProperty.DevicePropertyToggle;

public class Lock extends Device{
    public Lock(String alias) {
        super(alias);
        addProperty(new DevicePropertyToggle("Is active", false));
    }
}
