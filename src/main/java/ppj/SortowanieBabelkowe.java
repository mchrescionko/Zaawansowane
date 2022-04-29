package ppj;

import java.util.Arrays;

public class SortowanieBabelkowe {
    public static void main(String[] args) {
        int[] tab = new int[]{2, 5, 6, 3, 1, 8, 4, 9, 10};
        for (int i : tab) {
            System.out.println(i);
        }

        int temp;
        for (int i = 0; i < tab.length - 1; i++) {
            for (int j = 0; j < tab.length - 1; j++) {
                if (tab[j] < tab[j + 1]) {
                    temp = tab[j + 1];
                    tab[j + 1] = tab[j];
                    tab[j] = temp;
                }
            }
        }
        System.out.println("posortowana: ");
        for (int i : tab) {
            System.out.println(i);
        }


        String[] tabString = new String[]{"raz", "dwa", "trzy", "cztery"};
        for (String s : tabString) {
            System.out.println(s);
        }

        String current;
        for (int i = 0; i < tabString.length - 1; i++) {
            current = "";
            for (int j = 0; j < tabString.length - 1; j++) {
                char x = tabString[j].charAt(0);
                char y = tabString[j+1].charAt(0);
                if (x>y) {
                    current = tabString[j];
                    tabString[j]=tabString[j+1];
                    tabString[j+1] = current;
                }
            }
        }

        for (String s : tabString) {
            System.out.println(s);
        }

    }

}
