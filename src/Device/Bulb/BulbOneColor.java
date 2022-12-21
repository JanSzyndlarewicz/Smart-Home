package Device.Bulb;

import DeviceProperty.DevicePropertySlider;

public class BulbOneColor extends Bulb{

    public BulbOneColor(){
        super();
        addProperty(new DevicePropertySlider("Brightness", 0));
    }
}
