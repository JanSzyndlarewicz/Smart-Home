package View;

import User.UserLoginBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class FirstFrame extends JFrame {

    private JPanel panel;
    private static JButton loginButton;
    private static JButton registerButton;
    private static JLabel welcomeMess;

    private static JPanel designPanel1;
    private static JPanel designPanel2;
    private static JPanel designPanel3;
    private static JPanel designPanel4;
    private static Color designPanelColor;


    public FirstFrame() {
        initialize();
    }

    private void initialize() {
        panel = new JPanel();
        welcomeMess = new JLabel("Choose an option");
        loginButton = new JButton("Sign in");
        registerButton = new JButton("Sign up");
        designPanel1 = new JPanel();
        designPanel2 = new JPanel();
        designPanel3 = new JPanel();
        designPanel4 = new JPanel();
        designPanelColor = new Color(123, 3, 252);

        panel.setLayout(null);
        panel.setBackground(new Color(223, 237, 245));

        designPanel1.setBackground(designPanelColor);
        designPanel2.setBackground(designPanelColor);
        designPanel3.setBackground(designPanelColor);
        designPanel4.setBackground(designPanelColor);
//        loginButton.setBackground(new Color(101, 36, 166));
//        loginButton.setForeground(new Color(255, 255, 255));

        welcomeMess.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));

        // placement
        designPanel1.setBounds(360, 0, 125, 500);
        designPanel2.setBounds(0, 0, 125, 500);
        designPanel3.setBounds(0, 0, 600, 10);
        designPanel4.setBounds(0, 500, 600, 10);
        welcomeMess.setBounds(170, 50, 200, 50);
        loginButton.setBounds(190, 200, 100, 35);
        registerButton.setBounds(190, 270, 100, 35);


        panel.add(designPanel1);
        panel.add(designPanel2);
        panel.add(designPanel3);
        panel.add(designPanel4);
        panel.add(welcomeMess);
        panel.add(loginButton);
        panel.add(registerButton);

        add(panel);

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }


    //        this method should be rewritten to save data of the registered user in the ArrayList


    //        this method is not working as it should


}