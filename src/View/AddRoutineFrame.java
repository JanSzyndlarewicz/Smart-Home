package View;

import Controller.HomeToGui;
import DeviceProperty.Slider;
import DeviceProperty.Toggle;
import User.UserLoginBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class AddRoutineFrame extends JFrame {

	private static boolean isOpen = false;
	private int currentlyShown;

	private ArrayList<JLabel> OnPropertyLabelsSlider = new ArrayList<>();
	private ArrayList<JLabel> OffPropertyLabelsSlider = new ArrayList<>();
	private ArrayList<JLabel> SliderPropertyLabelsSlider = new ArrayList<>();
	private ArrayList<JLabel> OnPropertyLabelsToggle = new ArrayList<>();
	private ArrayList<JLabel> OffPropertyLabelsToggle = new ArrayList<>();
	private ArrayList<JLabel> SliderPropertyLabelsToggle = new ArrayList<>();
	private ArrayList<JCheckBox> OnEnableSliders = new ArrayList<>();
	private ArrayList<JCheckBox> OnEnableToggles = new ArrayList<>();
	private ArrayList<JCheckBox> OffEnableSliders = new ArrayList<>();
	private ArrayList<JCheckBox> OffEnableToggles = new ArrayList<>();
	private ArrayList<JCheckBox> SliderEnableSliders = new ArrayList<>();
	private ArrayList<JCheckBox> SliderEnableToggles = new ArrayList<>();
	private ArrayList<JComboBox> OnComboBoxes = new ArrayList<>();
	private ArrayList<JComboBox> OffComboBoxes = new ArrayList<>();
	private ArrayList<JComboBox> SliderComboBoxes = new ArrayList<>();
	private ArrayList<JSlider> OnSliders = new ArrayList<>();
	private ArrayList<JSlider> OffSliders = new ArrayList<>();
	private ArrayList<JSlider> SliderSliders = new ArrayList<>();

	private JPanel startPanel;
	private JLabel RoutineNameLabel;
	private JTextField RoutineNameField;
	private JPanel DeviceSelectionPanel;

	private JLabel SliderToggleLabel1;
	private JLabel SliderToggleLabel2;
	private JLabel SliderToggleLabel3;
	private JLabel SliderSliderLabel1;
	private JLabel SliderSliderLabel2;
	private JLabel SliderSliderLabel3;
	private JLabel OnToggleLabel1;
	private JLabel OnToggleLabel2;
	private JLabel OnToggleLabel3;
	private JLabel OnSliderLabel1;
	private JLabel OnSliderLabel2;
	private JLabel OnSliderLabel3;
	private JLabel OnSliderLabel4;
	private JLabel OffToggleLabel1;
	private JLabel OffToggleLabel2;
	private JLabel OffToggleLabel3;
	private JLabel OffSliderLabel1;
	private JLabel OffSliderLabel2;
	private JLabel OffSliderLabel3;
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
	CardLayout cards;

	public AddRoutineFrame() {

		currentlyShown = 0;

		OnToggleLabel1 = new JLabel("OnToggleLabel1");
		OnToggleLabel2 = new JLabel("OnToggleLabel2");
		OnToggleLabel3 = new JLabel("OnToggleLabel3");
		OnSliderLabel1 = new JLabel("OnSliderLabel1");
		OnSliderLabel2 = new JLabel("OnSliderLabel2");
		OnSliderLabel3 = new JLabel("OnSliderLabel3");

		OffToggleLabel1 = new JLabel("OffToggleLabel1");
		OffToggleLabel2 = new JLabel("OffToggleLabel2");
		OffToggleLabel3 = new JLabel("OffToggleLabel3");
		OffSliderLabel1 = new JLabel("OffSliderLabel1");
		OffSliderLabel2 = new JLabel("OffSliderLabel2");
		OffSliderLabel3 = new JLabel("OffSliderLabel3");

		SliderToggleLabel1 = new JLabel("SliderToggleLabel1");
		SliderToggleLabel2 = new JLabel("SliderToggleLabel2");
		SliderToggleLabel3 = new JLabel("SliderToggleLabel3");
		SliderSliderLabel1 = new JLabel("SliderSliderLabel1");
		SliderSliderLabel2 = new JLabel("SliderSliderLabel2");
		SliderSliderLabel3 = new JLabel("SliderSliderLabel3");




		DeviceSelectionPanel = new JPanel();
		//elementy panelu wyboru urzadzen
		RoutineNameLabel = new JLabel();
		RoutineNameField = new JTextField(10);
		SensorLabel = new JLabel();
		SensorComboBox = new JComboBox(HomeToGui.getSensorAliasList().toArray());
		outputDeviceLabel = new JLabel();
		outputDeviceComboBox = new JComboBox(HomeToGui.getOutputDeviceAliasList().toArray());
		AddButton = new JButton();


		RoutineSettingsPanel = new JPanel();
		cards = new CardLayout();
		RoutineSettingsPanel.setLayout(cards);
		//elementy panelu ustawien rutyny
		startPanel = new JPanel();
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
		SensorComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sensorComboBoxAction();
			}
		});
		DeviceSelectionPanel.add(SensorComboBox);

		outputDeviceLabel.setText("Output device:");
		DeviceSelectionPanel.add(outputDeviceLabel);
		outputDeviceComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hideAll();
				showProperties();
			}
		});
		DeviceSelectionPanel.add(outputDeviceComboBox);

		AddButton.setText("Add");

		DeviceSelectionPanel.add(AddButton);

		getContentPane().add(DeviceSelectionPanel);



		RoutineSettingsPanel.add(startPanel, "card0");

		ToggleSensorPanel.setLayout(new GridLayout(2, 2, 0, 20));

		OnStateLabel.setText("On:");
		ToggleSensorPanel.add(OnStateLabel);

		OnStatePanel.setLayout(new GridLayout(6, 4));

		OnStatePanel.add(new JPanel());
		OnStatePanel.add(OnToggleLabel1);
		OnStatePanel.add(new JPanel());
		OnStatePanel.add((OnSliderLabel1));

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

		OnStatePanel.add(new JPanel());
		OnStatePanel.add(OnToggleLabel2);
		OnStatePanel.add(new JPanel());
		OnStatePanel.add(OnSliderLabel2);


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

		OnStatePanel.add(new JPanel());
		OnStatePanel.add(OnToggleLabel3);
		OnStatePanel.add(new JPanel());
		//OnStateLabel.add(OnSliderLabel3);
		OnStatePanel.add(new JPanel().add(OnSliderLabel3));

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

		OffStatePanel.setLayout(new GridLayout(6, 4));

		OffStatePanel.add(new JPanel());
		OffStatePanel.add(OffToggleLabel1);
		OffStatePanel.add(new JPanel());
		OffStatePanel.add(OffSliderLabel1);

		OffEnableToggle1.setText("Enable");
		OffStatePanel.add(OffEnableToggle1);

		OffToggleBox1.setModel(new DefaultComboBoxModel<>(new String[] { "On", "Off" }));
		OffStatePanel.add(OffToggleBox1);

		OffEnableSlider1.setText("Enable");
		OffStatePanel.add(OffEnableSlider1);
		OffStatePanel.add(OffSlider1);

		OffStatePanel.add(new JPanel());
		OffStatePanel.add(OffToggleLabel2);
		OffStatePanel.add(new JPanel());
		OffStatePanel.add(OffSliderLabel2);

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

		OffStatePanel.add(new JPanel());
		OffStatePanel.add(OffToggleLabel3);
		OffStatePanel.add(new JPanel());
		OffStatePanel.add(OffSliderLabel3);

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

		SliderStatePanel.setLayout(new GridLayout(6, 4));

		SliderStatePanel.add(new JPanel());
		SliderStatePanel.add(SliderToggleLabel1);
		SliderStatePanel.add(new JPanel());
		SliderStatePanel.add(SliderSliderLabel1);

		SliderEnableToggle1.setText("Enable");
		SliderEnableToggle1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SliderToggleBox1.setEnabled(!SliderToggleBox1.isEnabled());
			}
		});
		SliderStatePanel.add(SliderEnableToggle1);

		SliderToggleBox1.setModel(new DefaultComboBoxModel<>(new String[] { "On", "Off" }));
		SliderStatePanel.add(SliderToggleBox1);

		SliderEnableSlider1.setText("Enable");
		SliderEnableSlider1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SliderSlider1.setEnabled(!SliderSlider1.isEnabled());
			}
		});
		SliderStatePanel.add(SliderEnableSlider1);
		SliderStatePanel.add(SliderSlider1);

		SliderStatePanel.add(new JPanel());
		SliderStatePanel.add(SliderToggleLabel2);
		SliderStatePanel.add(new JPanel());
		SliderStatePanel.add(SliderSliderLabel2);

		SliderEnableToggle2.setText("Enable");
		SliderEnableToggle2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SliderToggleBox2.setEnabled(!SliderToggleBox2.isEnabled());
			}
		});
		SliderStatePanel.add(SliderEnableToggle2);

		SliderToggleBox2.setModel(new DefaultComboBoxModel<>(new String[] { "On", "Off" }));
		SliderToggleBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ToggleBox8ActionPerformed(evt);
			}
		});
		SliderStatePanel.add(SliderToggleBox2);

		SliderEnableSlider2.setText("Enable");
		SliderEnableSlider2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SliderSlider2.setEnabled(!SliderSlider2.isEnabled());
			}
		});
		SliderStatePanel.add(SliderEnableSlider2);
		SliderStatePanel.add(SliderSlider2);

		SliderStatePanel.add(new JPanel());
		SliderStatePanel.add(SliderToggleLabel3);
		SliderStatePanel.add(new JPanel());
		SliderStatePanel.add(SliderSliderLabel3);

		SliderEnableToggle3.setText("Enable");
		SliderEnableToggle3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SliderToggleBox3.setEnabled(!SliderToggleBox3.isEnabled());
			}
		});
		SliderStatePanel.add(SliderEnableToggle3);

		SliderToggleBox3.setModel(new DefaultComboBoxModel<>(new String[] { "On", "Off" }));
		SliderStatePanel.add(SliderToggleBox3);

		SliderEnableSlider3.setText("Enable");
		SliderEnableSlider3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SliderSlider3.setEnabled(!SliderSlider3.isEnabled());
			}
		});
		SliderStatePanel.add(SliderEnableSlider3);
		SliderStatePanel.add(SliderSlider3);

		SliderSensorPanel.add(SliderStatePanel);

		RoutineSettingsPanel.add(SliderSensorPanel, "card2");

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

		OnPropertyLabelsToggle.add(OnToggleLabel1);
		OnPropertyLabelsToggle.add(OnToggleLabel2);
		OnPropertyLabelsToggle.add(OnToggleLabel3);

		OffPropertyLabelsToggle.add(OffToggleLabel1);
		OffPropertyLabelsToggle.add(OffToggleLabel2);
		OffPropertyLabelsToggle.add(OffToggleLabel3);

		SliderPropertyLabelsToggle.add(SliderToggleLabel1);
		SliderPropertyLabelsToggle.add(SliderToggleLabel2);
		SliderPropertyLabelsToggle.add(SliderToggleLabel3);

		OnPropertyLabelsSlider.add(OnSliderLabel1);
		OnPropertyLabelsSlider.add(OnSliderLabel2);
		OnPropertyLabelsSlider.add(OnSliderLabel3);

		OffPropertyLabelsSlider.add(OffSliderLabel1);
		OffPropertyLabelsSlider.add(OffSliderLabel2);
		OffPropertyLabelsSlider.add(OffSliderLabel3);

		SliderPropertyLabelsSlider.add(SliderSliderLabel1);
		SliderPropertyLabelsSlider.add(SliderSliderLabel2);
		SliderPropertyLabelsSlider.add(SliderSliderLabel3);

		OnEnableToggles.add(OnEnableToggle1);
		OnEnableToggles.add(OnEnableToggle2);
		OnEnableToggles.add(OnEnableToggle3);

		OffEnableToggles.add(OffEnableToggle1);
		OffEnableToggles.add(OffEnableToggle2);
		OffEnableToggles.add(OffEnableToggle3);

		SliderEnableToggles.add(SliderEnableToggle1);
		SliderEnableToggles.add(SliderEnableToggle2);
		SliderEnableToggles.add(SliderEnableToggle3);

		OnEnableSliders.add(OnEnableSlider1);
		OnEnableSliders.add(OnEnableSlider2);
		OnEnableSliders.add(OnEnableSlider3);

		OffEnableSliders.add(OffEnableSlider1);
		OffEnableSliders.add(OffEnableSlider2);
		OffEnableSliders.add(OffEnableSlider3);

		SliderEnableSliders.add(SliderEnableSlider1);
		SliderEnableSliders.add(SliderEnableSlider2);
		SliderEnableSliders.add(SliderEnableSlider3);

		OnComboBoxes.add(OnToggleBox1);
		OnComboBoxes.add(OnToggleBox2);
		OnComboBoxes.add(OnToggleBox3);

		OffComboBoxes.add(OffToggleBox1);
		OffComboBoxes.add(OffToggleBox2);
		OffComboBoxes.add(OffToggleBox3);

		SliderComboBoxes.add(SliderToggleBox1);
		SliderComboBoxes.add(SliderToggleBox2);
		SliderComboBoxes.add(SliderToggleBox3);

		OnSliders.add(OnSlider1);
		OnSliders.add(OnSlider2);
		OnSliders.add(OnSlider3);

		OffSliders.add(OffSlider1);
		OffSliders.add(OffSlider2);
		OffSliders.add(OffSlider3);

		SliderSliders.add(SliderSlider1);
		SliderSliders.add(SliderSlider2);
		SliderSliders.add(SliderSlider3);

		this.setPreferredSize(new Dimension(1000, 500));
		pack();

		sensorComboBoxAction();

		hideAll();
		showProperties();

		AddButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createRoutines();
			}
		});
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

	private void hideAll() {
		ArrayList<ArrayList> listoflists = new ArrayList<>();

		listoflists.add(OnPropertyLabelsToggle);
		listoflists.add(OffPropertyLabelsToggle);
		listoflists.add(OnPropertyLabelsSlider);
		listoflists.add(OffPropertyLabelsSlider);
		listoflists.add(OnEnableToggles);
		listoflists.add(OffEnableToggles);
		listoflists.add(OnEnableSliders);
		listoflists.add(OffEnableSliders);
		listoflists.add(OnComboBoxes);
		listoflists.add(OffComboBoxes);
		listoflists.add(OnSliders);
		listoflists.add(OffSliders);
		listoflists.add(SliderSliders);
		listoflists.add(SliderComboBoxes);
		listoflists.add(SliderPropertyLabelsToggle);
		listoflists.add(SliderPropertyLabelsSlider);
		listoflists.add(SliderEnableSliders);
		listoflists.add(SliderEnableToggles);

		for (int i = 0; i < listoflists.size(); i++) {
			for (int j = 0; j < listoflists.get(i).size(); j++) {
				((JComponent) listoflists.get(i).get(j)).setVisible(false);
				if(listoflists.get(i).get(j) instanceof JCheckBox){
					((JCheckBox) listoflists.get(i).get(j)).setSelected(false);
				}else{
					((JComponent) listoflists.get(i).get(j)).setEnabled(false);
				}
			}
		}
	}

	private void showProperties(){
		HomeToGui.ShowRoutineProperties((String) outputDeviceComboBox.getSelectedItem(), OnEnableToggles, OnEnableSliders, OnComboBoxes, OnPropertyLabelsToggle, OnSliders, OnPropertyLabelsSlider);
		HomeToGui.ShowRoutineProperties((String) outputDeviceComboBox.getSelectedItem(), OffEnableToggles, OffEnableSliders, OffComboBoxes, OffPropertyLabelsToggle, OffSliders, OffPropertyLabelsSlider);
		HomeToGui.ShowRoutineProperties((String) outputDeviceComboBox.getSelectedItem(), SliderEnableToggles, SliderEnableSliders, SliderComboBoxes, SliderPropertyLabelsToggle, SliderSliders, SliderPropertyLabelsSlider);
	}

	private void createRoutines(){

		if(RoutineNameField.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Name field cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
		} else if (!HomeToGui.checkRoutineNameAvailability(RoutineNameField.getText())) {
			JOptionPane.showMessageDialog(null, "A routine of such name already exists", "Error", JOptionPane.ERROR_MESSAGE);
		} else{
			switch (currentlyShown){
				case 1:
					for(int i=0; i<OnEnableToggles.size(); i++){
						if(OnEnableToggles.get(i).isEnabled() && OnEnableToggles.get(i).isSelected()){

							String outputOnValue = convertComboBoxtoString(OnComboBoxes.get(i));
							String outputOffValue = convertComboBoxtoString(OffComboBoxes.get(i));
							Object[] args = {outputOnValue, outputOffValue};

							HomeToGui.CreateRoutine(RoutineNameField.getText(),(String) SensorComboBox.getSelectedItem(), (String) outputDeviceComboBox.getSelectedItem(), OnPropertyLabelsToggle.get(i).getText(), args);
							System.out.println("Created TtoT");

						}
					}

					for(int i=0; i<OnEnableSliders.size(); i++){
						if(OnEnableSliders.get(i).isEnabled() && OnEnableSliders.get(i).isSelected()){

							double doubleOnValue = (double) OnSliders.get(i).getValue()/100;
							String outputOnValue = String.valueOf(doubleOnValue);
							double doubleOffValue = (double) OffSliders.get(i).getValue()/100;
							String outputOffValue = String.valueOf(doubleOffValue);

							Object[] args = {outputOnValue, outputOffValue};

							HomeToGui.CreateRoutine(RoutineNameField.getText(),(String) SensorComboBox.getSelectedItem(), (String) outputDeviceComboBox.getSelectedItem(), OnPropertyLabelsSlider.get(i).getText(), args);
							System.out.println("Created TtoS");
						}
					}
					break;
				case 2:
					for(int i=0; i<SliderEnableToggles.size(); i++){
						if(SliderEnableToggles.get(i).isEnabled() && SliderEnableToggles.get(i).isSelected()){

							double minValue = HomeToGui.convertSliderPercentageToSensorSlider((String) SensorComboBox.getSelectedItem(), FromSlider.getValue());
							double maxValue = HomeToGui.convertSliderPercentageToSensorSlider((String) SensorComboBox.getSelectedItem(), ToSlider.getValue());
							boolean outputState = convertComboBoxtoBool(SliderComboBoxes.get(i));

							Object[] args = {minValue, maxValue, outputState};

							HomeToGui.CreateRoutine(RoutineNameField.getText(),(String) SensorComboBox.getSelectedItem(), (String) outputDeviceComboBox.getSelectedItem(), SliderPropertyLabelsToggle.get(i).getText(), args);
							System.out.println("Created StoT");
						}
					}

					for(int i=0; i<SliderEnableSliders.size(); i++){
						if(SliderEnableSliders.get(i).isEnabled() && SliderEnableSliders.get(i).isSelected()){

							double minValue = HomeToGui.convertSliderPercentageToSensorSlider((String) SensorComboBox.getSelectedItem(), FromSlider.getValue());
							double maxValue = HomeToGui.convertSliderPercentageToSensorSlider((String) SensorComboBox.getSelectedItem(), ToSlider.getValue());
							String outputValue = String.valueOf(SliderSliders.get(i).getValue());

							Object[] args = {minValue, maxValue, outputValue};

							HomeToGui.CreateRoutine(RoutineNameField.getText(),(String) SensorComboBox.getSelectedItem(), (String) outputDeviceComboBox.getSelectedItem(), SliderPropertyLabelsSlider.get(i).getText(), args);
							System.out.println("Created StoS");
						}
					}
			}

			JOptionPane.showMessageDialog(null, "The routine has been created.", "Status", JOptionPane.PLAIN_MESSAGE);
			this.setVisible(false);
			isOpen = false;
			this.dispose();

		}
	}

	private String convertComboBoxtoString(JComboBox box){
		String output;
		switch ((String) box.getSelectedItem()){
			case "Off":
				output = "false";
				break;
			default:
				output = "true";
		}
		return output;
	}

	private boolean convertComboBoxtoBool(JComboBox box){
		boolean output;
		switch ((String) box.getSelectedItem()){
			case "Off":
				output = false;
				break;
			default:
				output = true;
		}
		return output;
	}

	private void sensorComboBoxAction(){
		if(UserLoginBase.getCurrentUser().getHome().getDevice((String) SensorComboBox.getSelectedItem()).getProperties()[0] instanceof Slider){
			cards.show(RoutineSettingsPanel, "card2");
			currentlyShown = 2;
		} else if (UserLoginBase.getCurrentUser().getHome().getDevice((String) SensorComboBox.getSelectedItem()).getProperties()[0] instanceof Toggle) {
			cards.show(RoutineSettingsPanel, "card1");
			currentlyShown = 1;
		}else{
			cards.show(RoutineSettingsPanel, "card0");
			currentlyShown = 0;
		}
	}

}
