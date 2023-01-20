package View;

import User.UserLoginBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import User.UserLoginBase;
import User.UserDataBase;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;
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
        private static JLabel emailLabel;
        private  static JTextField emailTextField;
        private  static  JLabel phoneNumberLabel;

        private static JTextField phoneNumberTextField;
        private static JCheckBox hidePassword;
        private static JCheckBox hidePassword2;

//    private static JLabel homeNameLabel;
//    private static  JTextField homeNameTextField;

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
            usernameLabel = new JLabel("Username:");
            UsernameTextField = new JTextField();
            passwordLabel = new JLabel("Password:");
            passwordTextField = new JPasswordField();
            repeatPasswordLabel = new JLabel("Repeat password:");
            repeatPasswordTextField = new JPasswordField();
            emailLabel = new JLabel("Email: ");
            emailTextField = new JTextField();
            phoneNumberLabel = new JLabel("Phone Number:");
            phoneNumberTextField = new JTextField();
//            homeNameLabel = new JLabel("Name of your house");
//            homeNameTextField = new JTextField();
            hidePassword = new JCheckBox();
            hidePassword2 = new JCheckBox();
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
                        passwordTextField.setEchoChar('•');
                    } else
                        passwordTextField.setEchoChar('\u0000');
                }
            });


            hidePassword2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (repeatPasswordTextField.getEchoChar() == '\u0000') {
                        repeatPasswordTextField.setEchoChar('•');
                    } else
                        repeatPasswordTextField.setEchoChar('\u0000');
                }
            });
            signUpButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    registerButtonActionPerformed();
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
            designPanel3.setBounds(0, 0, 600, 50);
            designPanel4.setBounds(0, 500, 600, 100);
            welcomeMess.setBounds(180, 50, 200, 50);
            signUpButton.setBounds(200, 400, 100, 25);
            usernameLabel.setBounds(150, 100, 100, 25);
            UsernameTextField.setBounds(150, 120 , 175, 25);
            emailLabel.setBounds(150, 150, 100, 25);
            emailTextField.setBounds(150, 170, 175, 25);
            phoneNumberLabel.setBounds(150, 200, 175, 25);
            phoneNumberTextField.setBounds(150, 220, 175, 25);
            passwordLabel.setBounds(150,250, 100, 25);
            passwordTextField.setBounds(150, 270, 175, 25);
            hidePassword.setBounds(325, 270, 25, 25);
            repeatPasswordLabel.setBounds(150, 300, 175, 25);
            repeatPasswordTextField.setBounds(150, 320, 175, 25);
            hidePassword2.setBounds(325, 320, 25, 25);


//            login, email, phone number,

            panel.add(designPanel1);
            panel.add(designPanel2);
            panel.add(designPanel3);
            panel.add(designPanel4);
            panel.add(usernameLabel);
            panel.add(UsernameTextField);
            panel.add(emailLabel);
            panel.add(emailTextField);
            panel.add(phoneNumberLabel);
            panel.add(phoneNumberTextField);
            panel.add(passwordLabel);
            panel.add(passwordTextField);
            panel.add(repeatPasswordLabel);
            panel.add(repeatPasswordTextField);
            panel.add(signUpButton);
            panel.add(welcomeMess);
            panel.add(hidePassword);
            panel.add(hidePassword2);
            add(panel);

            setSize(500, 500);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setResizable(false);
            setVisible(true);
        }


//        this method should be rewritten to save data of the registered user in the ArrayList
        private void registerButtonActionPerformed() {
            if(UserLoginBase.getUserHashMap().get(UsernameTextField.getText()) == null){
                if(isPasswordTheSame()) {
                    MainFrame home = new MainFrame();
                    home.setVisible(true);
                    dispose();
                    MainFrame.RefreshTableData(UserLoginBase.getCurrentUser().getHome().getDeviceList());
                }
                else {
                    JOptionPane.showMessageDialog(null, "Passwords are not the same", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "This user already exists", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }

        private boolean isPasswordTheSame(){
            return Arrays.toString(passwordTextField.getPassword()).equals(Arrays.toString(repeatPasswordTextField.getPassword()));
        }

//        this method is not working as it should
        private void passwordIsNotTheSame(){
            if(!Objects.equals(passwordTextField.getPassword(), repeatPasswordTextField.getPassword())){
                JOptionPane.showMessageDialog(null, "Passwords are not the same", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

