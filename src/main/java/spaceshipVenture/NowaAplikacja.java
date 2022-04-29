package spaceshipVenture;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class NowaAplikacja extends JPanel implements MouseMotionListener {

    boolean pomiedzyTurami;
    boolean space;
    boolean pauza;
    boolean graWToku;
    Image image;
    Image strzalZdjecie;
    Image image2;
    Image imageMeteoryt;
    Image gif;
    Image zycieZdjecie;
    Image coinZdjecie;
    int liczbaZyc;
    int liczbaCoinow;
    int zycieX;
    int zycieY;
    int liczbaStrzalow;
    int coinX;
    int coinY;
    int imageX;
    int imageY;
    int ominieteMEteoryty;
    int poziom;
    boolean koniec;
    int czas;
    boolean zycieWRuchu;
    boolean nowyCoin;
    boolean nowyStrzal;
    boolean klawisz1;
    boolean klawisz2;
    boolean klawisz3;
    int[] strzalX;
    int[] strzalY;
    int[] tablicaX;
    int[] tablicaY;
    int[] tablicaDY;
    int[] tablicaDX;
    int[] tablicaSzerokosci;
    int liczbaMeteorytow;
    boolean[] aktywneMeteoryty;
    boolean[] aktywneStrzaly;
    Integer[] najlepsiGracze;

    public NowaAplikacja(int liczbaMeteorytow) throws InterruptedException {

        najlepsiGracze = new Integer[10];
        pomocniczyKonstruktor(liczbaMeteorytow, najlepsiGracze);
        liczbaZyc = 0;
        pomiedzyTurami = true;
        graWToku = false;
        Arrays.fill(najlepsiGracze, 0);
        try {
            image = ImageIO.read(new File("statek2.png"));
            image2 = ImageIO.read(new File("statek3.png"));
            imageMeteoryt = ImageIO.read(new File("meteoryt.png"));
            gif = ImageIO.read(new File("gif.gif"));
            zycieZdjecie = ImageIO.read(new File("zycie.png"));
            coinZdjecie = ImageIO.read(new File("coin4.png"));
            strzalZdjecie = ImageIO.read(new File("strzal.png"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        addMouseMotionListener(this);
    }

    public void setPauza(boolean pauza) {
        this.pauza = pauza;
    }

    public void setKlawisz1(boolean klawisz1) {
        this.klawisz1 = klawisz1;
    }

    public void setKlawisz2(boolean klawisz2) {
        this.klawisz2 = klawisz2;
    }

    public void setKlawisz3(boolean klawisz3) {
        this.klawisz3 = klawisz3;
    }

    public void pomocniczyKonstruktor(int liczbaMeteorytow, Integer[] najlepsiGracze) throws InterruptedException {
        Thread.sleep(200);
        ominieteMEteoryty = 0;
        poziom = 1;
        czas = 0;
        liczbaZyc = 1;
        liczbaCoinow = 20;
        liczbaStrzalow = 0;
        pomiedzyTurami = false;
        zycieWRuchu = false;
        nowyCoin = false;
        space = false;
        klawisz2 = false;
        klawisz3 = false;
        klawisz1 = false;
        this.najlepsiGracze = najlepsiGracze;
        this.tablicaX = new int[liczbaMeteorytow];
        this.tablicaY = new int[liczbaMeteorytow];
        this.tablicaDY = new int[liczbaMeteorytow];
        this.tablicaDX = new int[liczbaMeteorytow];
        this.tablicaSzerokosci = new int[liczbaMeteorytow];
        this.aktywneMeteoryty = new boolean[liczbaMeteorytow];
        this.strzalX = new int[4];
        this.strzalY = new int[4];
        this.aktywneStrzaly = new boolean[4];

        this.liczbaMeteorytow = liczbaMeteorytow;
        for (int i = 0; i < liczbaMeteorytow; i++) {
            tworzenieMeteorytu(i);
        }
        Arrays.fill(aktywneStrzaly, false);
    }

    public void tworzenieMeteorytu(int i) {
        tablicaSzerokosci[i] = (int) ((Math.random() * 40) + 30);
        aktywneMeteoryty[i] = true;
        if (i % 4 == 0) {
            tablicaX[i] = 10;
            tablicaY[i] = miejscePrzyScianie(i);
            tablicaDX[i] = predkoscTylkoDodatnia();
            tablicaDY[i] = predkoscUjemnaIDodatnia();
        } else if (i % 4 == 1) {
            tablicaX[i] = miejscePrzyScianie(i);
            tablicaY[i] = 10;
            tablicaDX[i] = predkoscUjemnaIDodatnia();
            tablicaDY[i] = predkoscTylkoDodatnia();
        } else if (i % 4 == 2) {
            tablicaX[i] = miejscePrzyScianie(i);
            tablicaY[i] = 590;
            tablicaDX[i] = predkoscUjemnaIDodatnia();
            tablicaDY[i] = predkoscTylkoDodatnia() * (-1);
        } else {
            tablicaX[i] = 690;
            tablicaY[i] = miejscePrzyScianie(i);
            tablicaDX[i] = predkoscTylkoDodatnia() * (-1);
            tablicaDY[i] = predkoscUjemnaIDodatnia();
        }
    }

    //losowanie wartosci predkosci i polozenia

    private class MyKeyListener{
        public void keyPressed(KeyEvent e) {
            System.out.println("pressed");
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                space = true;
            } else if (e.getKeyCode() == KeyEvent.VK_1) {
                System.out.println("wpisales 1");
                klawisz1 = true;
            } else if (e.getKeyCode() == KeyEvent.VK_2) {
                klawisz2 = true;
                System.out.println("wpisales 2");
            } else if (e.getKeyCode() == KeyEvent.VK_3) {
                klawisz3 = true;
            } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                graWToku = true;
            } else if (e.getKeyCode() == KeyEvent.VK_P) {
                if (pauza) {
                    pauza = false;
                } else {
                    pauza = true;
                }
            }

        }
    }

    public int miejscePrzyScianie(int i) {
        return (int) (Math.random() * (500 - tablicaSzerokosci[i]) + 2 * tablicaSzerokosci[i]);
    }

    public int predkoscUjemnaIDodatnia() {
        return (int) (Math.random() * 6 + poziom) * (Math.random() < 0.5 ? (1) : (-1));
    }

    public int predkoscTylkoDodatnia() {
        return (int) (Math.random() * 6 + poziom);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (graWToku) {
            if (liczbaZyc < 2) {
                g.drawImage(image, imageX, imageY, 60, 60, this);
            } else {
                g.drawImage(image2, imageX, imageY, 60, 60, this);
            }
            for (int i = 0; i < tablicaX.length; i++) {
                if (aktywneMeteoryty[i]) {
                    g.drawImage(imageMeteoryt, tablicaX[i], tablicaY[i], tablicaSzerokosci[i], tablicaSzerokosci[i], null);
                }
            }
            g.drawString("ominięte meteoryty: " + Integer.toString(ominieteMEteoryty), 570, 50);
            g.drawString("poziom: " + Integer.toString(poziom), 600, 30);
            g.drawString("liczba zyc: " + Integer.toString(liczbaZyc), 600, 70);
            g.drawString("liczba coinów: " + Integer.toString(liczbaCoinow), 595, 90);
            if (liczbaStrzalow > 0) {
                g.drawString("Twoja broń strzela w " + Integer.toString(liczbaStrzalow) + " kierunkach", 520, 110);
            } else {
                g.drawString("nie masz broni", 600, 110);
            }

            if (koniec) {
                g.drawImage(gif, imageX, imageY, 160, 100, this);
            }
            if (zycieWRuchu) {
                g.drawImage(zycieZdjecie, zycieX, zycieY, 60, 100, this);
            }
            if (nowyCoin) {
                g.drawImage(coinZdjecie, coinX, coinY, 60, 60, this);
            }
            for (int i = 0; i < liczbaStrzalow; i++) {
                if (aktywneStrzaly[i]) {
                    g.drawImage(strzalZdjecie, strzalX[i], strzalY[i], 15, 15, this);
                }
            }
        } else {
            if (ominieteMEteoryty != 0) {
                g.drawString("Twój wynik: " + Integer.toString(ominieteMEteoryty), 300, 60);
            }
            g.drawString("Ranking najlepszych graczy:", 290, 80);
            for (int i = 0; i < najlepsiGracze.length; i++) {
                g.drawString(i + 1 + ": " + Integer.toString(najlepsiGracze[i]), 350, 100 + i * 15);
            }
            g.drawString("Wciśnij Enter, by rozpocząć grę", 290, 280);

        }

    }

    public void animacja() throws InterruptedException {
        Thread.sleep(500);
        while (true) {
            while (graWToku & !pauza) {
                for (int i = 0; i < liczbaMeteorytow; i++) {
                    ruchMeteorytow(i);
                    noweZycie();
                    nowyCoin();
                    nowyStrzal();
                    czas = czas + 3;
                }
                try {
                    Thread.sleep(3L * liczbaMeteorytow);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                wyborBorni();
                czyOminalMeteoryty();
                ruchZycia();
                ruchCoina();

                if (aktywneStrzaly[0] || aktywneStrzaly[1] || aktywneStrzaly[2] || aktywneStrzaly[3]) {
                    ruchStrzalu();
                }

                czyZlapalesZycie();
                czyZlapalesCoina();
                czyStrzalTrafilMeteoryt();

                if (liczbaZyc <= 0) {
                    aktualizacjaNajlepszych();
                    graWToku = false;
                    System.out.println("przegrana");
                    pomocniczyKonstruktor(10, najlepsiGracze);
//                        try {
//                            Thread.sleep(3000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                }
                repaint();
            }
            System.out.println("pauza ");
        }
    }

    public void wyborBorni() {
        if (klawisz1) {
            if (liczbaCoinow >= 5 && liczbaStrzalow != 1) {
                liczbaStrzalow = 1;
                liczbaCoinow = liczbaCoinow - 5;
                klawisz1 = false;
            }
        } else if (klawisz2 && liczbaStrzalow != 3) {
            if (liczbaCoinow >= 10 && liczbaStrzalow != 3) {
                liczbaStrzalow = 3;
                liczbaCoinow = liczbaCoinow - 10;
                klawisz2 = false;
            }
        }
        if (klawisz3 && liczbaStrzalow != 4) {
            if (liczbaCoinow >= 20) {
                liczbaStrzalow = 4;
                liczbaCoinow = liczbaCoinow - 20;
                klawisz3 = false;
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(700, 600);
    }

    public void aktualizacjaNajlepszych() {
        for (int i = 0; i < najlepsiGracze.length; i++) {
            if (najlepsiGracze[i] < ominieteMEteoryty) {
                for (int j = najlepsiGracze.length - 2; j >= i; j--) {
                    najlepsiGracze[j + 1] = najlepsiGracze[j];
                }
                najlepsiGracze[i] = ominieteMEteoryty;
                return;
            }
        }
    }

    public void ruchZycia() {
        if (zycieWRuchu) {
            if (zycieY > getHeight()) {
                zycieX = (int) ((Math.random() * (500)));
                zycieY = 0;
                zycieWRuchu = false;
            }
            zycieY = zycieY + 10;
        }
    }

    public void ruchCoina() {
        if (nowyCoin) {
            if (coinY > getHeight()) {
                coinX = (int) ((Math.random() * (500)));
                coinY = 0;
                nowyCoin = false;
            }
            coinY = coinY + 5;
        }
    }

    public void ruchStrzalu() {
        for (int i = 0; i < liczbaStrzalow; i++) {
            if (i == 0) {
                if (strzalY[i] < 0) {
                    aktywneStrzaly[i] = false;
                    strzalX[i] = 0;
                    strzalY[i] = 0;
                }
                strzalY[i] = strzalY[i] - 10;
            } else if (i == 1) {
                if (strzalX[i] < 0) {
                    aktywneStrzaly[i] = false;
                    strzalX[i] = 0;
                    strzalY[i] = 0;
                }
                strzalX[i] = strzalX[i] - 10;
            } else if (i == 2) {
                if (strzalX[i] > getWidth()) {
                    strzalX[i] = 0;
                    strzalY[i] = 0;
                    aktywneStrzaly[i] = false;
                }
                strzalX[i] = strzalX[i] + 10;
            } else {
                if (strzalY[i] > getHeight()) {
                    strzalX[i] = 0;
                    strzalY[i] = 0;
                    aktywneStrzaly[i] = false;
                }
                strzalY[i] = strzalY[i] + 10;
            }
        }
    }

    public void czyZlapalesZycie() {
        if (odleglosc(imageX + 30, zycieX + 30, imageY + 30, zycieY + 30) <= (60)) {
            liczbaZyc++;
            System.out.println("dodalem nowe zycie");
            zycieX = (int) ((Math.random() * (500)));
            zycieY = 0;
            zycieWRuchu = false;
        }
    }

    public void czyZlapalesCoina() {
        if (odleglosc(imageX + 30, coinX + 30, imageY + 30, coinY + 30) <= (50)) {
            liczbaCoinow++;
            System.out.println("brawo! zlapales coina");
            coinX = (int) ((Math.random() * (500)));
            coinY = 0;
            nowyCoin = false;
        }
    }

    public void czyStrzalTrafilMeteoryt() {
        for (int j = 0; j < liczbaStrzalow; j++) {
            for (int i = 0; i < liczbaMeteorytow; i++) {
                if (aktywneStrzaly[j] & odleglosc(strzalX[j] + 10, srodekMeteorytuX(i), strzalY[j] + 10, srodekMeteorytuY(i)) <= (10 + tablicaSzerokosci[i] / 2)) {
                    aktywneMeteoryty[i] = false;
                    System.out.println("meteoryt trafiony");
                    strzalX[j] = 0;
                    strzalY[j] = 0;
                    aktywneStrzaly[j] = false;
                }
            }
        }
    }

    public void noweZycie() {
        if (czas % 5001 == 0) {
            zycieWRuchu = true;
        }
    }

    public void nowyCoin() {
        if (czas % 9000 == 0) {
            nowyCoin = true;
        }
    }

    public void nowyStrzal() {
        if (space & liczbaStrzalow != 0) {
            System.out.println("nowy strzal");
            for (int i = 0; i < liczbaStrzalow; i++) {
                space = false;
                nowyStrzal = true;
                aktywneStrzaly[i] = true;
                strzalX[i] = imageX + 20;
                strzalY[i] = imageY + 20;
            }
        }
    }

    public int srodekMeteorytuX(int i) {
        return tablicaX[i] + tablicaSzerokosci[i] / 2;
    }

    public int srodekMeteorytuY(int i) {
        return tablicaY[i] + tablicaSzerokosci[i] / 2;
    }

    public double odleglosc(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public void czyOminalMeteoryty() {
        for (int i = 0; i < liczbaMeteorytow; i++) {
            if (aktywneMeteoryty[i] && odleglosc(imageX + 30, srodekMeteorytuX(i), imageY + 30, srodekMeteorytuY(i)) <= (tablicaSzerokosci[i] / 2 + 30)) {
                liczbaZyc--;
                aktywneMeteoryty[i] = false;
            }
        }
    }

    public void przyspieszenieMeteorytow() {
        if (ominieteMEteoryty % 50 == 0) {
            poziom++;
        }
    }

    public void ruchMeteorytow(int i) {
        tablicaX[i] += tablicaDX[i];
        tablicaY[i] += tablicaDY[i];

        if (srodekMeteorytuX(i) < -20 || srodekMeteorytuX(i) > getWidth() + 20 || srodekMeteorytuY(i) < -20 || srodekMeteorytuY(i) > getHeight() + 20) {
            tworzenieMeteorytu(i);
            ominieteMEteoryty++;
            przyspieszenieMeteorytow();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        imageX = e.getX() - 30;
        imageY = e.getY() - 30;
    }


    static class Main1 {

        public static void main(String[] args) throws InterruptedException {

            NowaAplikacja myp = new NowaAplikacja(10);
            EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    JFrame window = new JFrame();
                    window.addKeyListener(new KeyAdapter() {
                        public void keyPressed(KeyEvent e) {
                            System.out.println("pressed");
                            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                                myp.space = true;
                            } else if (e.getKeyCode() == KeyEvent.VK_1) {
                                System.out.println("wpisales 1");
                                myp.klawisz1 = true;
                            } else if (e.getKeyCode() == KeyEvent.VK_2) {
                                myp.klawisz2 = true;
                                System.out.println("wpisales 2");
                            } else if (e.getKeyCode() == KeyEvent.VK_3) {
                                myp.klawisz3 = true;
                            } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                myp.graWToku = true;
                            } else if (e.getKeyCode() == KeyEvent.VK_P) {
                                if (myp.pauza) {
                                    myp.pauza = false;
                                } else {
                                    myp.pauza = true;
                                }
                            }

                        }
                    });
                    window.setVisible(true);
                    window.setTitle("Spaceship venture");
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    window.add(myp);
                    window.pack();
                }
            });

            myp.animacja();
        }


    }
}