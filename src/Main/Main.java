package Main;

import Control.Color.ColorHSL;
import Control.Color.ColorRGBW;
import Device.Bulb.BulbOneColor;
import Device.Bulb.BulbRGBW;
import Device.Device;
import Device.Sensor.LightSensor;
import Home.Home;
import Subject.ExtendedSubject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void printDeviceObserver(Home home, int whichObserver){
        if(home.getDeviceList().size()>whichObserver && 0<=whichObserver){
            System.out.println(home.getDeviceList().get(whichObserver).getAlias());
            System.out.println(home.getDeviceList().get(whichObserver).getObserverList() + "\n\n");
        }

    }

    public static void printDeviceObservers(Home home){
        System.out.println("All Observers");
        for(int i=0; i<home.getDeviceList().size(); i++){
            printDeviceObserver(home, i);
        }
    }

    public static void main(String[] args) {


        Home home = new Home("Wroclawska 33");
        home.addDevice(new LightSensor("Outside_frontdoor"));
        home.addDevice(new BulbRGBW("Outside_1", new ArrayList<>(List.of(home.getDeviceList().get(0)))));
        home.addDevice(new BulbOneColor("Inside_livingroom", new ArrayList<>(List.of(home.getDeviceList().get(1)))));
        home.addDevice(new BulbRGBW("Outside_garden1",new ArrayList<>(List.of(home.getDeviceList().get(0)))));
        home.addDevice(new BulbRGBW("Inside_kitchen", new ArrayList<>(List.of(home.getDeviceList().get(0)))));
        home.addDevice(new BulbRGBW("Outside_garden2", new ArrayList<>(List.of(home.getDeviceList().get(0), home.getDeviceList().get(3)))));
        home.addDevice(new BulbRGBW("Inside_Kitchen3", new ArrayList<>(List.of(home.getDeviceList().get(2))), new ArrayList<>(List.of("Inside"))));
        home.addDevice(new LightSensor("Outside_2"));
        System.out.println(home.getDeviceList());


        //printDeviceObserver(home, 0);
        printDeviceObservers(home);
    }
}