package Device;

import java.util.ArrayList;
import DeviceProperty.DevicePropertySlider;
import DeviceProperty.DevicePropertyToggle;
import Observable.ExtendedSubject;

public class Heater extends Device {

	public Heater(String alias, ExtendedSubject extendedSubjectArrayList) {
		super(alias, extendedSubjectArrayList);
		addProperty(new DevicePropertySlider("Temperature", 0));
		addProperty(new DevicePropertyToggle("Is turned on", false));
	}
	
	public Heater(String alias, ExtendedSubject extendedSubjectArrayList,
			ArrayList<ArrayList<String>> checkAliasArrayList) {
		super(alias, extendedSubjectArrayList, checkAliasArrayList);
		addProperty(new DevicePropertySlider("Temperature", 0));
		addProperty(new DevicePropertyToggle("Is turned on", false));
	}
//testss
}
