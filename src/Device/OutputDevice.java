package Device;

import DeviceProperty.DeviceProperty;
import Observer.Observer;

public abstract class OutputDevice extends Device implements Observer{
	public OutputDevice() {
		super();
	}
    public OutputDevice(String alias) {
        super(alias);
    }
    public OutputDevice(String alias, String location) {
    	super(alias,location);
    }

    @Override
    public void update(String propertyName, String newValueForProperty) {
        setProperty(propertyName, newValueForProperty);
    }
}
