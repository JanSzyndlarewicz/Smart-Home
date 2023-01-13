package Device;
import DeviceProperty.DevicePropertySlider;
import DeviceProperty.DevicePropertyToggle;

public class Heater extends OutputDevice {

	public Heater(String alias) {
		super(alias);
		addProperty(new DevicePropertySlider("Temperature", 0));
		addProperty(new DevicePropertyToggle("Is turned on", false));
	}
}
