package Main;

import Device.Bulb.BulbOneColor;
import Device.Bulb.BulbRGBW;
import Device.Sensor.*;
import Home.Home;
import Hub.Routine;
import Hub.ToggleToToggleRoutine;
import Observable.Subject;
import Observer.Observer;
import Serialization.Serialization;
import TextMenu.UserLogin.UserLoginBase;
import TextMenu.UserLogin.UserService;
import User.UserDataBase;
import View.LoginFrame;
//import View.MainFrame;

import static TextMenu.UserFunc.*;

import java.util.ArrayList;
import java.util.List;


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
        //System.out.println(home.getDeviceList());

        Routine test1routine = new ToggleToToggleRoutine((Subject) home.getDevice("SmokeSensor_Kitchen"), (Observer) home.getDevice("BulbOneColor_Inside_livingroom"), "Is turned on", "1");


        //UserLoginBase userLoginBase = new UserLoginBase();
        UserLoginBase.register("User", "pass", "543827453", "user.pass@gmail.com");
        UserDataBase.findUser("User").setHome(home);
        UserLoginBase.login("User", "pass");
        System.out.println("Current User in main:" + UserLoginBase.getCurrentUser());
        System.out.println("Current User in main:" + Test.currentUser());



        new LoginFrame().setVisible(true);
        ///////////////////////////////////////////////////


        //Logowanie
       // UserLoginBase userLoginBase = new UserLoginBase();
//        UserService userService = new UserService();
//        UserService.userRegistration();
//        if(UserLoginBase.login("Maciek", "Kok")){
//            System.out.println(UserDataBase.findUser("Maciek"));
//        }
//
//
//
//        System.out.println(UserLoginBase.login("XD", "xd"));
//        System.out.println(UserLoginBase.login("Daniel", "haslo"));
//        System.out.println(UserLoginBase.login("Daniiel", "hasło"));
//        System.out.println(UserLoginBase.register("Daniel", "hassło"));
//        System.out.println(UserLoginBase.remove("Marek", "dadsa"));
//        System.out.println(UserLoginBase.login("Marek", "dadsa"));

        //Serializacja
        Serialization.serialize(new UserDataBase());
        Serialization.deserialize();
        System.out.println(Serialization.getDeserializedHome());
    }
    public static List getListToGui() { // potem to usune, na chwile obecna nie wiem gdzie to powinno byc
		ArrayList<String> locations = new ArrayList<String>();
		locations.add("Kitchen");
		locations.add("Garden");
		locations.add("Room1");
		locations.add("Add Location");
		return locations;
	}
}