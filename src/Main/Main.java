package Main;

import Device.Bulb.BulbOneColor;
import Device.Bulb.BulbRGBW;
import Device.Sensor.*;
import Home.Home;
import Serialization.SerializationFunc;

import Serialization.SerializationFunc;
import TextMenu.UserFunc;
import User.UserLoginBase;
import User.UserDataBase;
import View.LoginFrame;
import View.StartFrame;

import java.util.ArrayList;
import java.util.List;


public class Main {


    public static void main(String[] args) {


       Initialization.initialization();




//      SerializationFunc.deserialize();
        StartFrame startFrame = new StartFrame();



        //DWIE GOTOWE FUNKCJE KTÓRE ZAŁATWIAJĄ SERIALIZACJĘ, NALEŻY JE TYLKO ZAIMPLEMENTOWAĆ W ODPOWIEDNICH MIEJSCACH W GUI
        //SerializationFunc.serialize();
        //SerializationFunc.deserialize();
    }
    public static List<String> getListToGui() { // potem to usune, na chwile obecna nie wiem gdzie to powinno byc
		ArrayList<String> locations = new ArrayList<>();
		locations.add("Kitchen");
		locations.add("Garden");
		locations.add("Room1");
		locations.add("Add Location");
		return locations;
	}
}