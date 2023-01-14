package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Main.Main;
import Control.DeviceType.DeviceType;

public class AddDevicePanel extends JPanel {
	private static JButton addButton;
	private static JLabel welcomeMess;
	private static JLabel nameLabel;
	private static JTextField nameTextField;
	private static JLabel locationLabel;
	private static JComboBox locationList;
	private static JLabel deviceTypeLabel;
	private static JComboBox deviceTypeList;
	private static JLabel newLocationLabel;
	private static JTextField newLocation;
//	private static ImageIcon deviceImage;
//	private static ImageIcon deviceImage_Bulb;
//	private static JLabel deviceImageLabel;
	public AddDevicePanel() {
		initialize();
	}
	//

	private void initialize() {
		addButton = new JButton("Add");
		welcomeMess = new JLabel("Device adding panel");
		nameLabel = new JLabel("Name: ");
		nameTextField = new JTextField();
		locationLabel = new JLabel("Location: ");
		locationList = new JComboBox(getListFromModel().toArray());
		deviceTypeLabel = new JLabel("Device type: ");
		deviceTypeList = new JComboBox(DeviceType.values());
		newLocationLabel = new JLabel("New Location:");
		newLocation = new JTextField();
//		deviceImage = new ImageIcon("src\\gui\\device.jpg");
//		deviceImage_Bulb = new ImageIcon("src\\gui\\bulb2.jpg");
//		deviceImageLabel = new JLabel(deviceImage_Bulb);
		//
		setLayout(null);
		setBackground(Color.decode("#F6FFF6"));
		//
		locationList.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (e.getItem() == "Add Location") {
						newLocationLabel.setVisible(true);
						newLocation.setVisible(true);
						
					} else {
						newLocation.setText(null);
						newLocationLabel.setVisible(false);
						newLocation.setVisible(false);
					}
				}
			}
		});
//		deviceTypeList.addItemListener(new ItemListener() { // idk czy chcemy cos w tym stylu dodac
//
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				if(e.getStateChange()==ItemEvent.SELECTED) {
//					switch(e.getItem().toString()) {
//					case "BULB":
//						deviceImageLabel.setIcon(deviceImage_Bulb);
//						break;
//					default:
//						deviceImageLabel.setIcon(deviceImage);
//						break;
//							
//					}
//				}
//				
//			}
//			
//		});

		//
		welcomeMess.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));
		newLocationLabel.setVisible(false);
		newLocation.setVisible(false);
		//
		welcomeMess.setBounds(100, 25, 200, 50);
		locationList.setBounds(300, 300, 100, 25);
		nameLabel.setBounds(100, 125, 100, 25);
		nameTextField.setBounds(100, 150, 100, 25);
		locationLabel.setBounds(100, 200, 100, 25);
		locationList.setBounds(100, 225, 100, 25);
		deviceTypeLabel.setBounds(100, 275, 100, 25);
		deviceTypeList.setBounds(100, 300, 100, 25);
		addButton.setBounds(375, 425, 100, 25);
		newLocation.setBounds(275, 225, 100, 25);
		newLocationLabel.setBounds(275, 200, 100, 25);
		//deviceImageLabel.setBounds(300,75,128,128);
		//
		add(nameLabel);
		add(nameTextField);
		add(deviceTypeList);
		add(deviceTypeLabel);
		add(locationLabel);
		add(locationList);
		add(addButton);
		add(welcomeMess);
		add(newLocationLabel);
		add(newLocation);
		//add(deviceImageLabel);
	}

	private List getListFromModel() {

		return Main.getListToGui();

	}
}
