package Device;
import DeviceProperty.DevicePropertySlider;

public class Shutter extends OutputDevice {
	public Shutter() {
		super();
		addProperty(new DevicePropertySlider("Length", 0));
		addProperty(new DevicePropertySlider("Angle", 0));
		addProperty(new DevicePropertySlider("Speed", 0));
		
	}
	public Shutter(String alias) {
		super(alias);

		addProperty(new DevicePropertySlider("Length", 0));
		addProperty(new DevicePropertySlider("Angle", 0));
		addProperty(new DevicePropertySlider("Speed", 0));

	}
	public Shutter(String alias,String location) {
		super(alias);

		addProperty(new DevicePropertySlider("Length", 0));
		addProperty(new DevicePropertySlider("Angle", 0));
		addProperty(new DevicePropertySlider("Speed", 0));

	}

}
