package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Device.Device;

public class DeleteDeviceFrame extends JFrame{
	private JComboBox deviceList;
	private JLabel deviceListLabel;
	private JButton deleteButton;
	private JPanel panel;
	public DeleteDeviceFrame() {
		initialize();
	}
	public void initialize() {
		deviceList= new JComboBox(getDeviceList().toArray());
		deviceListLabel = new JLabel("Device List");
		deleteButton = new JButton("Delete");
		panel = new JPanel();
		
		
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deleteDeviceActionPerformed();
			}
			
		});
		deviceListLabel.setBounds(25,25,100,25);
		deviceList.setBounds(25, 50, 100, 25);
		deleteButton.setBounds(275,100,100,25);
		panel.setLayout(null);
		panel.add(deleteButton);
		panel.add(deviceList);
		panel.add(deviceListLabel);
		add(panel);
		
		
		setSize(425, 200);
		setVisible(true);
	}
	private ArrayList<String> getDeviceList() {
		//should be changed when Controller is implemented
		ArrayList<String> devList = new ArrayList<String>();
		devList.add("Device1");
		devList.add("Device2");
		devList.add("Device3");
		return devList;
	}
	private void deleteDeviceActionPerformed() {
		int result = JOptionPane.showConfirmDialog(panel, "Are you sure that you want to delete " + deviceList.getSelectedItem(), "Deletion", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(result == JOptionPane.YES_OPTION){
             JOptionPane.showMessageDialog(panel, "Device deleted successfully");  
            dispose();
            }
	}
	
}