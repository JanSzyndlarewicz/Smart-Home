package Device.Bulb;

import Device.Device;
import DeviceProperty.DevicePropertyToggle;
import Subject.Subject;
import Subject.ExtendedSubject;

public abstract class Bulb extends Device {

    public Bulb(String alias, ExtendedSubject subject) {
        super(alias, subject);
        addProperty(new DevicePropertyToggle("Is turned on", false));

        this.extendedSubject = subject;
        if (this.extendedSubject.getObserverList() != null) {
            if (!this.extendedSubject.getObserverList().contains(this)) {
                if (alias.contains("Outside")) {
                    this.extendedSubject.registerObserver(this);
                }
            }
        }


    }


}
