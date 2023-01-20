package View;

import User.UserLoginBase;
import User.ResetPassword;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserSettingsFrame extends JFrame {
	private static JPanel userPanel;
	private JLabel loginLabel;
	private JLabel passLabel;
	private JLabel phoneLabel;
	private JLabel mailLabel;
	private JLabel yourAccountLabel;
	private JTextField loginField;
	private JTextField passField;
	private JTextField phoneField;
	private JTextField mailField;
	private JButton deleteAccButton;
	private JButton logoutButton;
	private JButton passButton;
	private JButton phoneButton;
	private JButton mailButton;
	MainFrame InitializingWindow;



	public UserSettingsFrame(MainFrame InitializingWindow) {
		this.InitializingWindow=InitializingWindow;
		initialize();
	}

	public void initialize() {
		userPanel = new JPanel();
		loginLabel = new JLabel("Login");
		passLabel = new JLabel("Password");
		phoneLabel = new JLabel("Phone Nr");
		mailLabel = new JLabel("Email");
		loginField = new JTextField(UserLoginBase.getCurrentUser().getLogin());
		passField = new JTextField(UserLoginBase.getCurrentUser().getPassword());
		phoneField = new JTextField(UserLoginBase.getCurrentUser().getPhoneNumber());
		mailField = new JTextField(UserLoginBase.getCurrentUser().getEmail());
		deleteAccButton = new JButton("Delete Account");
		logoutButton = new JButton("Logout");
		passButton = new JButton("Change");
		phoneButton = new JButton("Change");
		mailButton = new JButton("Change");
		yourAccountLabel = new JLabel("Your Account");

		userPanel.setLayout(null);
		logoutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				logoutButtonActionPerformed();

			}

		});
		passButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				passButtonActionPerformed();
			}

		});
		phoneButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				phoneButtonActionPerformed();

			}

		});
		mailButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mailButtonActionPerformed();

			}

		});
		deleteAccButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deleteAccButtonActionPerformed();

			}

		});

		yourAccountLabel.setBounds(100, 25, 100, 25);
		loginLabel.setBounds(25, 75, 100, 25);
		loginField.setBounds(25, 100, 100, 25);
		passLabel.setBounds(25, 125, 100, 25);
		passField.setBounds(25, 150, 100, 25);
		passButton.setBounds(150, 150, 100, 25);
		phoneLabel.setBounds(25, 175, 100, 25);
		phoneField.setBounds(25, 200, 100, 25);
		phoneButton.setBounds(150, 200, 100, 25);
		mailLabel.setBounds(25, 225, 100, 25);
		mailField.setBounds(25, 250, 100, 25);
		mailButton.setBounds(150, 250, 100, 25);
		deleteAccButton.setBounds(25, 300, 100, 25);
		logoutButton.setBounds(150, 300, 100, 25);

		userPanel.add(loginLabel);
		userPanel.add(passLabel);
		userPanel.add(phoneLabel);
		userPanel.add(mailLabel);
		userPanel.add(loginField);
		userPanel.add(passField);
		userPanel.add(phoneField);
		userPanel.add(mailField);
		userPanel.add(deleteAccButton);
		userPanel.add(logoutButton);
		userPanel.add(passButton);
		userPanel.add(phoneButton);
		userPanel.add(mailButton);
		userPanel.add(yourAccountLabel);

		loginField.setEditable(false);
		passField.setEditable(false);
		phoneField.setEditable(false);
		mailField.setEditable(false);
		add(userPanel);

		setSize(300, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	private void logoutButtonActionPerformed() {
		new LoginFrame().setVisible(true);
		InitializingWindow.dispose();
		dispose();
	}

	private void passButtonActionPerformed() {
		if(passField.isEditable()) {
			passButton.setText("Change");
			passField.setEditable(false);
			
		}else {
			passButton.setText("Save");
			passField.setEditable(true);
		}

		//Setting new password in UserDataBase (<String login, User user>) and UserLoginBase (<String login, String password>)
		ResetPassword.newPassword(loginField.getText(), passField.getText());
		//UserLoginBase.getCurrentUser().setPassword(passField.getText());
		//UserLoginBase.setPassword(loginField.getText(), passField.getText());
	}

	private void phoneButtonActionPerformed() {
		if(phoneField.isEditable()) {
			phoneButton.setText("Change");
			phoneField.setEditable(false);
		}else {
			phoneButton.setText("Save");
			phoneField.setEditable(true);
		}

		UserLoginBase.getCurrentUser().setPhoneNumber(phoneField.getText());

	}

	private void mailButtonActionPerformed() {
		if(mailField.isEditable()) {
			mailButton.setText("Change");
			mailField.setEditable(false);
		}else {
			mailButton.setText("Save");
			mailField.setEditable(true);
		}

		UserLoginBase.getCurrentUser().setEmail(mailField.getText());
	}

	private void deleteAccButtonActionPerformed() {
		int result = JOptionPane.showConfirmDialog(userPanel, "Are you sure, that you want to DELETE your account", "Deletion", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
		if(result==JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(userPanel,"Account Deleted");
			dispose();
		}
	}

	public static JPanel getUserPanel() {
		return userPanel;
	}
}
