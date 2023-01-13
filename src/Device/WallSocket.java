package Device;

import java.util.ArrayList;
import DeviceProperty.DevicePropertyToggle;

public class WallSocket extends Device {

	public WallSocket(String alias) {
		super(alias);
		addProperty(new DevicePropertyToggle("Is turned on", false));
	}
}
