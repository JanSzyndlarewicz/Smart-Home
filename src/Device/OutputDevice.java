package Device;

import DeviceProperty.*;
import Observer.Observer;

import java.util.Objects;

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

    public void setProperty(String name, String value) {
        for (int i = 0; i < propertiesCount; i++) {
            if (Objects.equals(properties[i].getName(), name)) {
                switch (properties[i].getType()) {
                    case "Slider" -> ((DevicePropertySlider) properties[i]).set(Double.parseDouble(value));
                    case "Toggle" -> ((DevicePropertyToggle) properties[i]).set(value.charAt(0) == '1' | value.equals("true") | value.equals("True"));
                    default -> {
                    }
                }
                return;
            }
        }
        System.err.println("Error! Specified property does not exist. Aborting");
    }

    @Override
    public void update(String propertyName, String newValueForProperty) {
        setProperty(propertyName, newValueForProperty);
    }
}
