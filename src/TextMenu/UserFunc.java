package TextMenu;

import Device.Device;
import Home.Home;
import Observer.Observer;

import java.util.ArrayList;

public abstract class UserFunc {
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

    public static void printDevicesAlias(Home home){
        System.out.println("\nList of all devices\n");
        for(int i=0; i<home.getDeviceList().size(); i++){
            System.out.println(i+1 + " - " + home.getDeviceList().get(i).getAlias());
        }
    }

    public static void registerObserver(Device device, Observer observer){
        device.registerObserver(observer);
    }

    public static void registerObserver(Device device, Observer observer, ArrayList<String> checkAlias){
        device.registerObserver(observer, checkAlias);
    }

    public static void removeObserver(Device device, Observer observer){
        device.removeObserver(observer);
    }

    public static void removeObserver(Device device, Observer observer, ArrayList<String> checkAlias){
        device.removeObserver(observer, checkAlias);
    }

}
