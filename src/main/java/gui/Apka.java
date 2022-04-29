package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Apka extends JFrame {
    JMenuBar menuBar;
    JMenu menuWidget1, menuWidget2;

    public Apka() throws HeadlessException {
        setLayout(null);
        setTitle("WindowTitle");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        newMenuBar();

        newMenu();

        newToolBar();

        JPanel jPanel = new JPanel();
        Border blackline = BorderFactory.createTitledBorder("PanelCaption");
        jPanel.setBorder(blackline);
        jPanel.setBounds(0,20,getWidth(),getHeight()-20);
        jPanel.setLayout(null);
        add(jPanel);

        JPanel jPanel2 = new JPanel();
        Border blackline2 = BorderFactory.createTitledBorder("Panel");
        jPanel2.setBorder(blackline2);
        jPanel2.setBounds(20,20,200,300);
        jPanel.add(jPanel2);
        jPanel2.setLayout(null);

        DefaultListModel<String> l = new DefaultListModel<>();
        l.addElement("Item1");
        l.addElement("Item2");
        l.addElement("Item3");
        l.addElement("Item4");
        l.addElement("Item5");
        JList<String> list = new JList<>(l);
        list.setBounds(20,15,80,260);
        jPanel2.add(list);

        JRadioButton jRadioButton = new JRadioButton("RadioButton");
        jRadioButton.setBounds(95,15,100,20);
        jPanel2.add(jRadioButton);

JRadioButton jRadioButton2 = new JRadioButton("RadioButton2");
        jRadioButton2.setBounds(95,40,100,20);
        jPanel2.add(jRadioButton2);

JRadioButton jRadioButton3 = new JRadioButton("RadioButton3");
        jRadioButton3.setBounds(95,60,100,20);
        jPanel2.add(jRadioButton3);

JRadioButton jRadioButton4 = new JRadioButton("InactiveRadio");
        jRadioButton4.setBounds(95,80,100,20);
        jRadioButton4.setEnabled(false);
        jPanel2.add(jRadioButton4);

        JButton jButton = new JButton("Button");
        jButton.setBounds(110,230,90,20);
        jPanel2.add(jButton);

        JTextField jTextField = new JTextField("TextField");
        jTextField.setBounds(10, 350, 200, 20);
        jPanel.add(jTextField);

        JPasswordField jPasswordField = new JPasswordField("password");
        jPasswordField.setBounds(10, 370, 200, 20);

        jPanel.add(jPasswordField);

        JComboBox tytuly = new JComboBox();
        tytuly.setBounds(10, 390, 200, 20);
        jPanel.add(tytuly);

        JTabbedPane jTabbedPane = new JTabbedPane();
        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(null);
        jPanel1.setBounds(0,0,getWidth(), getHeight());
        JPanel jPanel3 = new JPanel();
        jPanel3.setBounds(0,0,getWidth(), getHeight());



        jTabbedPane.addTab("SelectedTab",null,jPanel1,
                "Does nothing");
        jTabbedPane.addTab("OtherTab",null,jPanel3,
                "Does nothing");

        jTabbedPane.setBounds(300,40,400,300);
        jPanel.add(jTabbedPane);



        JCheckBox jCheckBox = new JCheckBox("UnCheckedCheckBox");
        JCheckBox jCheckBox2 = new JCheckBox("CheckedCheckBox");
        JCheckBox jCheckBox3 = new JCheckBox("InactiveCheckBox");
        jCheckBox3.setEnabled(false);

        jCheckBox.setBounds(10,10,160,20);
        jCheckBox2.setBounds(10,30,160,30);
        jCheckBox3.setBounds(10,50,160,60);

        jPanel1.add(jCheckBox);
        jPanel1.add(jCheckBox2);
        jPanel1.add(jCheckBox3);

        JTextArea jTextArea = new JTextArea("TextArea");
        jTextArea.setBounds(300,400,500,200);
        jPanel.add(jTextArea);

        JSlider jSlider = new JSlider(JSlider.HORIZONTAL);
        jSlider.setBounds(10, 200, 300, 40);
        jPanel1.add(jSlider);




    }

    private void newToolBar() {
        JToolBar jToolBar1 = new JToolBar();
        JButton jButton = new JButton("ToolbarButton");
        jToolBar1.add(jButton);
        menuBar.add(jToolBar1);
        JCheckBox jCheckBox = new JCheckBox("ToolbarCheckBox");
        menuBar.add(jCheckBox);
    }

    private void newMenu() {
        menuWidget1 = new JMenu("MenuWidget1");
        menuWidget2 = new JMenu("MenuWidget2");
        menuBar.add(menuWidget1);
        menuBar.add(menuWidget2);
    }

    private void newMenuBar() {
        menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, getWidth(), 500);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        Apka apka = new Apka();
        apka.setVisible(true);
    }


    //tabpainy
    //chechboxy
    //
}
