package Device.Bulb;

import Control.Color.ColorRGBW;
import DeviceProperty.DevicePropertyColor;
import Subject.SubjectExtended;

import java.util.ArrayList;

public class BulbRGBW extends Bulb{
    public BulbRGBW(String alias){
        super(alias);
        addProperty(new DevicePropertyColor("Color", new ColorRGBW()));
    }

    public BulbRGBW(String alias, ArrayList<SubjectExtended> subjectExtendedArrayList){
        super(alias, subjectExtendedArrayList);
        addProperty(new DevicePropertyColor("Color", new ColorRGBW()));
    }

    public BulbRGBW(String alias, int r, int g, int b, int w, ArrayList<SubjectExtended> subjectExtendedArrayList) {
        super(alias, subjectExtendedArrayList);
        addProperty(new DevicePropertyColor("Color", new ColorRGBW(r, g, b, w)));
    }


}
