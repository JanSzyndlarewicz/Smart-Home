package Device.Bulb;

import DeviceProperty.DeviceProperty;
import DeviceProperty.DevicePropertySlider;
import Subject.Subject;
import Subject.ExtendedSubject;

public class BulbOneColor extends Bulb{

    public BulbOneColor(String alias, ExtendedSubject subject){
        super(alias, subject);
        addProperty(new DevicePropertySlider("Brightness", 0));
    }

    public BulbOneColor(String alias, int brightness, ExtendedSubject subject){
        super(alias, subject);
        if(0<=brightness && brightness<=100){
            addProperty(new DevicePropertySlider("Brightness", brightness));
        }
        else {
            new BulbOneColor(alias, subject);
        }
    }

}
