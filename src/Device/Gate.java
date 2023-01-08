package Device;

import DeviceProperty.DevicePropertyToggle;
import Subject.ExtendedSubject;

import java.util.ArrayList;

public class Gate extends Device{


    public Gate(String alias) {
        super(alias);
        addProperty(new DevicePropertyToggle("Is closed", false));

    }


}
