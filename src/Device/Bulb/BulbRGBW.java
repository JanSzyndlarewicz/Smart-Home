package Device.Bulb;

import Control.Color.ColorRGBW;
import DeviceProperty.DevicePropertyColor;
import Subject.Subject;
import Subject.ExtendedSubject;

import java.util.ArrayList;


import java.util.ArrayList;

    public BulbRGBW(String alias, ArrayList<ExtendedSubject> extendedSubjectArrayList){
        super(alias, extendedSubjectArrayList);
        addProperty(new DevicePropertyColor("Color", new ColorRGBW()));
    }


    public BulbRGBW(String alias, int r, int g, int b, int w, ArrayList<ExtendedSubject> extendedSubjectArrayList) {
        super(alias, extendedSubjectArrayList);
        addProperty(new DevicePropertyColor("Color", new ColorRGBW(r, g, b, w)));
    }

    public BulbRGBW(String alias, ArrayList<ExtendedSubject> extendedSubjectArrayList, ArrayList<String> checkAliasArrayList){
        super(alias, extendedSubjectArrayList, checkAliasArrayList);

        addProperty(new DevicePropertyColor("Color", new ColorRGBW()));
    }

    public BulbRGBW(String alias, ArrayList<SubjectExtended> subjectExtendedArrayList){
        super(alias, subjectExtendedArrayList);
        addProperty(new DevicePropertyColor("Color", new ColorRGBW()));
    }

    public BulbRGBW(String alias, int r, int g, int b, int w, ArrayList<ExtendedSubject> extendedSubjectArrayList, ArrayList<String> checkAliasArrayList) {
        super(alias, extendedSubjectArrayList, checkAliasArrayList);

        addProperty(new DevicePropertyColor("Color", new ColorRGBW(r, g, b, w)));
    }


}
