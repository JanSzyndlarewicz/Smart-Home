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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Home home = new Home("Wroclawska 33");
        home.addDevice(new LightSensor("Outside_frontdoor_LightSensor"));
        home.addDevice(new BulbRGBW("Outside1_BulbRGB", new ArrayList<>(List.of(new SubjectExtended(home.getDeviceList().get(0), "Outside")))));
        home.addDevice(new BulbOneColor("Inside_livingroom_BulbOneColor", new ArrayList<>(List.of(new SubjectExtended(home.getDeviceList().get(0), "Outside")))));
        home.addDevice(new BulbRGBW("Inside_kitchen_BulbRGBW",  new ArrayList<>(List.of(new SubjectExtended(home.getDeviceList().get(0), "Outside")))));
        home.addDevice(new LightSensor("Outside_2_LightSensor"));
        home.addDevice(new BulbRGBW("Outside_garden1_BulbRGBW", new ArrayList<>(List.of(new SubjectExtended(home.getDeviceList().get(0), "Outside"), new SubjectExtended(home.getDeviceList().get(4), "Outside")))));
        System.out.println(home.getDeviceList());

        System.out.println("\nObserwatorzy");
        System.out.println(home.getDeviceList().get(0).getSubjectExtendedList().getSubjectExtendedList().toString());
    }
}