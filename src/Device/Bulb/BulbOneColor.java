package Device.Bulb;

import DeviceProperty.DevicePropertySlider;
import Subject.SubjectExtended;

public class BulbOneColor extends Bulb{

    public BulbOneColor(String alias, SubjectExtended lightSensor){
        super(alias, lightSensor);
        addProperty(new DevicePropertySlider("Brightness", 0));
    }

    public BulbOneColor(String alias, int brightness, SubjectExtended lightSensor){
        super(alias, lightSensor);
        if(0<=brightness && brightness<=100){
            addProperty(new DevicePropertySlider("Brightness", brightness));
        }
        else {
            new BulbOneColor(alias, lightSensor);
        }
    }

}
