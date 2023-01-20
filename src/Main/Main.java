package Main;

import Device.Bulb.BulbOneColor;
import Device.Bulb.BulbRGBW;
import Device.Sensor.*;
import Home.Home;
import Serialization.Serialization;
import User.User;
import User.UserLoginBase;
import User.UserDataBase;
import View.FirstFrame;
import View.LoginFrame;
import Serialization.SerializeUserDataBase;
import Serialization.SerializeUserLoginBase;
import Serialization.SerializationFunc;
import View.RegisterFrame;
//import View.MainFrame;

import java.util.ArrayList;
import java.util.HashMap;
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

        //Routine test1routine = new ToggleToToggleRoutine((Subject) home.getDevice("SmokeSensor_Kitchen"), (Observer) home.getDevice("BulbOneColor_Inside_livingroom"), "Is turned on", "1");

        UserLoginBase.register("User", "pass", "543827453", "user.pass@gmail.com", "Wrocławska");
        UserDataBase.getUserDataBase().get("User").setHome(home);





//        new LoginFrame().setVisible(true);
//        new RegisterFrame().setVisible(true);
        new FirstFrame().setVisible(true);



        //DWIE GOTOWE FUNKCJE KTÓRE ZAŁATWIAJĄ SERIALIZACJĘ, NALEŻY JE TYLKO ZAIMPLEMENTOWAĆ W ODPOWIEDNICH MIEJSCACH W GUI
        //SerializationFunc.serialize();
        //SerializationFunc.deserialize();
    }
    public static List<String> getListToGui() { // potem to usune, na chwile obecna nie wiem gdzie to powinno byc
		ArrayList<String> locations = new ArrayList<String>();
		locations.add("Kitchen");
		locations.add("Garden");
		locations.add("Room1");
		locations.add("Add Location");
		return locations;
	}
}