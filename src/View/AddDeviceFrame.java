package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Objects;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Main.Main;
import User.UserDataBase;
import User.UserLoginBase;
import Control.DeviceType.DeviceType_Input;
import Control.DeviceType.DeviceType_Output;
import Controller.HomeToGui;
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
	private static JPanel panel;
	private JLabel newLocationLabel;
	private JTextField newLocationField;

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
		locationList = new JComboBox(UserLoginBase.getCurrentUser().getHome().getLocationList().toArray(new String[UserLoginBase.getCurrentUser().getHome().getLocationList().size()]));
		deviceTypeLabel = new JLabel("Device type: ");
		deviceTypeList = new JComboBox(DeviceType_Input.values());
		deviceTypeIOLabel = new JLabel("Input/Output");
		deviceTypeIOList = new JComboBox(new String[] {"Input","Output" });
		newLocationLabel = new JLabel("New Location:");
		newLocationField = new JTextField();
		panel = new JPanel();
//
		panel.setLayout(null);
		if(getListFromModel().size()!=1) {
			newLocationLabel.setVisible(false);
			newLocationField.setVisible(false);}	
		else {
			newLocationLabel.setVisible(true);
			newLocationField.setVisible(true);
		}
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
		locationList.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					if(e.getItem()=="Add location") {
						newLocationLabel.setVisible(true);
						newLocationField.setVisible(true);
					}else {
						newLocationLabel.setVisible(false);
						newLocationField.setVisible(false);
						newLocationField.setText(null);
					}
				}
				
			}
			
		});

		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!Objects.equals(nameTextField.getText(), "")){
					if(!Objects.equals(newLocationField.getText(), "")){
						String location;
						if(Objects.equals((String) locationList.getSelectedItem(), "Add location")){
							location = newLocationField.getText();
						}
						else {
							location = (String)locationList.getSelectedItem();
						}

						switch (Objects.requireNonNull(deviceTypeIOList.getSelectedItem()).toString()) {
							case "Input" ->
									addButtonActionPerformed(deviceTypeIOList.getSelectedItem().toString(), (DeviceType_Input) deviceTypeList.getSelectedItem(), null, nameTextField.getText(), location);
							case "Output" ->
									addButtonActionPerformed(deviceTypeIOList.getSelectedItem().toString(), null, (DeviceType_Output) deviceTypeList.getSelectedItem(), nameTextField.getText(), location);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Location field cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Name field cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
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
		newLocationLabel.setBounds(275,25,100,25);
		newLocationField.setBounds(275,50,100,25);
		///
		panel.add(newLocationField);
		panel.add(newLocationLabel);
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
		if (UserLoginBase.getCurrentUser().getHome().getLocationList().size()==0) {
			locationList.setVisible(false);
			locationLabel.setVisible(false);
		}
	}

	private List getListFromModel() {

		return HomeToGui.sendLocationListToGui();

	}
	private void addButtonActionPerformed(String devType, DeviceType_Input devTypeIn, DeviceType_Output devTypeOut, String alias, String location) {
		JOptionPane.showMessageDialog(panel,"The Device was added successfully.");

		if(!newLocationField.getText().isBlank()) {
			HomeToGui.AddLocation(newLocationField.getText());
			HomeToGui.addDeviceFromGui(devType,devTypeIn,devTypeOut,alias,newLocationField.getText());
		}
		else{
		HomeToGui.addDeviceFromGui(devType,devTypeIn,devTypeOut,alias,location);}
		dispose();
	}

	public static JPanel getPanel() {
		return panel;
	}
}
