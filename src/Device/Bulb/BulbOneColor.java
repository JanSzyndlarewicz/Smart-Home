package Device.Bulb;

import DeviceProperty.DevicePropertySlider;

public class BulbOneColor extends Bulb{

    public BulbOneColor(){
        super();
        addProperty(new DevicePropertySlider("Brightness", 0));
    }

    public BulbOneColor(int b){
        super();
        if(0<=b && b<=100){
            addProperty(new DevicePropertySlider("Brightness", b));
        }
        else {
            new BulbOneColor();
        }
    }
}
