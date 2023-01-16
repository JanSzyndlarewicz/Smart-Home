package Device;
import DeviceProperty.DevicePropertyToggle;

public class WallSocket extends OutputDevice {
	
	public WallSocket() {
		super();
		addProperty(new DevicePropertyToggle("Is turned on", false));
	}
	public WallSocket(String alias) {
		super(alias);
		addProperty(new DevicePropertyToggle("Is turned on", false));
	}
	public WallSocket(String alias,String location) {
		super(alias,location);
		addProperty(new DevicePropertyToggle("Is turned on", false));
	}
}
