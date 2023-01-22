package View;

import Controller.HomeToGui;
import Device.Device;
import User.UserLoginBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteRoutineFrame extends JFrame {
    private JComboBox routineList;
    private JLabel routineListLabel;
    private JButton deleteButton;
    private static JPanel panel;
    public DeleteRoutineFrame() {
        initialize();
    }
    public void initialize() {
        routineList = new JComboBox(HomeToGui.getRoutineList().toArray());
        routineListLabel = new JLabel("Routine List");
        deleteButton = new JButton("Delete");
        panel = new JPanel();


        deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRoutine();
            }

        });
        routineListLabel.setBounds(25,25,100,25);
        routineList.setBounds(25, 50, 100, 25);
        deleteButton.setBounds(275,100,100,25);
        panel.setLayout(null);
        panel.add(deleteButton);
        panel.add(routineList);
        panel.add(routineListLabel);
        add(panel);


        setSize(425, 200);
        setVisible(true);
    }

    private void deleteRoutine() {
        int result = JOptionPane.showConfirmDialog(panel, "Are you sure that you want to delete " + routineList.getSelectedItem(), "Deletion", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(panel, "Routine deleted successfully");
            HomeToGui.deleteRoutine((String) routineList.getSelectedItem());
            this.dispose();
        }
    }

    public static JPanel getPanel() {
        return panel;
    }
}
