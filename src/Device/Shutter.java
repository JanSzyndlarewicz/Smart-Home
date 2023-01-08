package Device;

import java.util.ArrayList;
import DeviceProperty.DevicePropertySlider;
import Subject.ExtendedSubject;

public class Shutter extends Device {

	public Shutter(String alias, ArrayList<ExtendedSubject> extendedSubjectArrayList) {
		super(alias, extendedSubjectArrayList);

		addProperty(new DevicePropertySlider("Length", 0));
		addProperty(new DevicePropertySlider("Angle", 0));
		addProperty(new DevicePropertySlider("Speed", 0));

	}
	
	public Shutter(String alias, ArrayList<ExtendedSubject> extendedSubjectArrayList,
			ArrayList<ArrayList<String>> checkAliasArrayList) {
		super(alias, extendedSubjectArrayList, checkAliasArrayList);

		addProperty(new DevicePropertySlider("Length", 0));
		addProperty(new DevicePropertySlider("Angle", 0));
		addProperty(new DevicePropertySlider("Speed", 0));

	}

}
