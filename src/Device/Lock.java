package Device;

import DeviceProperty.DevicePropertyToggle;
import Subject.ExtendedSubject;

import java.util.ArrayList;

public class Lock extends Device{
    public Lock(String alias, ArrayList<ExtendedSubject> extendedSubjectArrayList) {
        super(alias, extendedSubjectArrayList);
        addProperty(new DevicePropertyToggle("Is active", false));
    }
}
