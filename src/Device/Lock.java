package Device;

import DeviceProperty.DevicePropertyToggle;

public class Lock extends OutputDevice{
	public Lock() {
		super();
		addProperty(new DevicePropertyToggle("Is active", false));
	}
    public Lock(String alias) {
        super(alias);
        addProperty(new DevicePropertyToggle("Is active", false));
    }
    public Lock(String alias,String location) {
    	
    	super(alias, location);
    	addProperty(new DevicePropertyToggle("Is active", false));
    }
}
