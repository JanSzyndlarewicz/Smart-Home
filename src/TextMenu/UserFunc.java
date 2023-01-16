package TextMenu;

import Device.Device;
import Home.Home;
import Observer.Observer;

import java.util.ArrayList;

public abstract class UserFunc {



    public static void printDevicesAlias(Home home){
        System.out.println("\nList of all devices\n");
        for(int i=0; i<home.getDeviceList().size(); i++){
            System.out.println(i+1 + " - " + home.getDeviceList().get(i).getAlias());
        }
    }



}
