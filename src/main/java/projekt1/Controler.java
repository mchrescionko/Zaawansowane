package projekt1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controler {


    protected int move(String komunikat) {
        Scanner scanner = new Scanner(System.in);
        int result;

        System.out.println(komunikat);
        try {
            result = scanner.nextInt();
            if (result == 1) {
                return -1;
            } else if (result == 2) {
                return 1;
            } else if (result == 0) {
                return 0;
            } else {
                System.out.println("niewlasciwa liczba, wpisz 1 lub, 2 lub 0");
                return move(komunikat);
            }

        } catch (java.util.InputMismatchException e) {
            System.out.println("błędny znak, wpisz cyfrę");

            scanner.nextLine();
            return move(komunikat);
        }

    }
}
