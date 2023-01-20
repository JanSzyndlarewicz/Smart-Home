package Home;

import Device.Device;
import User.UserLoginBase;

import java.io.Serializable;
import java.util.ArrayList;

public class Home implements Serializable{
    private ArrayList<Device> deviceList = new ArrayList<>();

    private String label;
    private String login;
    private ArrayList<String> locationList;

    public Home(String label) {
        this.label = label;
        
    }
    public Home(String label, ArrayList<String> locationList) {
    	this.label=label;
    	this.locationList=locationList;
    }

    public void addDevice(Device device){
        deviceList.add(device);
    }

    public void removeDevice(Device device){
        if(deviceList.contains(device)){
            deviceList.remove(device);
        }
        else{
            System.err.println("The specified device is not registered in the system!");
        }
    }

    public void removeDevice(String alias){
        for(int i=0; i< deviceList.size(); i++){
            if(alias.equals(deviceList.get(i).getAlias())){
                deviceList.remove(i);
            }
        }
    }

    public String getDeviceListString(){
        return deviceList.toString();
    }

    public ArrayList<Device> getDeviceList(){
        return deviceList;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    public ArrayList<String> getLocationList(){
    	return this.locationList;
    }
    public static ArrayList<String> getCurrentLocationList(){
    	return UserLoginBase.getCurrentUser().getHome().getLocationList();
    }
    public void setLocationList(ArrayList<String> locationList) {
    	this.locationList=locationList;
    }
//    public static void addToCurrentLocationList(String location) {
//    	UserLoginBase.getCurrentUser().getHome().getCurrentLocationList().add(location);
//    }
    
    public Device getDevice(String alias) {
        for(int i=0; i<deviceList.size(); i++) {
            if(deviceList.get(i).getAlias() == alias) return deviceList.get(i);
        }
        System.out.println("To urządzenie nie istnieje");
        return null;
    }
    public Device getDevice(int index) {

        return deviceList.get(index);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Home{" +
                "DeviceList=" + deviceList +
                ", label='" + label + '\'' +
                '}';
    }
}
