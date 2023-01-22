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

        //SerializationFunc.deserialize();
        StartFrame startFrame = new StartFrame();
    }
}