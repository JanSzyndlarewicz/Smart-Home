package Device;

import java.util.ArrayList;
import DeviceProperty.DevicePropertySlider;
import DeviceProperty.DevicePropertyToggle;
import Subject.ExtendedSubject;

public class Heater extends Device {

	public Heater(String alias, ArrayList<ExtendedSubject> extendedSubjectArrayList) {
		super(alias, extendedSubjectArrayList);
		addProperty(new DevicePropertySlider("Temperature", 0));
		addProperty(new DevicePropertyToggle("Is turned on", false));
	}
	
	public Heater(String alias, ArrayList<ExtendedSubject> extendedSubjectArrayList,
			ArrayList<ArrayList<String>> checkAliasArrayList) {
		super(alias, extendedSubjectArrayList, checkAliasArrayList);
		addProperty(new DevicePropertySlider("Temperature", 0));
		addProperty(new DevicePropertyToggle("Is turned on", false));
	}

}
