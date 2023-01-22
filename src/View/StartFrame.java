package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame extends JFrame {
    private JPanel panel;
    private JLabel loginLabel;
    private JLabel registerLabel;
    private JButton loginButton;
    private JButton registerButton;

    public StartFrame(){
        initialize();
        setComponents();
        setVisible(true);
    }

    public void initialize(){
        panel = new JPanel();
        loginButton = new JButton();
        registerButton = new JButton();

    }

    public void setComponents(){
        loginButton.setText("Login");
        registerButton.setText("Register");
        loginButton.setBounds(40, 100, 150, 90);
        registerButton.setBounds(40, 250, 150, 90);
        panel.setLayout(null);
        panel.setBackground(new Color(223, 237, 245));
        panel.add(registerButton);
        panel.add(loginButton);
        add(panel);
        registerButton.addActionListener(new GoToRegisterFrame());
        loginButton.addActionListener(new GoToLoginFrame());
        setSize(250, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    private class GoToRegisterFrame implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            RegisterFrame registerFrame = new RegisterFrame();
            dispose();
        }
    }

    private class GoToLoginFrame implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            LoginFrame loginFrame = new LoginFrame();
            dispose();
        }
    }

}
