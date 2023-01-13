package Home;

import Device.Device;

import java.util.ArrayList;

public class Home {
    private ArrayList<Device> deviceList = new ArrayList<>();

    private String label;

    public Home(String label) {
        this.label = label;
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

    public Device getDevice(String alias) {
        for(int i=0; i<deviceList.size(); i++) {
            if(deviceList.get(i).getAlias() == alias) return deviceList.get(i);
        }
        System.out.println("To urządzenie nie istnieje");
        return null;
    }

    @Override
    public String toString() {
        return "Home{" +
                "DeviceList=" + deviceList +
                ", label='" + label + '\'' +
                '}';
    }
}
