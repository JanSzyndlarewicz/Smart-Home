package Device.Sensor;

import DeviceProperty.DevicePropertySlider;


public class LightSensor extends Sensor{

    public LightSensor(){
        super();
        addProperty(new DevicePropertySlider("Brightness", 0));

    }
    public LightSensor(String alias){
        super(alias);
        addProperty(new DevicePropertySlider("Brightness", 0));

    }
    public LightSensor(String alias,String location){
        super(alias, location);
        addProperty(new DevicePropertySlider("Brightness", 0));

    }

}
