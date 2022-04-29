package zadaniaRekrturacyjne;

//    Dane:
//    n liczb
//
//    k (1<k<n)
//
//    Zadanie:
//    wybrać k liczb żeby najmniejsza odległoś między liczbami w zbiorze była jak największa
//
//    Na 2 metody:
//            1 metoda algorytm siłowy
//    wygen wszystkie możliwe
//
//2 algorytmem dziel i rządź. (przeróbka binary search)

import java.util.*;

public class ZadRekrutacyjne1 {
    public static void main(String[] args) {

        int n = 20;
        int[] tab1 = new int[n];
        int[] tab = new int[]{1,2,3,10,20,30};
        for (int i = 0; i < n; i++) {
            tab1[i] = (int) (Math.random() * 100);
        }
        int k = 5;
        List<Integer> rozwiazanie = new ArrayList<>();

        int minimalna = tab[0];
        int maksymalna = tab[0];

        for (int j = 0; j < tab.length; j++) {
            if (tab[j] < minimalna) {
                minimalna = tab[j];
            }
            if (tab[j] > maksymalna) {
                maksymalna = tab[j];
            }
        }
        rozwiazanie.add(minimalna);
        rozwiazanie.add(maksymalna);

        while (rozwiazanie.size() != k) {
            rozwiazanie.add(sprawdzanieOdleglosci(tab, rozwiazanie));
        }
        System.out.println();
        for (int i : tab) {
            System.out.print(i + ", ");
        }
        System.out.println(rozwiazanie);

    }

    public static int sprawdzanieOdleglosci(int[] tab, List<Integer> lista) {
        HashMap<Integer, Integer> liczbaOdleglosc = new HashMap<>();


        for (int p = 0; p < tab.length; p++) {
            System.out.println("wylosowana pierwszy indeks: " + p + " , liczba: " + tab[p]);
            if (lista.contains(tab[p])) {
                continue;
            }
            System.out.println("sprawdzana liczba: " + p);

            int tablicaOdleglosci[] = new int[lista.size()];
            for (int i = 0; i < lista.size(); i++) {
                tablicaOdleglosci[i] = Math.abs(tab[p] - lista.get(i));
                System.out.println("tablica[" + i + "] = " + tablicaOdleglosci[i]);
            }

            if (p >= tab.length - 1) {
                continue;
            }

            int najmniejsza = najmniejsza2(tablicaOdleglosci);
            System.out.println("najmniejsza: " + najmniejsza);
            liczbaOdleglosc.put(p, najmniejsza);
        }
        System.out.println("jakas najmniejsza odleglosc: " + tab[najmniejszazMapy(liczbaOdleglosc, tab)]);
        return tab[najmniejszazMapy(liczbaOdleglosc, tab)];

    }

    public static int najmniejsza2(int tab[]) {
        tab = Arrays.stream(tab).sorted().toArray();
        return tab[0];
    }

    public static int najwieksza(int tab[]) {
        tab = Arrays.stream(tab).sorted().toArray();
        return tab[tab.length-1];
    }


    public static int najmniejszazMapy(HashMap<Integer, Integer> liczbaOdleglosc, int[] tab) {
        Collection collection = liczbaOdleglosc.values();
        System.out.println("dlugosc: " + collection.size());
        Collection collection2 = liczbaOdleglosc.keySet();
        int wartosci[] = new int[collection.size()];
        int klucze[] = new int[collection.size()];
        Object kolekcjawartosci[] = collection.toArray();
        Object kolekcjaKluczy[] = collection2.toArray();
        for (int i = 0; i < collection.size(); i++) {
            System.out.println(i);
            wartosci[i] = (int) kolekcjawartosci[i];
            klucze[i] = (int) kolekcjaKluczy[i];
        }
        System.out.println("wartosci: ");
        for (int i = 0; i < wartosci.length; i++) {
            System.out.print(wartosci[i] + ", ");
        }
        ;
        System.out.println();
        for (int i = 0; i < wartosci.length; i++) {
            System.out.print(klucze[i] + ", ");
        }
        ;
        System.out.println();
        for (int i = 0; i < wartosci.length; i++) {
            System.out.print(tab[klucze[i]] + ", ");
        }
        ;
        System.out.println();

        int najmniejszaOdleglosc = najwieksza(wartosci);
        for (int i = 0; i < wartosci.length; i++) {
            if (wartosci[i] == najmniejszaOdleglosc) {
                System.out.println("znaleziona: " + wartosci[i]);
                System.out.println("wartosc: " + tab[klucze[i]]);
                return klucze[i];

            }
        }
        System.out.println("nie wyszlo cos");
        return 4534567;

    }


}
