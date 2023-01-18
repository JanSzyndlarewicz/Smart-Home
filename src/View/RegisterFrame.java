package View;

import User.UserLoginBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import User.UserLoginBase;
import User.UserDataBase;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RegisterFrame extends JFrame {

        private JPanel panel;
        private static JButton signUpButton;
        private static JLabel welcomeMess;
        private static JLabel usernameLabel;
        private static JTextField UsernameTextField;
        private static JLabel passwordLabel;
        private static JPasswordField passwordTextField;
        private static JLabel repeatPasswordLabel;
        private static JPasswordField repeatPasswordTextField;
        private static JCheckBox hidePassword;
        private static JPanel designPanel1;
        private static JPanel designPanel2;
        private static JPanel designPanel3;
        private static JPanel designPanel4;
        private static Color designPanelColor;

        public RegisterFrame() {
            initialize();
        }

        private void initialize() {
            panel = new JPanel();
            welcomeMess = new JLabel("Create account");
            signUpButton = new JButton("Sign Up");
            usernameLabel = new JLabel("Username: ");
            UsernameTextField = new JTextField();
            passwordLabel = new JLabel("Password: ");
            passwordTextField = new JPasswordField();
            repeatPasswordLabel = new JLabel("Repeat password: ");
            repeatPasswordTextField = new JPasswordField();
            hidePassword = new JCheckBox();
            designPanel1 = new JPanel();
            designPanel2 = new JPanel();
            designPanel3 = new JPanel();
            designPanel4 = new JPanel();
            designPanelColor = new Color(139, 42, 163);

            //
            panel.setLayout(null);
            panel.setBackground(new Color(223, 237, 245));
            //
            hidePassword.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (passwordTextField.getEchoChar() == '\u0000') {
                        passwordTextField.setEchoChar('*');
                    } else
                        passwordTextField.setEchoChar('\u0000');
                }
            });
            signUpButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    loginButtonActionPerformed();

                }
            });

            designPanel1.setBackground(designPanelColor);
            designPanel2.setBackground(designPanelColor);
            designPanel3.setBackground(designPanelColor);
            designPanel4.setBackground(designPanelColor);
            signUpButton.setBackground(new Color(101, 36, 166));
            signUpButton.setForeground(new Color(255, 255, 255));
            welcomeMess.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));

            // placement
            designPanel1.setBounds(360, 0, 125, 500);
            designPanel2.setBounds(0, 0, 125, 500);
            designPanel3.setBounds(0, 0, 500, 50);
            designPanel4.setBounds(0, 400, 500, 100);
            welcomeMess.setBounds(180, 50, 200, 50);
            signUpButton.setBounds(200, 350, 100, 25);
            usernameLabel.setBounds(150, 150, 100, 25);
            passwordLabel.setBounds(150, 225, 100, 25);
            repeatPasswordLabel.setBounds(150, 200, 100, 25);
            UsernameTextField.setBounds(150, 200 , 175, 25);
            passwordTextField.setBounds(150, 175, 175, 25);
            hidePassword.setBounds(325, 250, 25, 25);
            //
            panel.add(designPanel1);
            panel.add(designPanel2);
            panel.add(designPanel3);
            panel.add(designPanel4);
            panel.add(usernameLabel);
            panel.add(UsernameTextField);
            panel.add(passwordLabel);
            panel.add(passwordTextField);
            panel.add(repeatPasswordLabel);
            panel.add(signUpButton);
            panel.add(welcomeMess);
            panel.add(hidePassword);
            add(panel);

            setSize(500, 500);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setResizable(false);
            setVisible(true);
        }
        private void loginButtonActionPerformed() {

            if(UserLoginBase.login(UsernameTextField.getText(), new String(passwordTextField.getPassword()))){

                MainFrame home = new MainFrame();
                home.setVisible(true);
                MainFrame.RefreshTableData(UserLoginBase.getCurrentUser().getHome().getDeviceList());
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, "Nieprawidłowe hasło", "", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

