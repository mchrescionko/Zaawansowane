package zadaniaRekrturacyjne;

import java.util.*;
import java.util.stream.Collectors;

public class ZadanieRekrutacyjne1DobreRozwiazanie {
    int n;
    int k;
    List<List<Integer>> punkty = new ArrayList<>();
    List<Integer> zbiorN = new ArrayList<>();

    public ZadanieRekrutacyjne1DobreRozwiazanie(int k, int n) {
        this.k = k;
        this.n = n;
        for (int i = 0; i < n; i++) {
            zbiorN.add(i);
        }
        for (Integer integer : zbiorN) {
            List<Integer> nowaLista = new ArrayList<>();
            nowaLista.add(integer);
            punkty.add(nowaLista);
        }
    }

    public void rozwiazanieDlaK() {
        for (int l = 0; l < k - 1; l++) {
            System.out.println("ogien");
            List<List<Integer>> punktyExtra = new ArrayList<>(punkty);
            for (Integer integer : zbiorN) {
                for (List<Integer> list : punktyExtra) {
                    List<Integer> nowaLista = new ArrayList<>();
                    nowaLista.add(integer);
                    nowaLista.addAll(list);
                    punkty.add(nowaLista);
                }
            }
        }
    }

    public void usuniecieNiepotrzebnychPunktow() {

        List<List<Integer>> punktyExtra = new ArrayList<>(punkty);
        System.out.println(punktyExtra.size());
        System.out.println(punkty.size());
        for (int i = punktyExtra.size() - 1; i > -1; i--) {
            if (punkty.get(i).size() != k) {
                punkty.remove(i);
            }
        }
    }

    public List<Integer> znalezienieOdpowiedzi() {
        List<Integer> listaOdleglosci2 = new ArrayList<>();
        for (List<Integer> list : punkty) {
            List<Integer> listaJedna = new ArrayList<>();
            for (int j = 0; j < k - 1; j++) {
                list.sort(Comparator.naturalOrder());
                listaJedna.add(Math.abs(list.get(j) - list.get(j + 1)));
            }
            int najmniejsza = znalezienieNajmniejszejOdleglosci(listaJedna);
            listaOdleglosci2.add(najmniejsza);
        }
        int najmniejsza = znalezienieNajwiekszejOdleglosci(listaOdleglosci2);

        System.out.println();
        System.out.println();
        System.out.println("lista z najmniejsza odlegloscia: " + listaOdleglosci2);
        for (int i = 0; i < punkty.size(); i++) {
            if (najmniejsza == listaOdleglosci2.get(i)) {
                return punkty.get(i);
            }
        }
        return punkty.get(0);
    }

    public int znalezienieNajmniejszejOdleglosci(List<Integer> odpowiedzi) {
        odpowiedzi = odpowiedzi.stream().sorted().collect(Collectors.toList());
        return odpowiedzi.get(0);
    }

    public int znalezienieNajwiekszejOdleglosci(List<Integer> odpowiedzi) {
        odpowiedzi = odpowiedzi.stream().sorted().collect(Collectors.toList());
        return odpowiedzi.get(odpowiedzi.size()-1);
    }

    public static void main(String[] args) {
        ZadanieRekrutacyjne1DobreRozwiazanie main = new ZadanieRekrutacyjne1DobreRozwiazanie(5, 21);
        main.rozwiazanieDlaK();
        main.usuniecieNiepotrzebnychPunktow();
        List<Integer> odpowiedzi = main.znalezienieOdpowiedzi();
        System.out.println(main.zbiorN);
        System.out.println(main.punkty);
        System.out.println(odpowiedzi);
    }
}
