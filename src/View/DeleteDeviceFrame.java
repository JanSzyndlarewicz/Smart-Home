package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Device.Device;
import User.UserLoginBase;

public class DeleteDeviceFrame extends JFrame{
	private JComboBox deviceList;
	private JLabel deviceListLabel;
	private JButton deleteButton;
	private static JPanel panel;
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
		ArrayList<Device> tempDevList = UserLoginBase.getCurrentUser().getHome().getDeviceList();
		ArrayList<String> devList = new ArrayList<String>();
		for(int i=0; i<tempDevList.size(); i++) {
			devList.add(tempDevList.get(i).getAlias());
		}
		
		return devList;
	}
	private void deleteDeviceActionPerformed() {
		int result = JOptionPane.showConfirmDialog(panel, "Are you sure that you want to delete " + deviceList.getSelectedItem(), "Deletion", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(result == JOptionPane.YES_OPTION){
             JOptionPane.showMessageDialog(panel, "Device deleted successfully"); 
             UserLoginBase.getCurrentUser().getHome().removeDevice(UserLoginBase.getCurrentUser().getHome().getDevice((String) deviceList.getSelectedItem()));
             MainFrame.RefreshTableData(UserLoginBase.getCurrentUser().getHome().getDeviceList());
            dispose();
            }
	}

	public static JPanel getPanel() {
		return panel;
	}
}
