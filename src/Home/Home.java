package Home;

import Device.Device;

import java.util.ArrayList;

public class Home {
    private ArrayList<Device> DeviceList = new ArrayList<>();

    private String label;

    public Home(String label) {
        this.label = label;
    }

    public void addDevice(Device device){
        DeviceList.add(device);
    }

    public void removeDevice(Device device){
        if(DeviceList.contains(device)){
            DeviceList.remove(device);
        }
        else{
            System.err.println("The specified device is not registered in the system!");
        }
    }

    public void removeDevice(String alias){
        for(int i=0; i< DeviceList.size(); i++){
            if(alias.equals(DeviceList.get(i).getAlias())){
                DeviceList.remove(i);
            }
        }
    }

    public String getDeviceListString(){
        return DeviceList.toString();
    }

    public ArrayList<Device> getDeviceList(){
        return DeviceList;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Home{" +
                "DeviceList=" + DeviceList +
                ", label='" + label + '\'' +
                '}';
    }
}
