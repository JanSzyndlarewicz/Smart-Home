package Main;

import Control.Color.ColorHSL;
import Control.Color.ColorRGBW;
import Device.Bulb.BulbOneColor;
import Device.Bulb.BulbRGBW;
import Device.Device;
import Device.Sensor.*;
import Home.Home;
import Obeserver.Observer;
import Subject.ExtendedSubject;
import static Main.UserFunc.*;
import java.util.ArrayList;

import java.util.List;



public class Main {


    public static void main(String[] args) {


        Home home = new Home("Wroclawska 33");
        home.addDevice(new LightSensor("LightSensor_Outside_frontdoor"));
        home.addDevice(new BulbRGBW("BulbRBGW_Outside_1", new ArrayList<>(List.of(home.getDeviceList().get(0)))));
        home.addDevice(new BulbOneColor("BulbOneColor_Inside_livingroom", new ArrayList<>(List.of(home.getDeviceList().get(1)))));
        home.addDevice(new BulbRGBW("BulbRGBW_Outside_garden_1",new ArrayList<>(List.of(home.getDeviceList().get(0)))));
        home.addDevice(new BulbRGBW("BulbRGBW_Inside_kitchen", new ArrayList<>(List.of(home.getDeviceList().get(0)))));
        home.addDevice(new BulbRGBW("BulbRGBW_Outside_garden_2", new ArrayList<>(List.of(home.getDeviceList().get(0), home.getDeviceList().get(3)))));
        home.addDevice(new BulbRGBW("BulbRGBW_Inside_Kitchen_3", new ArrayList<>(List.of(home.getDeviceList().get(2))), new ArrayList<>(List.of("Inside"))));
        home.addDevice(new LightSensor("LightSensor_Outside_2"));
        home.addDevice(new GasSensor("GasSensor_Kitchen"));
        home.addDevice(new SmokeSensor("SmokeSensor_Kitchen"));
        home.addDevice(new SmokeSensor("SmokeSensor_Boiler"));
        home.addDevice(new AirHumiditySensor("AirHumiditySensor_Living_room"));
        home.addDevice(new MotionSensor("MotionSensor_Driveway"));
        home.addDevice(new TemperatureSensor("TemperatureSensor_Outdoors"));
        home.addDevice(new TemperatureSensor("TemperatureSensor_Indoor_temp"));
        System.out.println(home.getDeviceList());

//        printDevicesAlias(home);

        //printDeviceObserver(home, 0);


        home.getDeviceList().get(0).setProperty("Brightness", 0.49);
        //home.getDeviceList().get(5).registerObserver(home.getDeviceList().get(4));
        registerObserver(home.getDeviceList().get(6), home.getDeviceList().get(5));
        removeObserver(home.getDeviceList().get(6), home.getDeviceList().get(5));
        //System.out.println(home.getDeviceList().get(0));
        //System.out.println(home.getDeviceList().get(1));
        printDeviceObservers(home);



    }
}