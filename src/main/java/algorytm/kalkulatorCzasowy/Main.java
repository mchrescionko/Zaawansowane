package algorytm.kalkulatorCzasowy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Month;

public class Main extends JFrame implements ActionListener {

    JButton jButton;
    JTextField jTextField;
    JTextField jTextField2;
    JTextField jTextField3;
    JLabel jLabel2;

    public Main() {
        setLayout(null);
        setTitle("kalkulator wieku");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,800);
        gui();

    }

    public void gui(){
        jTextField = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jButton = new JButton("oblicz");
        JLabel jLabel = new JLabel("dzień");
        JLabel jLabel2 = new JLabel("miesiąc");
        JLabel jLabel3 = new JLabel("rok");

        add(jButton);
        add(jTextField);
        add(jTextField2);
        add(jTextField3);
        add(jLabel);
        add(jLabel2);
        add(jLabel3);

        jButton.setBounds(200,150,100,20);
        jTextField.setBounds(50,50,100,20);
        jTextField2.setBounds(200,50,100,20);
        jTextField3.setBounds(350,50,100,20);

        jLabel.setBounds(50,20,150,20);
        jLabel2.setBounds(200,20,150,20);
        jLabel3.setBounds(350,20,150,20);

        jButton.addActionListener(this);
    }

    public int liczbaDni(LocalDate dataNarodzin){
        int liczbaDni = 0;
        LocalDate dataObecna = LocalDate.now();
        while(dataNarodzin.getDayOfMonth()!=dataObecna.getDayOfMonth()){
            liczbaDni++;
            dataNarodzin = dataNarodzin.plusDays(1L);
        }
        return liczbaDni;
    }


    public static void main(String[] args) {
        //LocaleDate, LocaleTime, LocaleDateTime

        Main main = new Main();
        main.setVisible(true);


        LocalDate localDateKlienta = LocalDate.of(1992, 02, 29);
        LocalDate localDateObecna = LocalDate.now();


        System.out.println(localDateKlienta);
        System.out.println(localDateObecna);

        Month monthOfBirth = localDateKlienta.getMonth();
        int year = localDateKlienta.getYear();
        int dayOfBirth = localDateKlienta.getDayOfMonth();

        System.out.println("co to jest: " + localDateKlienta.getMonth().compareTo(localDateObecna.getMonth()));


        int liczbaDni = main.liczbaDni(localDateKlienta);
        int liczbaMiesiecy= main.liczbaMiesiecy(localDateKlienta);
        int liczbaLat=main.liczbaLat(localDateKlienta);

        System.out.println("liczba dni: "+liczbaDni);
        System.out.println("liczba miesiecy: "+liczbaMiesiecy);
        System.out.println("liczba lat: "+liczbaLat);


    }

    public int liczbaMiesiecy(LocalDate dataNarodzin){
        int liczbaMiesiecy = 0;
        LocalDate dataObecna = LocalDate.now();
        while(dataNarodzin.getMonth().compareTo(dataObecna.getMonth())!=0){
            liczbaMiesiecy++;
            dataNarodzin = dataNarodzin.plusMonths(1l);
        }
        return liczbaMiesiecy;
    }

    public int liczbaLat(LocalDate dataNarodzin){
        LocalDate dataObecna = LocalDate.now();
        int liczbaLat = 0;
        while(dataNarodzin.getYear()!=dataObecna.getYear()){
            liczbaLat++;
            dataNarodzin = dataNarodzin.plusYears(1l);
        }
        return liczbaLat;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object z = e.getSource();
        if(z==jButton){
            obliczWiek();
        }
    }

    public void obliczWiek(){
        int dzien = Integer.parseInt(jTextField.getText());
        int miesiac = Integer.parseInt(jTextField2.getText());
        int rok = Integer.parseInt(jTextField3.getText());

        LocalDate localDate = LocalDate.of(rok, miesiac, dzien);

        int dzien2 = liczbaDni(localDate);
        int miesiac2 = liczbaMiesiecy(localDate);
        int lata2 = liczbaLat(localDate);
        jLabel2 = new JLabel("masz "+lata2+ " lat, "+miesiac2+ " miesięcy, "+dzien2+ " dni");
        add(jLabel2);
        jLabel2.setBounds(50,300,300,20);
    }

    //31 sierpnia 1996

    public void ktoryDzien(){
        LocalDate data1996 = LocalDate.of(1996, 8, 31);
        LocalDate dataTeraz = LocalDate.now();
        int liczbaDni=0;
        while(dataTeraz!=data1996){
            dataTeraz = dataTeraz.plusDays(1L);
            liczbaDni++;
        }
        System.out.println(liczbaDni%7);
    }


}
