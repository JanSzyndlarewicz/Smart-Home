package Device;

import DeviceProperty.DevicePropertyToggle;

public class Gate extends OutputDevice{

	public Gate() {
		super();
		addProperty(new DevicePropertyToggle("Is closed", false));
	}
    public Gate(String alias) {
        super(alias);
        addProperty(new DevicePropertyToggle("Is closed", false));

    }
    public Gate(String alias, String location) {
    	super(alias,location);
    	addProperty(new DevicePropertyToggle("Is closed", false));
    }


}
