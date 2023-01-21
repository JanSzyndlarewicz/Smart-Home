package Controller;

import java.util.ArrayList;

import Control.DeviceType.DeviceType_Input;
import Control.DeviceType.DeviceType_Output;
import Device.Device;
import Device.Gate;
import Device.Heater;
import Device.Lock;
import Device.Shutter;
import Device.WallSocket;
import Device.Bulb.BulbOneColor;
import Device.Bulb.BulbRGBW;
import Device.Sensor.AirHumiditySensor;
import Device.Sensor.GasSensor;
import Device.Sensor.LightSensor;
import Device.Sensor.MotionSensor;
import Device.Sensor.SmokeSensor;
import Device.Sensor.TemperatureSensor;
import Home.Home;
import User.UserLoginBase;
import View.MainFrame;

public class HomeToGui {
	public static void addDeviceFromGui(String devType, DeviceType_Input devTypeIn, DeviceType_Output devTypeOut, String alias, String location) {
		Device device = new Lock("lock1");
		switch(devType) {
		case "Input":
			switch(devTypeIn) {
			case Air_Humidity_Sensor:
				device = new AirHumiditySensor(alias, location);
				break;
			case Gas_Sensor:
				device = new GasSensor(alias, location);
				break;
			case Light_Sensor:
				device  = new LightSensor(alias, location);
				break;
			case Motion_Sensor:
				device = new MotionSensor(alias, location);
				break;
			case Smoke_Sensor:
				device = new SmokeSensor(alias, location);
				break;
			case Temperature_Sensor:
				device = new TemperatureSensor(alias, location);
				break;
			default:
				device = new Lock("Lock1");
					
			}
			break;
		case "Output":
			switch(devTypeOut) {
			case GATE:
				device = new Gate(alias, location);
				break;
			case HEATER:
				device = new Heater(alias, location);
				break;
			case LOCK:
				device = new Lock(alias, location);
				break;
			case SHUTTER:
				device = new Shutter(alias, location);
				break;
			case WALLSOCKET:
				device = new WallSocket(alias, location);
				break;
			case BULB_RGB:
				device = new BulbRGBW(alias, location);
				break;
			case BULB_ONECOLOR:
				device = new BulbOneColor(alias, location);
				break; 
			default:
				device = new Lock("Lock1");
				
			}
			break;
			default:
				device = new Lock("Lock1");
		}
		UserLoginBase.getCurrentUser().getHome().addDevice(device);
		MainFrame.RefreshTableData(UserLoginBase.getCurrentUser().getHome().getDeviceList());
		
	}
	public static ArrayList<String> sendLocationListToGui(){
		ArrayList<String> locations = new ArrayList<String>();
		locations.removeAll(locations);
		if(Home.getCurrentLocationList()!=null)
			for(int i = 0; i<Home.getCurrentLocationList().size();i++)
				locations.add(Home.getCurrentLocationList().get(i));
		
		locations.add("Add location");
		return locations;
	}
	public static void addLocationFromGui(String locationName) {
		if(UserLoginBase.getCurrentUser().getHome().getCurrentLocationList()!=null)
				UserLoginBase.getCurrentUser().getHome().getCurrentLocationList().add(locationName);
		else {
			UserLoginBase.getCurrentUser().getHome().setLocationList(new ArrayList<String>());
			UserLoginBase.getCurrentUser().getHome().getCurrentLocationList().add(locationName);
		}
	}

	public static ArrayList<String> uniqueLocationsFromHome(){
		ArrayList<String> uniqueLocations = new ArrayList<>();
		for(int i=0; i<UserLoginBase.getCurrentUser().getHome().getDeviceList().size(); i++){
			if(!uniqueLocations.contains(UserLoginBase.getCurrentUser().getHome().getDeviceList().get(i).getLocation())){
				uniqueLocations.add(UserLoginBase.getCurrentUser().getHome().getDeviceList().get(i).getLocation());
			}
		}
		return uniqueLocations;
	}
}
