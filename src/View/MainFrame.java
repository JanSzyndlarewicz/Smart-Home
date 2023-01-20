/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Device.Device;
import User.UserLoginBase;

import javax.swing.*;
import java.util.ArrayList;

public class MainFrame extends javax.swing.JFrame {

    private void hideAll(){
        for (int i = 0; i < LabelList.size(); i++) {
            SliderList.get(i).setVisible(false);
        }
        for (int i = 0; i < LabelList.size(); i++) {
            LabelList.get(i).setVisible(false);
        }
        for (int i = 0; i < ChBoxList.size(); i++) {
            ChBoxList.get(i).setVisible(false);
        }
    }

//    private void enableChBox()
    private void setSidePanelDevice(Device device){

        INDEX.setText(String.valueOf(DeviceTable.getSelectedRow()));
        NAME.setText(device.getAlias());
//        LOCATION.setSelectedItem();
        String str = device.getClass().getName();
        String result[] = str.split("\\.");
        TYPE.setText(result[result.length-1]);


    }


    private void DeviceTableMousePressed(java.awt.event.MouseEvent evt) {
        SidePanel.removeAll();
        setSidePanelDevice(UserLoginBase.getCurrentUser().getHome().getDevice(DeviceTable.getSelectedRow()));
        SidePanel.add(DeviceSidePanel);
        SidePanel.repaint();
        SidePanel.revalidate();
        // TODO add your handling code here:
    }




    private ArrayList<JSlider> SliderList =new ArrayList<>();
    private ArrayList<JLabel> LabelList =new ArrayList<>();
    private ArrayList<JCheckBox> ChBoxList = new ArrayList<>();
    public static void RefreshTableData(ArrayList<Device> devices){
        DeviceTable.setModel(new javax.swing.table.DefaultTableModel(
                DataConverter.returnDevTabFormat(devices),
                new String [] {
                        "ID", "NAME","LOCATION"
                }
        ){public boolean isCellEditable(int row, int column){return false;}});
    }

    private void addComponents(){
        SliderList.add(jSlider1);
        SliderList.add(jSlider2);
        SliderList.add(jSlider3);
        SliderList.add(jSlider4);
        SliderList.add(jSlider5);
        SliderList.add(jSlider6);
        LabelList.add(SLabel1);
        LabelList.add(Slabel2);
        LabelList.add(SLabel3);
        LabelList.add(SLabel4);
        LabelList.add(SLabel5);
        LabelList.add(SLabel6);
        ChBoxList.add(jCheckBox2);
        ChBoxList.add(jCheckBox4);
        ChBoxList.add(jCheckBox3);
        ChBoxList.add(jCheckBox1);

    }
    public MainFrame() {
        initComponents();
        addComponents();
        hideAll();
    }

    private void initComponents() {

        TablePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DeviceTable = new javax.swing.JTable();
        SidePanel = new javax.swing.JPanel();
        DeviceSidePanel = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        SLabel1 = new javax.swing.JLabel();
        Slabel2 = new javax.swing.JLabel();
        jSlider2 = new javax.swing.JSlider();
        SLabel3 = new javax.swing.JLabel();
        jSlider3 = new javax.swing.JSlider();
        INDEX = new javax.swing.JTextField();
        NAME = new javax.swing.JTextField();
        TYPE = new javax.swing.JTextField();
        IndexLabel = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        LocationLabel = new javax.swing.JLabel();
        TypeLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        LOCATION = new javax.swing.JComboBox<>();
        jSlider4 = new javax.swing.JSlider();
        SLabel5 = new javax.swing.JLabel();
        jSlider5 = new javax.swing.JSlider();
        SLabel4 = new javax.swing.JLabel();
        SLabel6 = new javax.swing.JLabel();
        jSlider6 = new javax.swing.JSlider();
        SaveButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        MainSidePanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MainPanelMButton = new javax.swing.JMenuItem();
        AccountSetMButton = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        AddDevMButton = new javax.swing.JMenuItem();
        AddRoutMButton = new javax.swing.JMenuItem();
        AddLocMButton = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        DelDevMButton = new javax.swing.JMenuItem();
        DelRoutMButton = new javax.swing.JMenuItem();
        DelLocMButton = new javax.swing.JMenuItem();

        INDEX.setEditable(false);
        TYPE.setEditable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        DeviceTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ){public boolean isCellEditable(int row, int column){return false;}});
        DeviceTable.setFocusable(false);
        DeviceTable.getTableHeader().setReorderingAllowed(false);
        DeviceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeviceTableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DeviceTableMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(DeviceTable);

        javax.swing.GroupLayout TablePanelLayout = new javax.swing.GroupLayout(TablePanel);
        TablePanel.setLayout(TablePanelLayout);
        TablePanelLayout.setHorizontalGroup(
                TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TablePanelLayout.createSequentialGroup()
                                .addContainerGap(14, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        TablePanelLayout.setVerticalGroup(
                TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TablePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                                .addContainerGap())
        );

        SidePanel.setLayout(new java.awt.CardLayout());

        jCheckBox1.setText("jCheckBox1");

        jCheckBox2.setText("jCheckBox1");

        jCheckBox3.setText("jCheckBox1");

        jCheckBox4.setText("jCheckBox1");

        SLabel1.setText("SLabel1");

        Slabel2.setText("jLabel1");

        SLabel3.setText("jLabel1");

        INDEX.setText("INDEX");

        NAME.setText("jTextField2");

        TYPE.setText("jTextField4");

        IndexLabel.setText("INDEX");

        NameLabel.setText("NAME");

        LocationLabel.setText("LOCATION");

        TypeLabel.setText("TYPE");

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 20)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("DEVICE PANEL");

        LOCATION.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        SLabel5.setText("jLabel1");

        SLabel4.setText("jLabel1");

        SLabel6.setText("jLabel1");

        SaveButton.setText("SAVE");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("CANCEL");

        javax.swing.GroupLayout DeviceSidePanelLayout = new javax.swing.GroupLayout(DeviceSidePanel);
        DeviceSidePanel.setLayout(DeviceSidePanelLayout);
        DeviceSidePanelLayout.setHorizontalGroup(
                DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jCheckBox2)
                                                        .addComponent(INDEX, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(34, 34, 34)
                                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jCheckBox4)
                                                        .addComponent(NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(37, 37, 37))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeviceSidePanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(SaveButton)
                                                .addGap(18, 18, 18)))
                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                .addComponent(LOCATION, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(TYPE, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(CancelButton)
                                                        .addComponent(jCheckBox3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jCheckBox1)))
                                .addGap(36, 36, 36))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeviceSidePanelLayout.createSequentialGroup()
                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSlider4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                                .addGap(55, 55, 55)
                                                                .addComponent(SLabel4)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(SLabel5)
                                                .addGap(99, 99, 99))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DeviceSidePanelLayout.createSequentialGroup()
                                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                                .addGap(61, 61, 61)
                                                                .addComponent(SLabel1)))
                                                .addGap(43, 43, 43)
                                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                                .addGap(55, 55, 55)
                                                                .addComponent(Slabel2))
                                                        .addComponent(jSlider5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)))
                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSlider6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSlider3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(SLabel6)
                                                        .addComponent(SLabel3))))
                                .addGap(24, 24, 24))
                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(IndexLabel)
                                .addGap(96, 96, 96)
                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                .addComponent(NameLabel)
                                                .addGap(87, 87, 87)
                                                .addComponent(LocationLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(TypeLabel)
                                                .addGap(66, 66, 66))))
        );
        DeviceSidePanelLayout.setVerticalGroup(
                DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(IndexLabel)
                                        .addComponent(NameLabel)
                                        .addComponent(LocationLabel)
                                        .addComponent(TypeLabel))
                                .addGap(18, 18, 18)
                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(INDEX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TYPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LOCATION, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56)
                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCheckBox2)
                                        .addComponent(jCheckBox4)
                                        .addComponent(jCheckBox3)
                                        .addComponent(jCheckBox1))
                                .addGap(81, 81, 81)
                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                .addComponent(SLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                .addComponent(Slabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                .addComponent(SLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSlider3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                .addComponent(SLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSlider4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                .addComponent(SLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSlider5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                .addComponent(SLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSlider6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CancelButton)
                                        .addComponent(SaveButton))
                                .addGap(18, 18, 18))
        );

        SidePanel.add(DeviceSidePanel, "card2");

        javax.swing.GroupLayout MainSidePanelLayout = new javax.swing.GroupLayout(MainSidePanel);
        MainSidePanel.setLayout(MainSidePanelLayout);
        MainSidePanelLayout.setHorizontalGroup(
                MainSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 550, Short.MAX_VALUE)
        );
        MainSidePanelLayout.setVerticalGroup(
                MainSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 476, Short.MAX_VALUE)
        );

        SidePanel.add(MainSidePanel, "card3");

        jMenu1.setText("Smart Home");

        MainPanelMButton.setText("Main Panel");
        MainPanelMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainPanelMButtonActionPerformed(evt);
            }
        });
        jMenu1.add(MainPanelMButton);

        AccountSetMButton.setText("Account settings");
        AccountSetMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountSetMButtonActionPerformed(evt);
            }
        });
        jMenu1.add(AccountSetMButton);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Add");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        AddDevMButton.setText("Device");
        AddDevMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddDevMButtonActionPerformed(evt);
            }
        });
        jMenu2.add(AddDevMButton);

        AddRoutMButton.setText("Routine");
        AddRoutMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRoutMButtonActionPerformed(evt);
            }
        });
        jMenu2.add(AddRoutMButton);

        AddLocMButton.setText("Location");
        AddLocMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddLocMButtonActionPerformed(evt);
            }
        });
        jMenu2.add(AddLocMButton);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Delete");

        DelDevMButton.setText("Device");
        DelDevMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelDevMButtonActionPerformed(evt);
            }
        });
        jMenu3.add(DelDevMButton);

        DelRoutMButton.setText("Routine");
        DelRoutMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelRoutMButtonActionPerformed(evt);
            }
        });
        jMenu3.add(DelRoutMButton);

        DelLocMButton.setText("Location");
        DelLocMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelLocMButtonActionPerformed(evt);
            }
        });
        jMenu3.add(DelLocMButton);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(TablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 555, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(314, Short.MAX_VALUE)
                                        .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap()))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(TablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap()))
        );

        pack();
    }// </editor-fold>
    private void DeviceTableMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }



    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void AddLocMButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void MainPanelMButtonActionPerformed(java.awt.event.ActionEvent evt) {
        SidePanel.removeAll();
        SidePanel.add(MainSidePanel);
        SidePanel.repaint();
        SidePanel.revalidate();  // TODO add your handling code here:
    }

    private void AccountSetMButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //Zablokowanie wyświetlania kilku tych samych okien
        if(UserSettingsFrame.getUserPanel() == null || !UserSettingsFrame.getUserPanel().isShowing()){
            new UserSettingsFrame(this).setVisible(true);
        }
    }

    private void DelLocMButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void AddRoutMButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //Zablokowanie wyświetlania kilku tych samych okien
        if(!AddRoutineFrame.getIsOpen()){
            new AddRoutineFrame().setVisible(true);
            AddRoutineFrame.setIsOpen(true);
        }

    }

    private void DelDevMButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //Zablokowanie wyświetlania kilku tych samych okien
        if(DeleteDeviceFrame.getPanel() == null || !DeleteDeviceFrame.getPanel().isShowing()){
            new DeleteDeviceFrame().setVisible(true);
        }

    }

    private void DelRoutMButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void AddDevMButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //Zablokowanie wyświetlania kilku tych samych okien
        if(AddDeviceFrame.getPanel() == null || !AddDeviceFrame.getPanel().isShowing()){
            new AddDeviceFrame().setVisible(true);
        }

        // TODO add your handling code here:
    }


    // Variables declaration - do not modify
    private javax.swing.JMenuItem AccountSetMButton;
    private javax.swing.JMenuItem AddDevMButton;
    private javax.swing.JMenuItem AddLocMButton;
    private javax.swing.JMenuItem AddRoutMButton;
    private javax.swing.JButton CancelButton;
    private javax.swing.JMenuItem DelDevMButton;
    private javax.swing.JMenuItem DelLocMButton;
    private javax.swing.JMenuItem DelRoutMButton;
    private javax.swing.JPanel DeviceSidePanel;
    private static javax.swing.JTable DeviceTable;
    private javax.swing.JTextField INDEX;
    private javax.swing.JLabel IndexLabel;
    private javax.swing.JComboBox<String> LOCATION;
    private javax.swing.JLabel LocationLabel;
    private javax.swing.JMenuItem MainPanelMButton;
    private javax.swing.JPanel MainSidePanel;
    private javax.swing.JTextField NAME;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JLabel SLabel1;
    private javax.swing.JLabel SLabel3;
    private javax.swing.JLabel SLabel4;
    private javax.swing.JLabel SLabel5;
    private javax.swing.JLabel SLabel6;
    private javax.swing.JButton SaveButton;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JLabel Slabel2;
    private javax.swing.JTextField TYPE;
    private javax.swing.JPanel TablePanel;
    private javax.swing.JLabel TypeLabel;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JSlider jSlider3;
    private javax.swing.JSlider jSlider4;
    private javax.swing.JSlider jSlider5;
    private javax.swing.JSlider jSlider6;
    // End of variables declaration
}
