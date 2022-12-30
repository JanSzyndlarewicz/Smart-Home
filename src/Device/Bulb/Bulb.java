package Device.Bulb;

import Device.Device;
import Device.Sensor.LightSensor;
import DeviceProperty.DeviceProperty;
import DeviceProperty.DevicePropertyToggle;
import Subject.Subject;

public abstract class Bulb extends Device {

    public Bulb(String alias, LightSensor lightSensor){
        super(alias);
        addProperty(new DevicePropertyToggle("Is turned on", false));

        this.subject = lightSensor;
        if(alias.contains("Outside")){
            this.subject.registerObserver(this);
        }
    }

    @Override
    public void update(DeviceProperty deviceProperty) {
        super.update(deviceProperty);
    }
}
