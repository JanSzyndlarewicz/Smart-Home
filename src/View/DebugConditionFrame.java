package View;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class DebugConditionFrame extends JFrame{
	private JPanel conditionPanel;
	private JSlider brightSlider;
	private JSlider humidSlider;
	private JSlider tempSlider;
	private JCheckBox gasDetection;
	private JCheckBox smokeDetection;
	private JCheckBox motionDetection;
	private JLabel brightLabel;
	private JLabel humidLabel;
	private JLabel tempLabel;
	private JLabel gasLabel;
	private JLabel smokeLabel;
	private JLabel motionLabel;
	private JLabel welcomeLabel;
	public DebugConditionFrame() {
		initialize();
	}
	public void initialize() {
		conditionPanel = new JPanel();
		brightSlider = new JSlider();
		humidSlider = new JSlider();
		tempSlider = new JSlider();
		gasDetection = new JCheckBox();
		smokeDetection = new JCheckBox();
		motionDetection = new JCheckBox();
		brightLabel = new JLabel("Brightness");
		humidLabel = new JLabel("Humidity");
		tempLabel = new JLabel("Temperature");
		gasLabel = new JLabel("Gas");
		smokeLabel = new JLabel("Smoke");
		motionLabel = new JLabel("Motion");
		welcomeLabel = new JLabel("Debug Condition Menu");
		
		conditionPanel.setLayout(null);
		brightLabel.setBounds(125,75,100,25);
		brightSlider.setBounds(50,100,200,25);
		humidLabel.setBounds(125,150,100,25);
		humidSlider.setBounds(50,175,200,25);
		tempLabel.setBounds(125,225,100,25);
		tempSlider.setBounds(50,250,200,25);
		gasLabel.setBounds(50,300,100,25);
		gasDetection.setBounds(50,325,25,25);
		smokeLabel.setBounds(125,300,100,25);
		smokeDetection.setBounds(125,325,25,25);
		motionLabel.setBounds(200,300,100,25);
		motionDetection.setBounds(200,325,25,25);
		
		welcomeLabel.setBounds(50,25,200,25);
		
		
		conditionPanel.add(brightSlider);
		conditionPanel.add(humidSlider);
		conditionPanel.add(tempSlider);
		conditionPanel.add(gasDetection);
		conditionPanel.add(smokeDetection);
		conditionPanel.add(motionDetection);
		conditionPanel.add(welcomeLabel);
		conditionPanel.add(brightLabel);
		conditionPanel.add(humidLabel);
		conditionPanel.add(tempLabel);
		conditionPanel.add(gasLabel);
		conditionPanel.add(smokeLabel);
		conditionPanel.add(motionLabel);
		add(conditionPanel);
		
		
		setSize(300,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
	}

}
