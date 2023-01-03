package Device.Bulb;

import Device.Device;
import DeviceProperty.DeviceProperty;
import DeviceProperty.DevicePropertyToggle;
import Subject.Subject;

import Subject.ExtendedSubject;


import java.util.ArrayList;

public abstract class Bulb extends Device {


    public Bulb(String alias, ArrayList<ExtendedSubject> extendedSubjectArrayList) {
        super(alias, extendedSubjectArrayList);
        addProperty(new DevicePropertyToggle("Is turned on", false));

        this.extendedSubjectArrayList = extendedSubjectArrayList;
        for(int i=0; i<extendedSubjectArrayList.size(); i++){
            if(this.extendedSubjectArrayList.get(i).getObserverList()!=null){
                if (!this.extendedSubjectArrayList.get(i).getObserverList().contains(this)) {
                        this.extendedSubjectArrayList.get(i).registerObserver(this);
                }
            }
        }
    }

    public Bulb(String alias, ArrayList<ExtendedSubject> extendedSubjectArrayList, ArrayList<String> checkAliasArrayList) {
        super(alias, extendedSubjectArrayList);
        addProperty(new DevicePropertyToggle("Is turned on", false));

        this.extendedSubjectArrayList = extendedSubjectArrayList;
        for(int i=0; i<extendedSubjectArrayList.size(); i++){
            if(this.extendedSubjectArrayList.get(i).getObserverList()!=null){
                if (!this.extendedSubjectArrayList.get(i).getObserverList().contains(this)) {
                    if (alias.contains(checkAliasArrayList.get(i))) {
                        this.extendedSubjectArrayList.get(i).registerObserver(this);
                    }
                }

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
