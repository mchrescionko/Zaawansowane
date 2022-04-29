package zadaniaRekrturacyjne;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int tab [] = new int []{19,2,33,4,5,6};
        tab = Arrays.stream(tab).sorted().toArray();
        System.out.println(tab[0]);
    }
}
