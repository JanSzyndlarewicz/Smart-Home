package Device;
import DeviceProperty.DevicePropertyToggle;

public class WallSocket extends OutputDevice {

	public WallSocket(String alias) {
		super(alias);
		addProperty(new DevicePropertyToggle("Is turned on", false));
	}
}
