package View;

import Device.Device;
import Device.OutputDevice;
import Device.Sensor.Sensor;
import User.UserLoginBase;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AddRoutineFrame extends JFrame {

	private static boolean isOpen = false;

	private JLabel RoutineNameLabel;
	private JTextField RoutineNameField;
	private JPanel DeviceSelectionPanel;
	private JCheckBox OnEnableSlider1;
	private JCheckBox OnEnableSlider2;
	private JCheckBox OnEnableSlider3;
	private JCheckBox OffEnableSlider1;
	private JCheckBox OffEnableSlider2;
	private JCheckBox OffEnableSlider3;
	private JCheckBox SliderEnableSlider1;
	private JCheckBox SliderEnableSlider2;
	private JCheckBox SliderEnableSlider3;
	private JCheckBox OnEnableToggle1;
	private JCheckBox OnEnableToggle2;
	private JCheckBox OnEnableToggle3;
	private JCheckBox OffEnableToggle1;
	private JCheckBox OffEnableToggle2;
	private JCheckBox OffEnableToggle3;
	private JCheckBox SliderEnableToggle1;
	private JCheckBox SliderEnableToggle2;
	private JCheckBox SliderEnableToggle3;
	private JLabel FromLabel;
	private JLabel OffStateLabel;
	private JLabel OnStateLabel;
	private JPanel OnStatePanel;
	private JPanel OffStatePanel;
	private JLabel SensorLabel;
	private JPanel RoutineSettingsPanel;
	private JSlider OnSlider1;
	private JSlider OnSlider2;
	private JSlider OnSlider3;
	private JSlider OffSlider1;
	private JSlider OffSlider2;
	private JSlider OffSlider3;
	private JSlider SliderSlider1;
	private JSlider SliderSlider2;
	private JSlider SliderSlider3;
	private JPanel SliderSensorPanel;
	private JPanel SliderStatePanel;
	private JLabel ToLabel;
	private JComboBox<String> OnToggleBox1;
	private JComboBox<String> OnToggleBox2;
	private JComboBox<String> OnToggleBox3;
	private JComboBox<String> OffToggleBox1;
	private JComboBox<String> OffToggleBox2;
	private JComboBox<String> OffToggleBox3;
	private JComboBox<String> SliderToggleBox1;
	private JComboBox<String> SliderToggleBox2;
	private JComboBox<String> SliderToggleBox3;
	private JPanel ToggleSensorPanel;
	private JComboBox<String> SensorComboBox;
	private JComboBox<String> outputDeviceComboBox;
	private JLabel outputDeviceLabel;
	private JPanel RangeSelectionPanel;
	private JSlider FromSlider;
	private JSlider ToSlider;
	private JButton AddButton;

	public AddRoutineFrame() {

		DeviceSelectionPanel = new JPanel();
		//elementy panelu wyboru urzadzen
		RoutineNameLabel = new JLabel();
		RoutineNameField = new JTextField(10);
		SensorLabel = new JLabel();
		SensorComboBox = new JComboBox(getSensorList().toArray());
		outputDeviceLabel = new JLabel();
		outputDeviceComboBox = new JComboBox(getOutputDeviceList().toArray());
		AddButton = new JButton();


		RoutineSettingsPanel = new JPanel();
		//elementy panelu ustawien rutyny
		ToggleSensorPanel = new JPanel();
		SliderSensorPanel = new JPanel();


		//elementy ustawien rutyny dla sensorToggle
		OnStateLabel = new JLabel();
		OnStatePanel = new JPanel();
		OffStateLabel = new JLabel();
		OffStatePanel = new JPanel();


		//elementy ustawien wyjscia dla sensorToggle = true
		OnEnableToggle1 = new JCheckBox();
		OnToggleBox1 = new JComboBox<>();
		OnToggleBox1.setEnabled(false);

		OnEnableSlider1 = new JCheckBox();
		OnSlider1 = new JSlider();
		OnSlider1.setEnabled(false);

		OnEnableToggle2 = new JCheckBox();
		OnToggleBox2 = new JComboBox<>();
		OnToggleBox2.setEnabled(false);

		OnEnableSlider2 = new JCheckBox();
		OnSlider2 = new JSlider();
		OnSlider2.setEnabled(false);

		OnEnableToggle3 = new JCheckBox();
		OnToggleBox3 = new JComboBox<>();
		OnToggleBox3.setEnabled(false);

		OnEnableSlider3 = new JCheckBox();
		OnSlider3 = new JSlider();
		OnSlider3.setEnabled(false);


		//elementy ustawien wyjscia dla sensorToggle = false;
		OffEnableToggle1 = new JCheckBox();
		OffEnableToggle1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OffToggleBox1.setEnabled(!OffToggleBox1.isEnabled());
				OnEnableToggle1.setSelected(!OnEnableToggle1.isSelected());
				OnToggleBox1.setEnabled(!OnToggleBox1.isEnabled());
			}
		});
		OffToggleBox1 = new JComboBox<>();
		OffToggleBox1.setEnabled(false);

		OffEnableSlider1 = new JCheckBox();
		OffEnableSlider1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OffSlider1.setEnabled(!OffSlider1.isEnabled());
				OnEnableSlider1.setSelected(!OnEnableSlider1.isSelected());
				OnSlider1.setEnabled(!OnSlider1.isEnabled());
			}
		});
		OffSlider1 = new JSlider();
		OffSlider1.setEnabled(false);

		OffEnableToggle2 = new JCheckBox();
		OffEnableToggle2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OffToggleBox2.setEnabled(!OffToggleBox2.isEnabled());
				OnEnableToggle2.setSelected(!OnEnableToggle2.isSelected());
				OnToggleBox2.setEnabled(!OnToggleBox2.isEnabled());
			}
		});
		OffToggleBox2 = new JComboBox<>();
		OffToggleBox2.setEnabled(false);

		OffEnableSlider2 = new JCheckBox();
		OffEnableSlider2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OffSlider2.setEnabled(!OffSlider2.isEnabled());
				OnEnableSlider2.setSelected(!OnEnableSlider2.isSelected());
				OnSlider2.setEnabled(!OnSlider2.isEnabled());
			}
		});
		OffSlider2 = new JSlider();
		OffSlider2.setEnabled(false);

		OffEnableToggle3 = new JCheckBox();
		OffEnableToggle3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OffToggleBox3.setEnabled(!OffToggleBox3.isEnabled());
				OnEnableToggle3.setSelected(!OnEnableToggle3.isSelected());
				OnToggleBox3.setEnabled(!OnToggleBox3.isEnabled());
			}
		});
		OffToggleBox3 = new JComboBox<>();
		OffToggleBox3.setEnabled(false);

		OffEnableSlider3 = new JCheckBox();
		OffEnableSlider3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OffSlider3.setEnabled(!OffSlider3.isEnabled());
				OnEnableSlider3.setSelected(!OnEnableSlider3.isSelected());
				OnSlider3.setEnabled(!OnSlider3.isEnabled());
			}
		});
		OffSlider3 = new JSlider();
		OffSlider3.setEnabled(false);




		//elementy ustawien rutyny dla sensorSlider
		RangeSelectionPanel = new JPanel();
		SliderStatePanel = new JPanel();

		//elementy panelu ustawien zakresu dzialania rutyny dla sensorSlider
		ToLabel = new JLabel();
		FromSlider = new JSlider();
		FromLabel = new JLabel();
		ToSlider = new JSlider();

		//elementy panelu ustawien wyjscia dla sensorSlider
		SliderEnableToggle1 = new JCheckBox();
		SliderToggleBox1 = new JComboBox<>();
		SliderToggleBox1.setEnabled(false);

		SliderEnableSlider1 = new JCheckBox();
		SliderSlider1 = new JSlider();
		SliderSlider1.setEnabled(false);

		SliderEnableToggle2 = new JCheckBox();
		SliderToggleBox2 = new JComboBox<>();
		SliderToggleBox2.setEnabled(false);

		SliderEnableSlider2 = new JCheckBox();
		SliderSlider2 = new JSlider();
		SliderSlider2.setEnabled(false);

		SliderEnableToggle3 = new JCheckBox();
		SliderToggleBox3 = new JComboBox<>();
		SliderToggleBox3.setEnabled(false);

		SliderEnableSlider3 = new JCheckBox();
		SliderSlider3 = new JSlider();
		SliderSlider3.setEnabled(false);

		RoutineNameLabel.setText("Name:");
		DeviceSelectionPanel.add(RoutineNameLabel);
		DeviceSelectionPanel.add(RoutineNameField);

		SensorLabel.setText("Sensor:");
		DeviceSelectionPanel.add(SensorLabel);
		DeviceSelectionPanel.add(SensorComboBox);

		outputDeviceLabel.setText("Output device:");
		DeviceSelectionPanel.add(outputDeviceLabel);
		DeviceSelectionPanel.add(outputDeviceComboBox);

		AddButton.setText("Add");

		DeviceSelectionPanel.add(AddButton);

		getContentPane().add(DeviceSelectionPanel);

		CardLayout cards = new CardLayout();

		RoutineSettingsPanel.setLayout(cards);

		ToggleSensorPanel.setLayout(new GridLayout(2, 2, 0, 20));

		OnStateLabel.setText("On:");
		ToggleSensorPanel.add(OnStateLabel);

		OnStatePanel.setLayout(new GridLayout(3, 4));

		OnEnableToggle1.setText("Enable");
		OnEnableToggle1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OnToggleBox1.setEnabled(!OnToggleBox1.isEnabled());
				OffEnableToggle1.setSelected(!OffEnableToggle1.isSelected());
				OffToggleBox1.setEnabled(!OffToggleBox1.isEnabled());
			}
		});
		OnStatePanel.add(OnEnableToggle1);

		OnToggleBox1.setModel(new DefaultComboBoxModel<>(new String[] { "On", "Off" }));
		OnStatePanel.add(OnToggleBox1);

		OnEnableSlider1.setText("Enable");
		OnEnableSlider1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OnSlider1.setEnabled(!OnSlider1.isEnabled());
				OffEnableSlider1.setSelected(!OffEnableSlider1.isSelected());
				OffSlider1.setEnabled(!OffSlider1.isEnabled());
			}
		});
		OnStatePanel.add(OnEnableSlider1);
		OnStatePanel.add(OnSlider1);

		OnEnableToggle2.setText("Enable");
		OnEnableToggle2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OnToggleBox2.setEnabled(!OnToggleBox2.isEnabled());
				OffEnableToggle2.setSelected(!OffEnableToggle2.isSelected());
				OffToggleBox2.setEnabled(!OffToggleBox2.isEnabled());
			}
		});
		OnStatePanel.add(OnEnableToggle2);

		OnToggleBox2.setModel(new DefaultComboBoxModel<>(new String[] { "On", "Off" }));
		OnToggleBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ToggleBox2ActionPerformed(evt);
			}
		});
		OnStatePanel.add(OnToggleBox2);

		OnEnableSlider2.setText("Enable");
		OnEnableSlider2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OnSlider2.setEnabled(!OnSlider2.isEnabled());
				OffEnableSlider2.setSelected(!OffEnableSlider2.isSelected());
				OffSlider2.setEnabled(!OffSlider2.isEnabled());
			}
		});
		OnStatePanel.add(OnEnableSlider2);
		OnStatePanel.add(OnSlider2);

		OnEnableToggle3.setText("Enable");
		OnEnableToggle3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OnToggleBox3.setEnabled(!OnToggleBox3.isEnabled());
				OffEnableToggle3.setSelected(!OffEnableToggle3.isSelected());
				OffToggleBox3.setEnabled(!OffToggleBox3.isEnabled());
			}
		});
		OnStatePanel.add(OnEnableToggle3);

		OnToggleBox3.setModel(new DefaultComboBoxModel<>(new String[] { "On", "Off" }));
		OnStatePanel.add(OnToggleBox3);

		OnEnableSlider3.setText("Enable");
		OnEnableSlider3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OnSlider3.setEnabled(!OnSlider3.isEnabled());
				OffEnableSlider3.setSelected(!OffEnableSlider3.isSelected());
				OffSlider3.setEnabled(!OffSlider3.isEnabled());
			}
		});
		OnStatePanel.add(OnEnableSlider3);
		OnStatePanel.add(OnSlider3);

		ToggleSensorPanel.add(OnStatePanel);

		OffStateLabel.setText("Off:");
		ToggleSensorPanel.add(OffStateLabel);

		OffStatePanel.setLayout(new GridLayout(3, 4));

		OffEnableToggle1.setText("Enable");
		OffStatePanel.add(OffEnableToggle1);

		OffToggleBox1.setModel(new DefaultComboBoxModel<>(new String[] { "On", "Off" }));
		OffStatePanel.add(OffToggleBox1);

		OffEnableSlider1.setText("Enable");
		OffStatePanel.add(OffEnableSlider1);
		OffStatePanel.add(OffSlider1);

		OffEnableToggle2.setText("Enable");
		OffStatePanel.add(OffEnableToggle2);

		OffToggleBox2.setModel(new DefaultComboBoxModel<>(new String[] { "On", "Off" }));
		OffToggleBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ToggleBox5ActionPerformed(evt);
			}
		});
		OffStatePanel.add(OffToggleBox2);

		OffEnableSlider2.setText("Enable");
		OffStatePanel.add(OffEnableSlider2);
		OffStatePanel.add(OffSlider2);

		OffEnableToggle3.setText("Enable");
		OffStatePanel.add(OffEnableToggle3);

		OffToggleBox3.setModel(new DefaultComboBoxModel<>(new String[] { "On", "Off" }));
		OffStatePanel.add(OffToggleBox3);

		OffEnableSlider3.setText("Enable");
		OffStatePanel.add(OffEnableSlider3);
		OffStatePanel.add(OffSlider3);

		ToggleSensorPanel.add(OffStatePanel);

		RoutineSettingsPanel.add(ToggleSensorPanel, "card1");


		SliderSensorPanel.setLayout(new GridLayout(1, 2));

		RangeSelectionPanel.setLayout(new BoxLayout(RangeSelectionPanel, BoxLayout.X_AXIS));

		ToLabel.setText("To:");
		ToLabel.setVerticalAlignment(SwingConstants.TOP);
		RangeSelectionPanel.add(ToLabel);
		RangeSelectionPanel.add(FromSlider);

		FromLabel.setText("From:");
		RangeSelectionPanel.add(FromLabel);
		RangeSelectionPanel.add(ToSlider);

		SliderSensorPanel.add(RangeSelectionPanel);

		SliderStatePanel.setLayout(new GridLayout(3, 4));

		SliderEnableToggle1.setText("Enable");
		SliderStatePanel.add(SliderEnableToggle1);

		SliderToggleBox1.setModel(new DefaultComboBoxModel<>(new String[] { "On", "Off" }));
		SliderStatePanel.add(SliderToggleBox1);

		SliderEnableSlider1.setText("Enable");
		SliderStatePanel.add(SliderEnableSlider1);
		SliderStatePanel.add(SliderSlider1);

		SliderEnableToggle2.setText("Enable");
		SliderStatePanel.add(SliderEnableToggle2);

		SliderToggleBox2.setModel(new DefaultComboBoxModel<>(new String[] { "On", "Off" }));
		SliderToggleBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ToggleBox8ActionPerformed(evt);
			}
		});
		SliderStatePanel.add(SliderToggleBox2);

		SliderEnableSlider2.setText("Enable");
		SliderStatePanel.add(SliderEnableSlider2);
		SliderStatePanel.add(SliderSlider2);

		SliderEnableToggle3.setText("Enable");
		SliderStatePanel.add(SliderEnableToggle3);

		SliderToggleBox3.setModel(new DefaultComboBoxModel<>(new String[] { "On", "Off" }));
		SliderStatePanel.add(SliderToggleBox3);

		SliderEnableSlider3.setText("Enable");
		SliderStatePanel.add(SliderEnableSlider3);
		SliderStatePanel.add(SliderSlider3);

		SliderSensorPanel.add(SliderStatePanel);

		RoutineSettingsPanel.add(SliderSensorPanel, "card3");

		getContentPane().add(RoutineSettingsPanel);

		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		this.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {

			}

			@Override
			public void windowClosing(WindowEvent e) {
				setIsOpen(false);
			}

			@Override
			public void windowClosed(WindowEvent e) {
				setIsOpen(false);
			}

			@Override
			public void windowIconified(WindowEvent e) {

			}

			@Override
			public void windowDeiconified(WindowEvent e) {

			}

			@Override
			public void windowActivated(WindowEvent e) {

			}

			@Override
			public void windowDeactivated(WindowEvent e) {

			}
		});
		pack();

	}

	public static void setIsOpen(boolean state){
		isOpen = state;
	}

	public static boolean getIsOpen(){
		return isOpen;
	}

	private void ToggleBox2ActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void ToggleBox5ActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void ToggleBox8ActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	private ArrayList<String> getSensorList() {
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

	private ArrayList<String> getOutputDeviceList() {
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

}
