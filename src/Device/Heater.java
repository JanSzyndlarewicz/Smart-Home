package Device;
import DeviceProperty.DevicePropertySlider;
import DeviceProperty.DevicePropertyToggle;

public class Heater extends OutputDevice {
	public Heater() {
		super();
		addProperty(new DevicePropertySlider("Temperature", 0, -100, 100));
		addProperty(new DevicePropertyToggle("Is turned on", false));
	}
	public Heater(String alias) {
		super(alias);
		addProperty(new DevicePropertySlider("Temperature", 0, -100, 100));
		addProperty(new DevicePropertyToggle("Is turned on", false));
	}
	public Heater(String alias, String location) {
		super(alias, location);
		addProperty(new DevicePropertySlider("Temperature", 0, -100, 100));
		addProperty(new DevicePropertyToggle("Is turned on", false));
	}
	
	
}
