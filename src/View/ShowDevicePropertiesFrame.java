package View;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;


public class ShowDevicePropertiesFrame {

    private JFrame tableJFrame;


    public ShowDevicePropertiesFrame() {
        initialize();
    }

    public void initialize(){

        // create a JFrame
        tableJFrame  = new JFrame();

        tableJFrame.setTitle("Smart Home Device Properties");
        tableJFrame.setVisible(true);
        tableJFrame.setSize(500, 500);
        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();

        tableJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        tableJFrame.getContentPane().add(BorderLayout.WEST, panelLeft);

        tableJFrame.getContentPane().add(BorderLayout.EAST, panelRight);



        String data[][] = {{"Gas Sensor"}, {"Smoke Sensor"}, {"Shutters"}, {"Gate"}, {"Lock"}};
        String column[] = {"Device"};
        final JTable devicePropertiesTable = new JTable(data, column)
        {
            // that code below prevents user from editing content in table cells
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        devicePropertiesTable.setCellSelectionEnabled(true);
        ListSelectionModel select = devicePropertiesTable.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String Data = null;
                int[] row = devicePropertiesTable.getSelectedRows();
                int[] columns = devicePropertiesTable.getSelectedColumns();

                for(int i = 0; i < row.length; i++){
                    for (int j = 0; j < columns.length; j++) {
                        Data = (String)devicePropertiesTable.getValueAt(row[i], columns[j]);

                    }
                }
                JLabel chosenDeviceText = new JLabel("Device selected: ");
                JLabel chosenDevice = new JLabel(Data);
                panelRight.add(chosenDeviceText);
                panelRight.add(chosenDevice);



            }

        });

        JScrollPane sp = new JScrollPane(devicePropertiesTable);

        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));

        panelLeft.add(sp);
        panelLeft.setSize(300, 300);
        panelLeft.setVisible(true);



        panelRight.setSize(400, 400);
        tableJFrame.setResizable(true);
        tableJFrame.pack();
    }





}
