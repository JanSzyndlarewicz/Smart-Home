package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddRoutineFrame extends JFrame{
	private static JPanel routinePanel;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel sensorLabel;
	private JComboBox sensorList;
	private JLabel deviceLabel;
	private JComboBox deviceList;
	private JButton addRoutineButton;
	
	public AddRoutineFrame() {
		initialize();
		
	}
	public void initialize() {
		routinePanel = new JPanel();
		nameLabel = new JLabel("Name");
		nameTextField= new JTextField();
		sensorLabel = new JLabel("Sensor");
		sensorList = new JComboBox();
		deviceLabel = new JLabel("Device");
		deviceList = new JComboBox();
		addRoutineButton = new JButton("Add");
		
		addRoutineButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addButtonActionPerformed();
			}
			
		});
		
		routinePanel.setLayout(null);
		nameLabel.setBounds(25, 25, 100, 25);
		nameTextField.setBounds(25, 50, 100, 25);
		sensorLabel.setBounds(150, 75, 100, 25);
		sensorList.setBounds(150, 100, 100, 25);
		deviceLabel.setBounds(25, 75, 100, 25);
		deviceList.setBounds(25, 100, 100, 25);
		addRoutineButton.setBounds(275, 100, 100, 25);
		
		routinePanel.add(nameLabel);
		routinePanel.add(nameTextField);
		routinePanel.add(deviceList);
		routinePanel.add(deviceLabel);
		routinePanel.add(sensorLabel);
		routinePanel.add(sensorList);
		routinePanel.add(addRoutineButton);
		add(routinePanel);
		setSize(425, 200);
		setVisible(true);
	}
	private void addButtonActionPerformed() {
		JOptionPane.showMessageDialog(routinePanel,"The Routine was added successfully.");
		dispose();
	}

	public static JPanel getRoutinePanel() {
		return routinePanel;
	}
}
