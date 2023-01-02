package Main;

import Control.Color.ColorHSL;
import Control.Color.ColorRGBW;
import Device.Bulb.BulbOneColor;
import Device.Bulb.BulbRGBW;
import Device.Device;
import Device.Sensor.LightSensor;
import Home.Home;
import Subject.Subject;
import Subject.SubjectExtended;

public class Main {
    public static void main(String[] args) {

        Home home = new Home("Wroclawska 33");
        home.addDevice(new LightSensor("Outside_frontdoor_LightSensor"));
        home.addDevice(new BulbRGBW("Outside1_BulbRGB", new SubjectExtended(home.getDeviceList().get(0), "Outside")));
        home.addDevice(new BulbOneColor("Inside_livingroom_BulbOneColor", new SubjectExtended(home.getDeviceList().get(0), "Outside")));
        home.addDevice(new BulbRGBW("Outside_garden1_BulbRGBW", new SubjectExtended(home.getDeviceList().get(0), "Outside")));
        home.addDevice(new BulbRGBW("Inside_kitchen_BulbRGBW",  new SubjectExtended(home.getDeviceList().get(0), "Outside")));
        home.addDevice(new LightSensor("Outside_2_LightSensor"));
        System.out.println(home.getDeviceList());

        System.out.println("\nObserwatorzy");
        System.out.println(home.getDeviceList().get(0).getSubjectExtendedList().getSubjectExtendedList().toString());
    }
}