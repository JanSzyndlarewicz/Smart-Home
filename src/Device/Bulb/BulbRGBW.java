package Device.Bulb;

import Control.Color.ColorRGBW;
import DeviceProperty.DevicePropertyColor;
import Observable.ExtendedSubject;
import java.util.ArrayList;

public class BulbRGBW extends Bulb{

    public BulbRGBW(String alias, ExtendedSubject extendedSubjectArrayList){
        super(alias, extendedSubjectArrayList);
        addProperty(new DevicePropertyColor("Color", new ColorRGBW()));
    }


    public BulbRGBW(String alias, int r, int g, int b, int w, ExtendedSubject extendedSubjectArrayList) {
        super(alias, extendedSubjectArrayList);
        addProperty(new DevicePropertyColor("Color", new ColorRGBW(r, g, b, w)));
    }

    public BulbRGBW(String alias, ExtendedSubject extendedSubjectArrayList, ArrayList<String> checkAliasArrayList){
        super(alias, extendedSubjectArrayList, checkAliasArrayList);

        addProperty(new DevicePropertyColor("Color", new ColorRGBW()));
    }

    public BulbRGBW(String alias, int r, int g, int b, int w, ExtendedSubject extendedSubjectArrayList, ArrayList<String> checkAliasArrayList) {
        super(alias, extendedSubjectArrayList, checkAliasArrayList);

        addProperty(new DevicePropertyColor("Color", new ColorRGBW(r, g, b, w)));
    }


}
