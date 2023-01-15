package Device;

import DeviceProperty.DevicePropertyToggle;

public class Gate extends OutputDevice{


    public Gate(String alias) {
        super(alias);
        addProperty(new DevicePropertyToggle("Is closed", false));

    }


}
