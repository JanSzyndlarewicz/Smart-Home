package Device.Sensor;

import DeviceProperty.DevicePropertySensorSlider;


public class LightSensor extends Sensor{

    public LightSensor(){
        super();
        addProperty(new DevicePropertySensorSlider("Brightness", 0, 100));

    }
    public LightSensor(String alias){
        super(alias);
        addProperty(new DevicePropertySensorSlider("Brightness", 0, 100));

    }
    public LightSensor(String alias,String location){
        super(alias, location);
        addProperty(new DevicePropertySensorSlider("Brightness", 0, 100));

    }

}
