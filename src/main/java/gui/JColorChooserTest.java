package gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class JColorChooser extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JButton bWybierzKolor;
    JMenu menuPlik, menuNarzedzia, menuPomoc, menuOpcje;
    JMenuItem mOtworz, mZapisz, mWyjscie, mNarz1, mNarz2, mOProgramie, mOpcja1;
    JCheckBoxMenuItem chOpcja2;


    public JColorChooser() throws HeadlessException {
        setTitle("Demonstracja JMenuBar");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        menuBar = new JMenuBar();
        menuPlik = new JMenu("Plik");

        mOtworz = new JMenuItem("Otworz", 'O');
        mOtworz.addActionListener(this);

        mZapisz = new JMenuItem("Zapisz");
        mZapisz.addActionListener(this);

        mWyjscie = new JMenuItem("Wyjście");

        mWyjscie.addActionListener(this);
        mWyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));

        menuPlik.add(mOtworz);
        menuPlik.add(mZapisz);
        menuPlik.addSeparator();
        menuPlik.add(mWyjscie);

        menuNarzedzia = new JMenu("Narzedzia");
        mNarz1 = new JMenuItem("Narz1");
        mNarz1.setEnabled(false);
        mNarz2 = new JMenuItem("Narz2");
        menuNarzedzia.add(mNarz1);
        menuNarzedzia.add(mNarz2);

        menuOpcje = new JMenu("Opcje");
        mOpcja1 = new JMenuItem("Opcja 1");
        chOpcja2 = new JCheckBoxMenuItem("Opcja 2");
        menuOpcje.add(mOpcja1);
        menuOpcje.add(chOpcja2);
        menuNarzedzia.add(menuOpcje);


        menuPomoc = new JMenu("Pomoc");
        mOProgramie = new JMenuItem("O programie");
        mOProgramie.addActionListener(this);
        menuPomoc.add(mOProgramie);



        setJMenuBar(menuBar);
        menuBar.add(menuPlik);
        menuBar.add(menuNarzedzia);
        menuBar.add(menuPomoc);

        bWybierzKolor = new JButton("Wybierz kolor");
        bWybierzKolor.setBounds(200,500,150,20);
        add(bWybierzKolor);
        bWybierzKolor.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object z =e.getSource();
        if (z == mWyjscie){
            dispose();
        }
        if(z == mOProgramie){
            JOptionPane.showMessageDialog(this, "Program demonstruje wykorzystanie JMenuBar i JMenu \n cos tam");

        }
        if(z == mOtworz){
            JFileChooser fc = new JFileChooser();
            if(fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                File plik = fc.getSelectedFile();
                JOptionPane.showMessageDialog(null, "Wybrany plik to "+plik.getAbsolutePath());
            }
        }
        if(z == mZapisz){
            JFileChooser fc = new JFileChooser();
            if(fc.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
                File plik = fc.getSelectedFile();
                JOptionPane.showMessageDialog(null, "Wybrany plik to "+plik.getAbsolutePath());
            }
        }
        if(z == mZapisz){
            JFileChooser fc = new JFileChooser();
            if(fc.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
                File plik = fc.getSelectedFile();
                JOptionPane.showMessageDialog(null, "Wybrany plik to "+plik.getAbsolutePath());
            }
        }
        if(z == bWybierzKolor){
            Color wybranyKolor = javax.swing.JColorChooser.showDialog(null, "Wybór koloru", Color.BLUE);
            menuBar.setBackground(wybranyKolor);
        }
    }

    public static void main(String[] args) {
        JColorChooser appMenu = new JColorChooser();
        appMenu.setVisible(true);

    }
}