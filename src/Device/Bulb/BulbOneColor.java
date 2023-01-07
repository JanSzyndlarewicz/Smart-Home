package Device.Bulb;

import DeviceProperty.DevicePropertySlider;
import Obeserver.Observer;
import Subject.Subject;
import Subject.ExtendedSubject;


import java.util.ArrayList;

public class BulbOneColor extends Bulb{

    public BulbOneColor(String alias, ArrayList<ExtendedSubject> extendedSubjectArrayList){
        super(alias, extendedSubjectArrayList);
        addProperty(new DevicePropertySlider("Brightness", 0));
    }

    public BulbOneColor(String alias, int brightness, ArrayList<ExtendedSubject> extendedSubjectArrayList){
        super(alias, extendedSubjectArrayList);
        if(0<=brightness && brightness<=100){
            addProperty(new DevicePropertySlider("Brightness", brightness));
        }
        else {
            new BulbOneColor(alias, extendedSubjectArrayList);
        }
    }

    public BulbOneColor(String alias, ArrayList<ExtendedSubject> extendedSubjectArrayList, ArrayList<String> checkAliasArrayList){
        super(alias, extendedSubjectArrayList, checkAliasArrayList);
        addProperty(new DevicePropertySlider("Brightness", 0));
    }

    public BulbOneColor(String alias, int brightness, ArrayList<ExtendedSubject> extendedSubjectArrayList, ArrayList<String> checkAliasArrayList){
        super(alias, extendedSubjectArrayList, checkAliasArrayList);

        if(0<=brightness && brightness<=100){
            addProperty(new DevicePropertySlider("Brightness", brightness));
        }
        else {
            new BulbOneColor(alias, extendedSubjectArrayList);

        }
    }


}
