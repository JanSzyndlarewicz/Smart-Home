package Device.Bulb;

import Device.Device;
import DeviceProperty.DeviceProperty;
import DeviceProperty.DevicePropertyToggle;
import Subject.Subject;

import Subject.ExtendedSubject;
import DeviceProperty.DevicePropertySensorSlider;


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


    @Override
    public void update(DeviceProperty deviceProperty) {
        super.update(deviceProperty);

        if(deviceProperty.getName().equals("Brightness")){
            double x = Double.parseDouble(deviceProperty.getValueString());
            if(x<0.50){
                setProperty("Is turned on", true);
            }
        }


    }
}
