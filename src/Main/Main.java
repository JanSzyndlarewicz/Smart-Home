package Main;

import Control.Color.ColorHSL;
import Control.Color.ColorRGBW;
import Device.Bulb.BulbOneColor;
import Device.Bulb.BulbRGBW;
import Device.Device;
import Device.Sensor.LightSensor;
import Home.Home;

public class Main {
    public static void main(String[] args) {

       /* Device x;
        x = new BulbRGBW("BulbRGW", 10, 10, 20, 30);
        System.out.println(x);
        x.setProperty("Color", new ColorHSL(40, 30, 20));
        System.out.println(x);
        x.setProperty("Color", new ColorRGBW(5,6,3,56));
        System.out.println(x);
        x.setProperty("Is turned", true);
        System.out.println(x);
        x.setProperty("Is turned on", true);
        System.out.println(x);
        x.setProperty("Color", new ColorRGBW(5,6,3,56));
        System.out.println(x);*/
        Home home = new Home("Wroclawska 33");
        home.addDevice(new BulbRGBW("Outside_1"));
        home.addDevice(new BulbOneColor("Inside_livingroom"));
        home.addDevice(new LightSensor("Outside_frontdoor"));
        home.addDevice(new BulbRGBW("Outside_garden1"));
        home.addDevice(new BulbRGBW("Inside_kitchen"));
        home.addDevice(new BulbRGBW("Outside_garden2"));
        home.addDevice(new LightSensor("Outside_2"));
        System.out.println(home.getDeviceList());
        //System.out.println(home.getDeviceList().get(6));
        home.getDeviceList().get(6).registerObserver(home.getDeviceList().get(0));
        home.getDeviceList().get(6).registerObserver(home.getDeviceList().get(2));
        home.getDeviceList().get(6).registerObserver(home.getDeviceList().get(3));
        home.getDeviceList().get(6).registerObserver(home.getDeviceList().get(5));

        System.out.println("\nObserwatorzy");
        System.out.println(home.getDeviceList().get(6).getObserverList());

    }
}