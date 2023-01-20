package View;

import User.UserLoginBase;
import User.UserDataBase;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginFrame extends JFrame {
	private JPanel panel;
	private static JButton loginButton;
	private static JLabel welcomeMess;

	private static JPanel designPanel1;
	private static JPanel designPanel2;
	private static JPanel designPanel3;
	private static JPanel designPanel4;
	private static Color designPanelColor;

	public LoginFrame() {
		initialize();
	}

	private void initialize() {
		panel = new JPanel();
		loginButton = new JButton("Login");
		welcomeMess = new JLabel("Login Page");

		designPanel1 = new JPanel();
		designPanel2 = new JPanel();
		designPanel3 = new JPanel();
		designPanel4 = new JPanel();
		designPanelColor = new Color(139, 42, 163);

		//
		panel.setLayout(null);
		panel.setBackground(new Color(223, 237, 245));
		//

//		loginButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				loginButtonActionPerformed();
//
//			}
//		});

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

		//
		panel.add(designPanel1);
		panel.add(designPanel2);
		panel.add(designPanel3);
		panel.add(designPanel4);

		panel.add(loginButton);
		panel.add(welcomeMess);

		add(panel);

		setSize(500, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
//	private void loginButtonActionPerformed() {
//
//		if(UserLoginBase.login(loginTextField.getText(), new String(passTextField.getPassword()))){
//
//			MainFrame home = new MainFrame();
//			home.setVisible(true);
//			MainFrame.RefreshTableData(UserLoginBase.getCurrentUser().getHome().getDeviceList());
//			dispose();
//		}
//		else{
//			JOptionPane.showMessageDialog(null, "Nieprawidłowe hasło", "", JOptionPane.ERROR_MESSAGE);
//		}
//		// stuff
//
//	}

}
