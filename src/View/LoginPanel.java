package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
	private static JButton loginButton;
	private static JLabel welcomeMess;
	private static JLabel loginLabel;
	private static JTextField loginTextField;
	private static JLabel passLabel;
	private static JPasswordField passTextField;
	private static JCheckBox hidePassword;
	private static JPanel designPanel1;
	private static JPanel designPanel2;
	private static JPanel designPanel3;
	private static JPanel designPanel4;
	private static Color designPanelColor;

	public LoginPanel() {
		initialize();
	}

	private void initialize() {
		loginButton = new JButton("Login");
		welcomeMess = new JLabel("Login Page");
		loginLabel = new JLabel("Login: ");
		loginTextField = new JTextField();
		passLabel = new JLabel("Password: ");
		passTextField = new JPasswordField();
		hidePassword = new JCheckBox();
		designPanel1 = new JPanel();
		designPanel2 = new JPanel();
		designPanel3 = new JPanel();
		designPanel4 = new JPanel();
		designPanelColor = new Color(139, 42, 163);

		//
		setLayout(null);
		setBackground(new Color(223, 237, 245));
		//
		hidePassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (passTextField.getEchoChar() == '\u0000') {
					passTextField.setEchoChar('*');
				} else
					passTextField.setEchoChar('\u0000');
			}
		});
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// this will be different in final version
				MainFrame.switchToFrame2();

			}
		});
		//

		designPanel1.setBackground(designPanelColor);
		designPanel2.setBackground(designPanelColor);
		designPanel3.setBackground(designPanelColor);
		designPanel4.setBackground(designPanelColor);
		loginButton.setBackground(new Color(101, 36, 166)); // do I move it upwards?
		loginButton.setForeground(new Color(255, 255, 255)); // ^^^
		welcomeMess.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));

		// placement
		designPanel1.setBounds(360, 0, 125, 500);
		designPanel2.setBounds(0, 0, 125, 500);
		designPanel3.setBounds(0, 0, 500, 50);
		designPanel4.setBounds(0, 400, 500, 100);
		welcomeMess.setBounds(195, 50, 100, 50);
		loginButton.setBounds(200, 350, 100, 25);
		loginLabel.setBounds(150, 150, 100, 25);
		passLabel.setBounds(150, 225, 100, 25);
		loginTextField.setBounds(150, 175, 175, 25);
		passTextField.setBounds(150, 250, 175, 25);
		hidePassword.setBounds(325, 250, 25, 25);
		//
		add(designPanel1);
		add(designPanel2);
		add(designPanel3);
		add(designPanel4);
		add(loginLabel);
		add(loginTextField);
		add(passLabel);
		add(passTextField);
		add(loginButton);
		add(welcomeMess);
		add(hidePassword);
	}

}
