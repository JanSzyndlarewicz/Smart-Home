package Device;

import java.util.ArrayList;
import DeviceProperty.DevicePropertyToggle;
import Subject.ExtendedSubject;

public class WallSocket extends Device {

	public WallSocket(String alias, ArrayList<ExtendedSubject> extendedSubjectArrayList) {
		super(alias, extendedSubjectArrayList);
		addProperty(new DevicePropertyToggle("Is turned on", false));
	}

	public WallSocket(String alias, ArrayList<ExtendedSubject> extendedSubjectArrayList,
			ArrayList<ArrayList<String>> checkAliasArrayList) {
		super(alias, extendedSubjectArrayList, checkAliasArrayList);
		addProperty(new DevicePropertyToggle("Is turned on", false));
	}
//test
}
