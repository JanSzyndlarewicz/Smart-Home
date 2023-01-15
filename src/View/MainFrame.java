package View;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame {
	private static JFrame mainFrame;
	private static JFrame mainFrame2;
	private static JPanel loginPanel = new JPanel();
	private static JPanel addDevPanel = new AddDevicePanel();

	public MainFrame() {
		initialize();
	}

	private void initialize() {
		// initializing objects
		mainFrame = new JFrame();
		mainFrame2 = new JFrame();
		loginPanel = new JPanel();
		addDevPanel = new AddDevicePanel();
		// configuring options
		mainFrame.setTitle("Smart Home");
		mainFrame.setSize(500, 500);
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);

		mainFrame2.setTitle("Smart Home 2");
		mainFrame2.setSize(500, 500);
		mainFrame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame2.setResizable(false);
		mainFrame2.setLocationRelativeTo(mainFrame);

		// connecting objects
		mainFrame.add(loginPanel);
		mainFrame2.add(addDevPanel);

		// setting frame visible
		mainFrame.setVisible(true);

	}

	public static void switchToFrame2() {
		// this will be different in final version
		mainFrame2.setLocationRelativeTo(mainFrame);
		mainFrame2.setVisible(true);
		mainFrame.dispose();
	}
}
