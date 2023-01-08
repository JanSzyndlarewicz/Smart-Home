package Device;

import DeviceProperty.DevicePropertyToggle;
import Subject.ExtendedSubject;

import java.util.ArrayList;

public class Lock extends Device{
    public Lock(String alias) {
        super(alias);
        addProperty(new DevicePropertyToggle("Is active", false));
    }
}
