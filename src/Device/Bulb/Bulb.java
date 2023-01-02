package Device.Bulb;

import Device.Device;
import DeviceProperty.DeviceProperty;
import DeviceProperty.DevicePropertyToggle;
import Subject.Subject;
import Subject.SubjectExtended;

public abstract class Bulb extends Device {

    public Bulb(String alias, SubjectExtended lightSensor){
        super(alias);
        addProperty(new DevicePropertyToggle("Is turned on", false));

        this.subjectExtendedList.addSubjectExtended(lightSensor, alias);
        if(alias.contains("Outside")){
            this.subjectExtendedList.getSubjectExtendedList().get(this.subjectExtendedList.getSubjectExtendedList().size()-1).registerObserver(this);
            //System.out.println("Obiekt dodany");
            System.out.println(this.subjectExtendedList.toString());
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
