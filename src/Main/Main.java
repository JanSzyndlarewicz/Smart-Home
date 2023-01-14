package Main;

import Device.Bulb.BulbOneColor;
import Device.Bulb.BulbRGBW;
import Device.Sensor.*;
import Home.Home;
import Serialization.Serialization;
import TextMenu.UserLogin.UserLoginBase;
import TextMenu.UserLogin.UserService;
import User.UserDataBase;

import static TextMenu.UserFunc.*;


public class Main {


    public static void main(String[] args) {


        Home home = new Home("Wroclawska 33");
        home.addDevice(new LightSensor("LightSensor_Outside_frontdoor"));
        home.addDevice(new BulbRGBW("BulbRBGW_Outside_1", (home.getDeviceList().get(0))));
        home.addDevice(new BulbOneColor("BulbOneColor_Inside_livingroom", (home.getDeviceList().get(1))));
        home.addDevice(new BulbRGBW("BulbRGBW_Outside_garden_1",home.getDeviceList().get(0)));
        home.addDevice(new BulbRGBW("BulbRGBW_Inside_kitchen", (home.getDeviceList().get(0))));
        home.addDevice(new BulbRGBW("BulbRGBW_Outside_garden_2", (home.getDeviceList().get(0))));
        home.addDevice(new BulbRGBW("BulbRGBW_Inside_Kitchen_3", home.getDeviceList().get(2)));
        home.addDevice(new LightSensor("LightSensor_Outside_2"));
        home.addDevice(new GasSensor("GasSensor_Kitchen"));
        home.addDevice(new SmokeSensor("SmokeSensor_Kitchen"));
        home.addDevice(new SmokeSensor("SmokeSensor_Boiler"));
        home.addDevice(new AirHumiditySensor("AirHumiditySensor_Living_room"));
        home.addDevice(new MotionSensor("MotionSensor_Driveway"));
        home.addDevice(new TemperatureSensor("TemperatureSensor_Outdoors"));
        home.addDevice(new TemperatureSensor("TemperatureSensor_Indoor_temp"));
        //System.out.println(home.getDeviceList());


        printDevicesAlias(home);

        //printDeviceObserver(home, 0);


        home.getDeviceList().get(0).setProperty("Brightness", 0.49);
        //home.getDeviceList().get(5).registerObserver(home.getDeviceList().get(4));
        registerObserver(home.getDeviceList().get(6), home.getDeviceList().get(5));
        removeObserver(home.getDeviceList().get(6), home.getDeviceList().get(5));
        //System.out.println(home.getDeviceList().get(0));
        //System.out.println(home.getDeviceList().get(1));
        printDeviceObservers(home);




        ///////////////////////////////////////////////////


        //Logowanie
       // UserLoginBase userLoginBase = new UserLoginBase();
        UserService userService = new UserService();
        UserService.userRegistration();
        if(UserLoginBase.login("Maciek", "Kok")){
            System.out.println(UserDataBase.findUser("Maciek"));
        }


        UserLoginBase.register("Daniel", "haslo");
        UserLoginBase.register("Marek", "dadsa");
        System.out.println(UserLoginBase.login("XD", "xd"));
        System.out.println(UserLoginBase.login("Daniel", "haslo"));
        System.out.println(UserLoginBase.login("Daniiel", "hasło"));
        System.out.println(UserLoginBase.register("Daniel", "hassło"));
        System.out.println(UserLoginBase.remove("Marek", "dadsa"));
        System.out.println(UserLoginBase.login("Marek", "dadsa"));

        //Serializacja
        Serialization.serialize(new UserDataBase());
        Serialization.deserialize();
        System.out.println(Serialization.getDeserializedHome());
    }
}