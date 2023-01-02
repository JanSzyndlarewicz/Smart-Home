package Device.Bulb;

import DeviceProperty.DevicePropertySlider;
import Subject.SubjectExtended;

import java.util.ArrayList;

public class BulbOneColor extends Bulb{

    public BulbOneColor(String alias, ArrayList<SubjectExtended> subjectExtendedArrayList){
        super(alias, subjectExtendedArrayList);
        addProperty(new DevicePropertySlider("Brightness", 0));
    }

    public BulbOneColor(String alias, int brightness, ArrayList<SubjectExtended> subjectExtendedArrayList){
        super(alias, subjectExtendedArrayList);
        if(0<=brightness && brightness<=100){
            addProperty(new DevicePropertySlider("Brightness", brightness));
        }
        else {
            new BulbOneColor(alias, subjectExtendedArrayList);
        }
    }

}
