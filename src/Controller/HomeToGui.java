package Controller;

import java.util.ArrayList;
import java.util.HashSet;

import Control.DeviceType.DeviceType_Input;
import Control.DeviceType.DeviceType_Output;
import Device.*;
import Device.Sensor.*;
import Device.Bulb.*;
import DeviceProperty.DevicePropertySensorSlider;
import DeviceProperty.Slider;
import DeviceProperty.Toggle;
import Home.Home;
import Hub.Hub;
import Hub.Routine;
import Hub.SliderToSliderRoutine;
import Hub.SliderToToggleRoutine;
import Hub.ToggleToSliderRoutine;
import Hub.ToggleToToggleRoutine;
import User.User;
import User.UserLoginBase;
import View.MainFrame;
import Observable.Subject;
import Observer.Observer;

import javax.swing.*;

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

	public static void deleteLocation(String name){
		UserLoginBase.getCurrentUser().getHome().DeleteLocation(name);
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

	public static void AddLocation(String name){
		UserLoginBase.getCurrentUser().getHome().AddLocation(name);
	}
	public static void ShowProperties(Device device,ArrayList<JCheckBox> ChBoxList,ArrayList<JSlider> SliderList,ArrayList<JLabel> LabelList){
		for (int i = 0; i < device.getProperties().length; i++) {
			if( device.getProperties()[i]==null)
				break;
			if (device.getProperties() [i]instanceof Toggle){
				EnableCheckBox(device.getProperties() [i].getValue(),device.getProperties() [i].getName(),ChBoxList);
			}
			else if (device.getProperties() [i]instanceof Slider){
				EnableSlider(((Slider) device.getProperties() [i]).getSliderInfo(),device.getProperties() [i].getName(),SliderList,LabelList);
			}

		}

	}

	public static void ShowRoutineProperties(String deviceAlias, ArrayList<JCheckBox> checkBoxesToggle, ArrayList<JCheckBox> checkBoxesSlider, ArrayList<JComboBox> comboBoxes, ArrayList<JLabel> comboBoxesLabel, ArrayList<JSlider> sliders, ArrayList<JLabel> slidersLabel){
		Device device = UserLoginBase.getCurrentUser().getHome().getDevice(deviceAlias);

		for(int i=0; i<device.getProperties().length; i++){
			if(device.getProperties()[i]==null){
				break;
			}
			if(device.getProperties()[i] instanceof Toggle){
				HomeToGui.EnableCheckBox(false, "Enable", checkBoxesToggle);
				HomeToGui.EnableComboBox("On", device.getProperties()[i].getName(), comboBoxes, comboBoxesLabel);
			} else if (device.getProperties()[i] instanceof Slider) {
				HomeToGui.EnableCheckBox(false, "Enable", checkBoxesSlider);
				HomeToGui.EnableSlider(((Slider) device.getProperties() [i]).getSliderInfo(), device.getProperties()[i].getName(), sliders, slidersLabel);
			}
		}
	}

	public static void EnableCheckBox(boolean value,String name,ArrayList<JCheckBox> ChBoxList){
		for (int i = 0; i <ChBoxList.size() ; i++) {
			if (!ChBoxList.get(i).isVisible()) {
				ChBoxList.get(i).setVisible(true);
				ChBoxList.get(i).setText(name);
				ChBoxList.get(i).setSelected(value);
				break;
			}
		}
	}

	public static void EnableSlider(int[] range,String name,ArrayList<JSlider> SliderList,ArrayList<JLabel> LabelList){
		for (int i = 0; i <SliderList.size() ; i++) {
			if (!SliderList.get(i).isVisible()) {
				SliderList.get(i).setVisible(true);
				LabelList.get(i).setVisible(true);
				LabelList.get(i).setText(name);
				SliderList.get(i).setMinimum(range[0]);
				SliderList.get(i).setMaximum(range[2]);
				SliderList.get(i).setValue(range[1]);
				break;
			}
		}
	}

	public static void EnableComboBox(String selection, String name, ArrayList<JComboBox> ComboBoxList, ArrayList<JLabel> LabelList){
		for(int i = 0; i<ComboBoxList.size(); i++){
			if(!ComboBoxList.get(i).isVisible()){
				ComboBoxList.get(i).setVisible(true);
				ComboBoxList.get(i).setSelectedItem(selection);
				LabelList.get(i).setVisible(true);
				LabelList.get(i).setText(name);
				break;
			}
		}
	}

	public static ArrayList<String> getSensorAliasList() {
		//should be changed when Controller is implemented
		ArrayList<Device> tempDevList = UserLoginBase.getCurrentUser().getHome().getDeviceList();
		ArrayList<String> devList = new ArrayList<String>();
		for(int i=0; i<tempDevList.size(); i++) {
			if(tempDevList.get(i) instanceof Sensor){
				devList.add(tempDevList.get(i).getAlias());
			}
		}
		return devList;
	}

	public static ArrayList<String> getOutputDeviceAliasList() {
		//should be changed when Controller is implemented
		ArrayList<Device> tempDevList = UserLoginBase.getCurrentUser().getHome().getDeviceList();
		ArrayList<String> devList = new ArrayList<String>();
		for(int i=0; i<tempDevList.size(); i++) {
			if(tempDevList.get(i) instanceof OutputDevice){
				devList.add(tempDevList.get(i).getAlias());
			}
		}
		return devList;
	}

	public static boolean CreateRoutine(String alias, String inputDeviceAlias, String outputDeviceAlias, String outputProperty, Object[] args){
		if(UserLoginBase.getCurrentUser().getHome().getDevice(inputDeviceAlias).getProperties()[0] instanceof Toggle && UserLoginBase.getCurrentUser().getHome().getDevice(outputDeviceAlias).getProperty(outputProperty) instanceof Toggle){
			//TT
			UserLoginBase.getCurrentUser().getHub().addRoutine(new ToggleToToggleRoutine(alias, (Subject) UserLoginBase.getCurrentUser().getHome().getDevice(inputDeviceAlias), (Observer) UserLoginBase.getCurrentUser().getHome().getDevice(outputDeviceAlias), outputProperty, (String) args[0], (String) args[1]));
			return false;
		} else if (UserLoginBase.getCurrentUser().getHome().getDevice(inputDeviceAlias).getProperties()[0] instanceof Toggle && UserLoginBase.getCurrentUser().getHome().getDevice(outputDeviceAlias).getProperty(outputProperty) instanceof Slider) {
			//TS
			UserLoginBase.getCurrentUser().getHub().addRoutine(new ToggleToSliderRoutine(alias, (Subject) UserLoginBase.getCurrentUser().getHome().getDevice(inputDeviceAlias), (Observer) UserLoginBase.getCurrentUser().getHome().getDevice(outputDeviceAlias), outputProperty, (String) args[0], (String) args[1]));
			return false;
		} else if (UserLoginBase.getCurrentUser().getHome().getDevice(inputDeviceAlias).getProperties()[0] instanceof Slider && UserLoginBase.getCurrentUser().getHome().getDevice(outputDeviceAlias).getProperty(outputProperty) instanceof Toggle) {
			//ST
			UserLoginBase.getCurrentUser().getHub().addRoutine(new SliderToToggleRoutine(alias, (Subject) UserLoginBase.getCurrentUser().getHome().getDevice(inputDeviceAlias), (Observer) UserLoginBase.getCurrentUser().getHome().getDevice(outputDeviceAlias), outputProperty, (double) args[0], (double) args[1], (boolean) args[2]));
			return false;
		} else if (UserLoginBase.getCurrentUser().getHome().getDevice(inputDeviceAlias).getProperties()[0] instanceof Slider && UserLoginBase.getCurrentUser().getHome().getDevice(outputDeviceAlias).getProperty(outputProperty) instanceof Slider) {
			//SS
			UserLoginBase.getCurrentUser().getHub().addRoutine(new SliderToSliderRoutine(alias, (Subject) UserLoginBase.getCurrentUser().getHome().getDevice(inputDeviceAlias), (Observer) UserLoginBase.getCurrentUser().getHome().getDevice(outputDeviceAlias), outputProperty, (double) args[0], (double) args[1], (String) args[2]));
			return false;
		} else {
			return true;
		}

	}

	public static boolean checkRoutineNameAvailability(String name){
		return UserLoginBase.getCurrentUser().getHub().checkRoutineAliasAvailbility(name);
	}

	public static double convertSliderPercentageToSensorSlider(String sensorAlias, int sliderVal){
		return ( (DevicePropertySensorSlider) UserLoginBase.getCurrentUser().getHome().getDevice(sensorAlias).getProperties()[0]).convertPercentToVal(sliderVal);
	}
	public static void deleteRoutine(String alias) {
		UserLoginBase.getCurrentUser().getHub().removeRoutines(alias);
		
	}
	public static HashSet<String> getRoutineList() {
		HashSet<String> routineNameList = new HashSet<String>();
		ArrayList<Routine> routineList = Hub.getRoutineList();
		for(int i=0; i<routineList.size();i++) {
			routineNameList.add(routineList.get(i).getAlias());
		}
		return routineNameList;
	}

	public static void devicePanelToBackend(JTextField NAME,
											javax.swing.JComboBox<String> LOCATION,
											ArrayList<JSlider> SliderList,
											ArrayList<JLabel> LabelList,
											ArrayList<JCheckBox> ChBoxList,
											JTable DeviceTable){
		if(DeviceTable.getSelectedRow()>=0){
			Device device = UserLoginBase.getCurrentUser().getHome().getDevice(DeviceTable.getSelectedRow());
			device.setLocation(LOCATION.getSelectedItem().toString());
			device.setAlias(NAME.getText());

			int deviceIteration = 0;
			int sliderIteration = 0;
			do {
				if (SliderList.get(sliderIteration).isVisible() && SliderList.get(sliderIteration).isEnabled()) {
					device.setProperty(LabelList.get(sliderIteration).getText(), String.valueOf((double) SliderList.get(sliderIteration).getValue() / 100));
					sliderIteration++;
				}
				deviceIteration++;
			} while (device.getProperties()[deviceIteration] != null);


			device = UserLoginBase.getCurrentUser().getHome().getDevice(DeviceTable.getSelectedRow());
			deviceIteration = 0;
			sliderIteration = 0;
			do{
				if (ChBoxList.get(sliderIteration).isVisible() && ChBoxList.get(sliderIteration).isEnabled()) {
					device.setProperty(ChBoxList.get(sliderIteration).getText(), String.valueOf(ChBoxList.get(sliderIteration).isSelected()));
					sliderIteration++;
				}
				deviceIteration++;
			}while(device.getProperties()[deviceIteration]!=null);
		}

	}



}
