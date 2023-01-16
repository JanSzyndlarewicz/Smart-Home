package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Main.Main;
import TextMenu.UserLogin.UserLoginBase;
import Control.DeviceType.DeviceType;
import Control.DeviceType.DeviceType_Input;
import Control.DeviceType.DeviceType_Output;
import Device.Device;
import Device.Bulb.*;
import Device.Sensor.*;
import Device.*;

public class AddDeviceFrame extends JFrame {
	private JButton addButton;
	private JLabel welcomeMess;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel locationLabel;
	private JComboBox locationList;
	private JLabel deviceTypeLabel;
	private JComboBox deviceTypeList;
	private JLabel deviceTypeIOLabel;
	private JComboBox deviceTypeIOList;
	private JPanel panel;

	public AddDeviceFrame() {
		initialize();
	}
	//

	private void initialize() {
		//welcomeMess = new JLabel("Device adding panel");
		
		addButton = new JButton("Add");
		nameLabel = new JLabel("Name: ");
		nameTextField = new JTextField();
		locationLabel = new JLabel("Location: ");
		locationList = new JComboBox(getListFromModel().toArray());
		deviceTypeLabel = new JLabel("Device type: ");
		deviceTypeList = new JComboBox(DeviceType_Input.values());
		deviceTypeIOLabel = new JLabel("Input/Output");
		deviceTypeIOList = new JComboBox(new String[] {"Input","Output" });
		panel = new JPanel();
//
		panel.setLayout(null);
		
		//
		deviceTypeIOList.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					if(e.getItem()=="Input") {
						deviceTypeList.setModel(new DefaultComboBoxModel<>( DeviceType_Input.values() ));
						deviceTypeList.revalidate();
					}else {
						
						deviceTypeList.setModel(new DefaultComboBoxModel<>( DeviceType_Output.values() ));
					}
				}
				
			}
			
		});

		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch(deviceTypeIOList.getSelectedItem().toString()) {
				case"Input":
					addButtonActionPerformed(deviceTypeIOList.getSelectedItem().toString(),(DeviceType_Input) deviceTypeList.getSelectedItem(),null, nameTextField.getText(), locationList.getSelectedItem().toString());
					break;
				case"Output":
					addButtonActionPerformed(deviceTypeIOList.getSelectedItem().toString(),null,(DeviceType_Output)deviceTypeList.getSelectedItem(), nameTextField.getText(), locationList.getSelectedItem().toString());
					break;
				}
			}
			
		});
		///
		nameLabel.setBounds(25, 25, 100, 25);
		nameTextField.setBounds(25, 50, 100, 25);
		locationLabel.setBounds(150, 25, 100, 25);
		locationList.setBounds(150, 50, 100, 25);
		deviceTypeIOLabel.setBounds(25, 75, 100, 25);
		deviceTypeIOList.setBounds(25, 100, 100, 25);
		deviceTypeLabel.setBounds(150,75,100,25);
		deviceTypeList.setBounds(150,100,100,25);
		addButton.setBounds(275, 100, 100, 25);
		///
		panel.add(nameLabel);
		panel.add(nameTextField);
		panel.add(deviceTypeList);
		panel.add(deviceTypeLabel);
		panel.add(deviceTypeIOLabel);
		panel.add(deviceTypeIOList);
		panel.add(locationLabel);
		panel.add(locationList);
		panel.add(addButton);
		add(panel);
		///
		setSize(425, 200);
		setVisible(true);
	}

	private List getListFromModel() {

		return Main.getListToGui();

	}
	private void addButtonActionPerformed(String devType, DeviceType_Input devTypeIn, DeviceType_Output devTypeOut, String alias, String location) {
		JOptionPane.showMessageDialog(panel,"The Device was added successfully.");
		Device device = new Lock("lock1");
		switch(devType) {
		case "Input":
			switch(devTypeIn) {
			case Air_Humidity_Sensor:
				device = new AirHumiditySensor(alias);
				break;
			case Gas_Sensor:
				device = new GasSensor(alias);
				break;
			case Light_Sensor:
				device  = new LightSensor(alias);
				break;
			case Motion_Sensor:
				device = new MotionSensor(alias);
				break;
			case Smoke_Sensor:
				device = new SmokeSensor(alias);
				break;
			case Temperature_Sensor:
				device = new TemperatureSensor(alias);
				break;
			default:
				device = new Lock("Lock1");
					
			}
			break;
		case "Output":
			switch(devTypeOut) {
			case GATE:
				device = new Gate(alias);
				break;
			case HEATER:
				device = new Heater(alias);
				break;
			case LOCK:
				device = new Lock(alias);
				break;
			case SHUTTER:
				device = new Shutter(alias);
				break;
			case WALLSOCKET:
				device = new WallSocket(alias);
				break;
			case BULB_RGB:
				device = new BulbRGBW(alias);
				break;
			case BULB_ONECOLOR:
				device = new BulbOneColor(alias);
				break; 
			default:
				device = new Lock("Lock1");
				
			}
			break;
			default:
				device = new Lock("Lock1");
		}
		UserLoginBase.getCurrentUser().getHome().addDevice(device);
		NaprawdeMainFrame.RefreshTableData(UserLoginBase.getCurrentUser().getHome().getDeviceList());
		dispose();
	}
	
}
