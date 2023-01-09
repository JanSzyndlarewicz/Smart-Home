package Device;

import java.util.ArrayList;
import DeviceProperty.DevicePropertyToggle;
import Observable.ExtendedSubject;

public class WallSocket extends Device {

	public WallSocket(String alias, ExtendedSubject extendedSubjectArrayList) {
		super(alias, extendedSubjectArrayList);
		addProperty(new DevicePropertyToggle("Is turned on", false));
	}

	public WallSocket(String alias, ExtendedSubject extendedSubjectArrayList,
			ArrayList<ArrayList<String>> checkAliasArrayList) {
		super(alias, extendedSubjectArrayList, checkAliasArrayList);
		addProperty(new DevicePropertyToggle("Is turned on", false));
	}
//test
}
