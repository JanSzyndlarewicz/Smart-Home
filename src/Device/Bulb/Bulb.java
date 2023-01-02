package Device.Bulb;

import Device.Device;
import DeviceProperty.DeviceProperty;
import DeviceProperty.DevicePropertyToggle;
import Subject.Subject;
import Subject.SubjectExtended;

public abstract class Bulb extends Device {

    public Bulb(String alias, SubjectExtended subjectExtended){
        super(alias);
        addProperty(new DevicePropertyToggle("Is turned on", false));

        int i=-1;
        do{
            i++;
        }while( subjectExtendedList.getSubjectExtendedList().get(i).getSubject() != subjectExtended.getSubject());

        if(alias.contains(subjectExtended.getCheckAlias())){
            subjectExtendedList.getSubjectExtendedList().get(i).registerObserver(this);
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
