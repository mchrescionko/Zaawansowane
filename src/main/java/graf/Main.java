package graf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        List<int[]> listaGrafow = new ArrayList<>();

        int[] w0 = new int[4];
        int[] w1 = new int[2];
        int[] w2 = new int[4];
        int[] w3 = new int[4];
        int[] w4 = new int[3];
        int[] w5 = new int[3];
        int[] w6 = new int[2];
        int[] w7 = new int[1];
        int[] w8 = new int[1];
        int[] w9 = new int[2];
        int[] w10 = new int[2];

        w0[0] = 1;
        w0[1] = 2;
        w0[2] = 3;
        w0[3] = 7;

        w1[0] = 0;
        w1[1] = 6;

        w2[0] = 0;
        w2[1] = 3;
        w2[2] = 4;
        w2[3] = 5;

        w3[0] = 0;
        w3[1] = 2;
        w3[2] = 4;
        w3[3] = 10;

        w4[0] = 2;
        w4[1] = 3;
        w4[2] = 5;

        w5[0] = 2;
        w5[1] = 4;
        w5[2] = 6;

        w6[0] = 1;
        w6[1] = 5;

        w7[0] = 0;

        w8[0] = 9;

        w9[0] = 8;
        w9[1] = 10;

        w10[0] = 3;
        w10[1] = 9;


        listaGrafow.add(w0);
        listaGrafow.add(w1);
        listaGrafow.add(w2);
        listaGrafow.add(w3);
        listaGrafow.add(w4);
        listaGrafow.add(w5);
        listaGrafow.add(w6);
        listaGrafow.add(w7);
        listaGrafow.add(w8);
        listaGrafow.add(w9);
        listaGrafow.add(w10);

//        for (int i[] : listaGrafow) {
//
//            for (int i1 : i) {
//                System.out.print(i1 + "N");
//            }
//            System.out.println();
//        }

//        zapis(listaGrafow);
        List<int[]> graf = odczyt("grafy");
        System.out.println();
        List<Integer> listaZZerem = new ArrayList<>();
        listaZZerem.add(0);
        bfs(graf, new ArrayList<>(), listaZZerem);


    }

    public static void dfs(List<int[]> graf, List<Integer> listaZaliczonychWierzcholkow, int i) {
        for (int j = 0; j < graf.get(i).length; j++) {
            if (listaZaliczonychWierzcholkow.contains(graf.get(i)[j])) {
                continue;
            }
            System.out.println(graf.get(i)[j]);
            listaZaliczonychWierzcholkow.add(graf.get(i)[j]);
            dfs(graf, listaZaliczonychWierzcholkow, graf.get(i)[j]);
        }
    }

    public static void bfs(List<int[]> graf, List<Integer> listaZaliczonychWierzcholkow, List<Integer> listaWierzcholkowDoZaliczenia) {
        List<Integer> extraList = new ArrayList<>();
        if (graf.size() != listaZaliczonychWierzcholkow.size()) {
            for (int i = 0; i < listaWierzcholkowDoZaliczenia.size(); i++) {
                extraList.add(listaWierzcholkowDoZaliczenia.get(i));
            }
            for (Integer integer : extraList) {
                if (!listaZaliczonychWierzcholkow.contains(integer)) {
                    System.out.println(integer);
                    listaZaliczonychWierzcholkow.add(integer);
                    for (int i = 0; i < graf.get(integer).length; i++) {
                        if (!listaZaliczonychWierzcholkow.contains(graf.get(integer)[i])) {
                            listaWierzcholkowDoZaliczenia.add(graf.get(integer)[i]);
                        }
                    }
                }
            }
            bfs(graf, listaZaliczonychWierzcholkow, listaWierzcholkowDoZaliczenia);
        }
    }


    public static void zapis(List<int[]> lista) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("grafy");
        for (int i[] : lista) {
            for (int i1 : i) {
                printWriter.print(i1 + "N");
            }
            printWriter.println();
        }
        printWriter.close();

    }

    public static List<int[]> odczyt(String path) throws FileNotFoundException {
        File plik = new File(path);
        Scanner scanner = new Scanner(plik);
        List<int[]> lista = new ArrayList<>();
        int[] wierzcholek;
        String tekst;
        int x = 0;
        while (scanner.hasNextLine()) {
            tekst = scanner.nextLine();
            wierzcholek = new int[tekst.split("N").length + 1];
            String[] tekst1 = tekst.split("N");
            wierzcholek[0] = x;
            for (int i = 1; i < wierzcholek.length; i++) {
                wierzcholek[i] = Integer.parseInt(tekst1[i - 1]);
            }
            lista.add(wierzcholek);
            x++;
        }
        int j = 0;
        for (int[] i : lista) {

            System.out.println("wierzcholek nr " + j + " jest incydentny z wierzchołkami: ");
            for (int i1 : i) {
                System.out.println(i1 + " ");
            }
            j++;
        }
        ;
        return lista;


    }


}
