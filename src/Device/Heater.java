package Device;

import java.util.ArrayList;
import DeviceProperty.DevicePropertySlider;
import DeviceProperty.DevicePropertyToggle;
import Observable.ExtendedSubject;

public class Heater extends Device {

	public Heater(String alias) {
		super(alias);
		addProperty(new DevicePropertySlider("Temperature", 0));
		addProperty(new DevicePropertyToggle("Is turned on", false));
	}
}
