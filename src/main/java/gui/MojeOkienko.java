package gui;

import javax.swing.JFrame;

public class MojeOkienko extends JFrame {
    public MojeOkienko() {
        setSize(300,300);
        setTitle("Moje okienko");
    }

    public static void main(String[] args) {
        MojeOkienko mojeOkienko = new MojeOkienko();
        mojeOkienko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mojeOkienko.setVisible(true);
    }
}

