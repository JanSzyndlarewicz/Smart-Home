package Main;

import Device.Bulb.BulbOneColor;
import Device.Bulb.BulbRGBW;
import Device.Sensor.*;
import Home.Home;
import Hub.Routine;
import Hub.ToggleToToggleRoutine;
import Observable.Subject;
import Observer.Observer;


public class Main {


    public static void main(String[] args) {


        Home home = new Home("Wroclawska 33");
        home.addDevice(new LightSensor("LightSensor_Outside_frontdoor"));
        home.addDevice(new BulbRGBW("BulbRBGW_Outside_1"));
        home.addDevice(new BulbOneColor("BulbOneColor_Inside_livingroom"));
        home.addDevice(new BulbRGBW("BulbRGBW_Outside_garden_1"));
        home.addDevice(new BulbRGBW("BulbRGBW_Inside_kitchen"));
        home.addDevice(new BulbRGBW("BulbRGBW_Outside_garden_2"));
        home.addDevice(new BulbRGBW("BulbRGBW_Inside_Kitchen_3"));
        home.addDevice(new LightSensor("LightSensor_Outside_2"));
        home.addDevice(new GasSensor("GasSensor_Kitchen"));
        home.addDevice(new SmokeSensor("SmokeSensor_Kitchen"));
        home.addDevice(new SmokeSensor("SmokeSensor_Boiler"));
        home.addDevice(new AirHumiditySensor("AirHumiditySensor_Living_room"));
        home.addDevice(new MotionSensor("MotionSensor_Driveway"));
        home.addDevice(new TemperatureSensor("TemperatureSensor_Outdoors"));
        home.addDevice(new TemperatureSensor("TemperatureSensor_Indoor_temp"));
        System.out.println(home.getDeviceList());

        Routine test1routine = new ToggleToToggleRoutine((Subject) home.getDevice("SmokeSensor_Kitchen"), (Observer) home.getDevice("BulbOneColor_Inside_livingroom"), "Is turned on", "1");

    }
}