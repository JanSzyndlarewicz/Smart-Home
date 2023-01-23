package View;
import Controller.HomeToGui;
import Device.Device;
import Serialization.*;
import User.UserLoginBase;

import static Controller.HomeToGui.ShowProperties;
import static Controller.HomeToGui.routineCreationCheck;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class MainFrame extends javax.swing.JFrame {

    private void hideAll() {

        for (int i = 0; i < LabelList.size(); i++) {
            SliderList.get(i).setVisible(false);
        }
        for (int i = 0; i < SliderValues.size(); i++) {
            SliderValues.get(i).setVisible(false);
        }
        for (int i = 0; i < LabelList.size(); i++) {
            LabelList.get(i).setVisible(false);
        }
        for (int i = 0; i < ChBoxList.size(); i++) {
            ChBoxList.get(i).setVisible(false);
        }
    }
    public void refreshLocList(){
        LOCATION.setModel(new DefaultComboBoxModel<>(UserLoginBase.getCurrentUser().getHome().getLocationList().toArray(new String[UserLoginBase.getCurrentUser().getHome().getLocationList().size()])));
    }

    private void setSidePanelDevice(Device device) {
        hideAll();
        INDEX.setText(String.valueOf(DeviceTable.getSelectedRow()));
        NAME.setText(device.getAlias());
        String str = device.getClass().getName();
        String result[] = str.split("\\.");
        TYPE.setText(result[result.length - 1]);
        ShowProperties(device, ChBoxList, SliderList, LabelList);
        LOCATION.setSelectedItem(device.getLocation());
    }


    private void DeviceTableMousePressed(java.awt.event.MouseEvent evt) {
        SidePanel.removeAll();
        setSidePanelDevice(UserLoginBase.getCurrentUser().getHome().getDevice(DeviceTable.getSelectedRow()));
        SidePanel.add(DeviceSidePanel);
        SidePanel.repaint();
        SidePanel.revalidate();

        //Ustawia aktualne lokalizacje w comboboxie po prawej stronie
        // TODO add your handling code here:
    }


    private ArrayList<JSlider> SliderList = new ArrayList<>();
    private ArrayList<JLabel> LabelList = new ArrayList<>();
    private ArrayList<JLabel> SliderValues = new ArrayList<>();
    private ArrayList<JCheckBox> ChBoxList = new ArrayList<>();

    public static void RefreshTableData(ArrayList<Device> devices) {
        DeviceTable.setModel(new javax.swing.table.DefaultTableModel(
                DataConverter.returnDevTabFormat(devices),
                new String[]{
                        "ID", "NAME", "LOCATION"
                }
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

    }

    private void addComponents() {
        SliderValues.add(ValueLabel1);
        SliderValues.add(ValueLabel2);
        SliderValues.add(ValueLabel3);
        SliderValues.add(ValueLabel4);
        SliderValues.add(ValueLabel5);
        SliderValues.add(ValueLabel6);
        SliderList.add(jSlider1);
        SliderList.add(jSlider2);
        SliderList.add(jSlider3);
        SliderList.add(jSlider4);
        SliderList.add(jSlider5);
        SliderList.add(jSlider6);
        LabelList.add(SLabel1);
        LabelList.add(SLabel2);
        LabelList.add(SLabel3);
        LabelList.add(SLabel4);
        LabelList.add(SLabel5);
        LabelList.add(SLabel6);
        ChBoxList.add(jCheckBox1);
        ChBoxList.add(jCheckBox2);
        ChBoxList.add(jCheckBox3);
        ChBoxList.add(jCheckBox4);

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
        jCheckBox1 = new javax.swing.JCheckBox();
        INDEX = new javax.swing.JTextField();
        TYPE = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        LOCATION = new JComboBox(UserLoginBase.getCurrentUser().getHome().getLocationList().toArray(new String[UserLoginBase.getCurrentUser().getHome().getLocationList().size()]));
        SaveButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        NAME = new javax.swing.JTextField();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jSlider1 = new javax.swing.JSlider();
        SLabel1 = new javax.swing.JLabel();
        ValueLabel1 = new javax.swing.JLabel();
        jSlider2 = new javax.swing.JSlider();
        SLabel2 = new javax.swing.JLabel();
        ValueLabel2 = new javax.swing.JLabel();
        jSlider3 = new javax.swing.JSlider();
        SLabel3 = new javax.swing.JLabel();
        ValueLabel3 = new javax.swing.JLabel();
        jSlider4 = new javax.swing.JSlider();
        SLabel4 = new javax.swing.JLabel();
        ValueLabel4 = new javax.swing.JLabel();
        jSlider5 = new javax.swing.JSlider();
        SLabel5 = new javax.swing.JLabel();
        ValueLabel5 = new javax.swing.JLabel();
        jSlider6 = new javax.swing.JSlider();
        SLabel6 = new javax.swing.JLabel();
        ValueLabel6 = new javax.swing.JLabel();
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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        DeviceTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
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
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                                .addContainerGap())
        );

        SidePanel.setLayout(new java.awt.CardLayout());

        jCheckBox1.setText("jCheckBox1");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("INDEX");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("NAME");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("LOCATION");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("TYPE");

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 20)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("DEVICE PANEL");

        SaveButton.setText("SAVE");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("CANCEL");

        jCheckBox2.setText("jCheckBox1");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("jCheckBox1");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox4.setText("jCheckBox1");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        SLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SLabel1.setText("jLabel1");

        ValueLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ValueLabel1.setText("jLabel2");

        SLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SLabel2.setText("jLabel1");

        ValueLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ValueLabel2.setText("jLabel2");

        SLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SLabel3.setText("jLabel1");

        ValueLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ValueLabel3.setText("jLabel2");

        SLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SLabel4.setText("jLabel1");

        ValueLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ValueLabel4.setText("jLabel2");

        SLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SLabel5.setText("jLabel1");

        ValueLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ValueLabel5.setText("jLabel2");

        SLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SLabel6.setText("jLabel1");

        ValueLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ValueLabel6.setText("jLabel2");

        javax.swing.GroupLayout DeviceSidePanelLayout = new javax.swing.GroupLayout(DeviceSidePanel);
        DeviceSidePanel.setLayout(DeviceSidePanelLayout);
        DeviceSidePanelLayout.setHorizontalGroup(
                DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeviceSidePanelLayout.createSequentialGroup()
                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(jSlider1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DeviceSidePanelLayout.createSequentialGroup()
                                                                        .addContainerGap()
                                                                        .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(ValueLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(SLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(jSlider4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(ValueLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(SLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(71, 71, 71)
                                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(jSlider2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(ValueLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(SLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jSlider5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(ValueLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(SLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(jSlider3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(ValueLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(SLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jSlider6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(ValueLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(SLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(53, 53, 53))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeviceSidePanelLayout.createSequentialGroup()
                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(SaveButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(CancelButton))
                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(INDEX, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(TYPE, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(42, 42, 42)
                                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(53, 53, 53)
                                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(LOCATION, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(25, 25, 25))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeviceSidePanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(206, 206, 206))
        );
        DeviceSidePanelLayout.setVerticalGroup(
                DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                        .addComponent(jLabel4)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(INDEX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                        .addComponent(jLabel5)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(NAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                        .addComponent(jLabel7)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(TYPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(LOCATION, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(99, 99, 99)
                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                .addComponent(jCheckBox1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jCheckBox2))
                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                .addComponent(jCheckBox3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jCheckBox4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                .addComponent(SLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jSlider3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ValueLabel3))
                                        .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(DeviceSidePanelLayout.createSequentialGroup()
                                                        .addComponent(SLabel1)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(ValueLabel1))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeviceSidePanelLayout.createSequentialGroup()
                                                        .addComponent(SLabel2)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(ValueLabel2))))
                                .addGap(34, 34, 34)
                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeviceSidePanelLayout.createSequentialGroup()
                                                .addComponent(SLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jSlider4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ValueLabel4))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeviceSidePanelLayout.createSequentialGroup()
                                                .addComponent(SLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jSlider6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ValueLabel6))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeviceSidePanelLayout.createSequentialGroup()
                                                .addComponent(SLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jSlider5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ValueLabel5)))
                                .addGap(58, 58, 58)
                                .addGroup(DeviceSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CancelButton)
                                        .addComponent(SaveButton))
                                .addGap(19, 19, 19))
        );

        SidePanel.add(DeviceSidePanel, "card2");

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
                                .addGap(0, 628, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(311, Short.MAX_VALUE)
                                        .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    }

    private void DeviceTableMouseClicked(java.awt.event.MouseEvent evt) {
    }


    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        HomeToGui.devicePanelToBackend(NAME, LOCATION, SliderList, LabelList, ChBoxList, DeviceTable);

        RefreshTableData(UserLoginBase.getCurrentUser().getHome().getDeviceList());
    }



    private void AddLocMButtonActionPerformed(java.awt.event.ActionEvent evt) {
       new AddLocation(this).setVisible(true);
    }

    private void MainPanelMButtonActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void AccountSetMButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(UserSettingsFrame.getUserPanel() == null || !UserSettingsFrame.getUserPanel().isShowing()){
            new UserSettingsFrame(this).setVisible(true);
        }
    }

    private void DelLocMButtonActionPerformed(java.awt.event.ActionEvent evt) {
      new DeleteLocationFrame(this).setVisible(true);
    }

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void AddRoutMButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(!AddRoutineFrame.getIsOpen() &&  routineCreationCheck()){
            new AddRoutineFrame().setVisible(true);
            AddRoutineFrame.setIsOpen(true);
        }

    }

    private void DelDevMButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(DeleteDeviceFrame.getPanel() == null || !DeleteDeviceFrame.getPanel().isShowing()){
            new DeleteDeviceFrame().setVisible(true);
        }

    }

    private void DelRoutMButtonActionPerformed(java.awt.event.ActionEvent evt) {
       new DeleteRoutineFrame().setVisible(true);
    }
    private void AddDevMButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(AddDeviceFrame.getPanel() == null || !AddDeviceFrame.getPanel().isShowing()){
            new AddDeviceFrame(this).setVisible(true);
        }

    }
    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    public String[] locationStringList(){
        //Funkcja zwacająca tablicę wszystkich lokalizacji (które są przypisane do jakichś urządzeń) w aktualnym domu (potrzebne do comboboxa w panelu Device Property)
        ArrayList<String> locationList = HomeToGui.uniqueLocationsFromHome();
        locationList.add(0, UserLoginBase.getCurrentUser().getHome().getDeviceList().get(DeviceTable.getSelectedRow()).getLocation());

        for(int i=1; i<locationList.size(); i++){
            if(Objects.equals(locationList.get(i), UserLoginBase.getCurrentUser().getHome().getDeviceList().get(DeviceTable.getSelectedRow()).getLocation())){
                locationList.remove(i);
                break;
            }
        }

        String [] x = new String[locationList.size()];
        for(int i=0; i<locationList.size(); i++){
            x[i] = locationList.get(i);
        }

        return x;
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        SerializationFunc.serialize();
    }

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
    private javax.swing.JComboBox<String> LOCATION;
    private javax.swing.JMenuItem MainPanelMButton;
    private javax.swing.JTextField NAME;
    private javax.swing.JLabel SLabel1;
    private javax.swing.JLabel SLabel2;
    private javax.swing.JLabel SLabel3;
    private javax.swing.JLabel SLabel4;
    private javax.swing.JLabel SLabel5;
    private javax.swing.JLabel SLabel6;
    private javax.swing.JButton SaveButton;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JTextField TYPE;
    private javax.swing.JPanel TablePanel;
    private javax.swing.JLabel ValueLabel1;
    private javax.swing.JLabel ValueLabel2;
    private javax.swing.JLabel ValueLabel3;
    private javax.swing.JLabel ValueLabel4;
    private javax.swing.JLabel ValueLabel5;
    private javax.swing.JLabel ValueLabel6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
}
