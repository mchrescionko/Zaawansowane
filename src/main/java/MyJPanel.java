import javax.swing.*;
import java.awt.*;

public class MyJPanel extends JPanel {

    int ileKolek;
    int[] tablicaX;
    int[] tablicaY;
    int[] tablicaDY;
    int[] tablicaDX;
    int[] tablicaSzerokosci;

    int ilekwadratow;
    int[] tablicaKwadratowX;
    int[] tablicaKwadratowY;
    int[] tablicaSzerokosciKwadratow;

    public MyJPanel(int ileKolek, int ilekwadratow) {
        this.tablicaKwadratowX = new int[ilekwadratow];
        this.tablicaKwadratowY = new int[ilekwadratow];
        this.tablicaSzerokosciKwadratow = new int[ilekwadratow];
        this.ilekwadratow = ilekwadratow;

        this.tablicaX = new int[ileKolek];
        this.tablicaY = new int[ileKolek];
        this.tablicaDY = new int[ileKolek];
        this.tablicaDX = new int[ileKolek];
        this.tablicaSzerokosci = new int[ileKolek];
        this.ileKolek = ileKolek;

        for (int i = 0; i < ileKolek; i++) {
            tablicaSzerokosci[i] = (int) (Math.random() * 40) + 30;
            tablicaX[i] = (int) (Math.random() * 800) + 10;
            tablicaY[i] = (int) (Math.random() * 600) + 10;
            tablicaDX[i] = (int) (Math.random() * 3) + 1;
            tablicaDY[i] = (int) (Math.random() * 3) + 1;
        }

        for (int i = 0; i < ilekwadratow; i++) {
            tablicaSzerokosciKwadratow[i] = (int) (Math.random() * 50) + 50;
            tablicaKwadratowX[i] = (int) (Math.random() * 700) + 10;
            tablicaKwadratowY[i] = (int) (Math.random() * 500) + 10;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < ileKolek; i++) {
            g.fillOval(tablicaX[i], tablicaY[i], tablicaSzerokosci[i], tablicaSzerokosci[i]);
        }
        g.setColor(new Color(239, 155, 250));

        for (int i = 0; i < ilekwadratow; i++) {
            g.fillRect(tablicaKwadratowX[i], tablicaKwadratowY[i], tablicaSzerokosciKwadratow[i], tablicaSzerokosciKwadratow[i]);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(900, 700);
    }

    public void animacja() {
        while (true) {
            for (int i = 0; i < ileKolek; i++) {
                try {
                    zderzeniaKulek(i);
                    zderzenieKulkiZKwadratem(i);
                    zderzenieKulkiZeSciana(i);
                    ruchPilki(i);
                    Thread.sleep(3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            repaint();
        }
    }

    public void ruchPilki(int i) {
        tablicaX[i] += tablicaDX[i];
        tablicaY[i] += tablicaDY[i];
    }

    public void zmianaKierunkuX(int i) {
        tablicaDX[i] = tablicaDX[i] * (-1);
    }

    public void zmianaKierunkuY(int i) {
        tablicaDY[i] = tablicaDY[i] * (-1);
    }

    public void zderzenieKulkiZeSciana(int i) {
        if (tablicaX[i] >= getWidth() - tablicaSzerokosci[i] || tablicaX[i] <= 0) {
            zmianaKierunkuX(i);
        }
        if (tablicaY[i] >= getHeight() - tablicaSzerokosci[i] || tablicaY[i] <= 0) {
            zmianaKierunkuY(i);
        }
    }

    public void zderzenieKulkiZKwadratem(int i) {
        for (int j = 0; j < ilekwadratow; j++) {
            for (int k = tablicaKwadratowY[j]; k < tablicaKwadratowY[j] + tablicaSzerokosciKwadratow[j]; k++) {
                if (odleglosc(srodekKulkiX(i), tablicaKwadratowX[j], srodekKulkiY(i), k) <= tablicaSzerokosci[i] / 2 ||
                        odleglosc(srodekKulkiX(i), tablicaKwadratowX[j] + tablicaSzerokosciKwadratow[j], srodekKulkiY(i), k) <= tablicaSzerokosci[i] / 2) {
                    zmianaKierunkuX(i);
                }
            }
            for (int k = tablicaKwadratowX[j]; k < tablicaKwadratowX[j] + tablicaSzerokosciKwadratow[j]; k++) {
                if (odleglosc(srodekKulkiX(i), k, srodekKulkiY(i), tablicaKwadratowY[j]) <= tablicaSzerokosci[i] / 2 ||
                        odleglosc(srodekKulkiX(i), k, srodekKulkiY(i), tablicaKwadratowY[j] + tablicaSzerokosciKwadratow[j]) <= tablicaSzerokosci[i] / 2) {
                    zmianaKierunkuY(i);
                }
            }
        }

    }

    public void zderzeniaKulek(int i) {
        for (int x = 0; x < ileKolek; x++) {
            if (x == i) {
                continue;
            }
            if (odleglosc(srodekKulkiX(i), srodekKulkiX(x), srodekKulkiY(i), srodekKulkiY(x)) <= tablicaSzerokosci[x] / 2 + tablicaSzerokosci[i] / 2) {
                if (tablicaDX[i] * tablicaDX[x] < 0) {
                    zmianaKierunkuX(i);
                    zmianaKierunkuX(x);
                    ruchPilki(i);
                    ruchPilki(x);
                }
                if (tablicaDY[i] * tablicaDY[x] < 0) {
                    zmianaKierunkuY(i);
                    zmianaKierunkuY(x);
                    ruchPilki(i);
                    ruchPilki(x);
                }
                if (tablicaDY[i] * tablicaDY[x] > 0 && tablicaDX[i] * tablicaDX[x] > 0) {
                    if (Math.abs(tablicaDY[i] * tablicaDX[i]) > Math.abs(tablicaDY[x] * tablicaDX[x])) {
                        zmianaKierunkuY(i);
                        zmianaKierunkuX(i);
                    } else {
                        zmianaKierunkuY(x);
                        zmianaKierunkuX(x);
                    }
                }
            }
        }
    }

    public int srodekKulkiX(int i) {
        return tablicaX[i] + tablicaSzerokosci[i] / 2;
    }

    public int srodekKulkiY(int i) {
        return tablicaY[i] + tablicaSzerokosci[i] / 2;
    }

    public double odleglosc(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }


}

class Main {

    public static void main(String[] args) {

        MyJPanel myp = new MyJPanel(5, 5);

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame window = new JFrame();
                window.setVisible(true);
                window.setTitle("Moje okno do rysowania");
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.add(myp);
                window.pack();
            }
        });

        myp.animacja();
    }
}