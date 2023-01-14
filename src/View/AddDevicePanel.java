package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Main.Main;
import Control.DeviceType.DeviceType_Input;
import Control.DeviceType.DeviceType_Output;

public class AddDevicePanel extends JFrame {
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

	public AddDevicePanel() {
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
		panel.setBackground(Color.decode("#F6FFF6"));
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
				JOptionPane.showMessageDialog(panel,"The Device was added successfully (NOT YET)");
				dispose();
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
	
}
