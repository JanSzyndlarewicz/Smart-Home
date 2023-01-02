package Device.Bulb;

import Device.Device;
import DeviceProperty.DeviceProperty;
import DeviceProperty.DevicePropertyToggle;
import Subject.Subject;
import Subject.SubjectExtended;

import java.util.ArrayList;

public abstract class Bulb extends Device {

    public Bulb(String alias, ArrayList<SubjectExtended> subjectExtendedArrayList){
        super(alias);
        addProperty(new DevicePropertyToggle("Is turned on", false));

        for (SubjectExtended subjectExtended : subjectExtendedArrayList) {
            int j = 0;

            while (subjectExtendedList.getSubjectExtendedList().get(j).getSubject() != subjectExtended.getSubject()){
                j++;
            }

            if (alias.contains(subjectExtended.getCheckAlias())) {
                subjectExtendedList.getSubjectExtendedList().get(j).registerObserver(this);
            }
        }
    }

    public Bulb(String alias){
        super(alias);
        addProperty(new DevicePropertyToggle("Is turned on", false));
    }

    @Override
    public void update(DeviceProperty deviceProperty) {
        super.update(deviceProperty);
    }
}
