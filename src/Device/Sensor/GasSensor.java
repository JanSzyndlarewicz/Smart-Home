package Device.Sensor;

import DeviceProperty.DevicePropertySensorToggle;

public class GasSensor extends Sensor {

    public GasSensor(){
        super();
        addProperty(new DevicePropertySensorToggle("Is gas detected?"));
    }
    public GasSensor(String alias){
        super(alias);
        addProperty(new DevicePropertySensorToggle("Is gas detected?"));
    }
    public GasSensor(String alias,String location){
        super(alias, location);
        addProperty(new DevicePropertySensorToggle("Is gas detected?"));
    }

}
