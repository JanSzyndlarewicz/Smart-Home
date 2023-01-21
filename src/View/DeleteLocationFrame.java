package View;

import Controller.HomeToGui;
import Device.Device;
import User.UserLoginBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteLocationFrame extends JFrame {
    private JComboBox LocList;
    private JLabel deviceListLabel;
    private JButton deleteButton;
    private static JPanel panel;
    public DeleteLocationFrame() {
        initialize();
    }
    public void initialize() {
        LocList = new JComboBox(UserLoginBase.getCurrentUser().getHome().getLocationList().toArray(new String[UserLoginBase.getCurrentUser().getHome().getLocationList().size()]));
        deviceListLabel = new JLabel("Device List");
        deleteButton = new JButton("Delete");
        panel = new JPanel();


        deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                deleteLocation();
            }

        });
        deviceListLabel.setBounds(25,25,100,25);
        LocList.setBounds(25, 50, 100, 25);
        deleteButton.setBounds(275,100,100,25);
        panel.setLayout(null);
        panel.add(deleteButton);
        panel.add(LocList);
        panel.add(deviceListLabel);
        add(panel);


        setSize(425, 200);
        setVisible(true);
    }

    private void deleteLocation() {
        int result = JOptionPane.showConfirmDialog(panel, "Are you sure that you want to delete " + LocList.getSelectedItem(), "Deletion", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(panel, "Location deleted successfully");
            HomeToGui.deleteLocation((String) LocList.getSelectedItem());
            this.dispose();
        }
    }

    public static JPanel getPanel() {
        return panel;
    }
}
