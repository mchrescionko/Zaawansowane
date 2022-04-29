package programowanieFunkcyjne;

import java.util.Comparator;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {


        Equation dodawanie = (int x, int y) ->{ return x+y; };
        Equation dodawanie2 = ( x, y) -> x+y;

        Printer krzyczaca = (x)-> System.out.println(x.toUpperCase(Locale.ROOT));
        krzyczaca.execute("blabla");

        Equation odejmowanie = new Equation() {
            @Override
            public int execute(int x, int y) {
                return x-y;
            }
        };

        System.out.println(dodawanie.execute(2, 1));
        System.out.println(odejmowanie.execute(2, 1));

        Przycisk przycisk = new Przycisk();
        przycisk.liczba1 = 10;
        przycisk.liczba2 = 20;

        przycisk.ustawDzialaniePrzycisku(( x, y) -> x+y);
        przycisk.nacisnij();

        przycisk.ustawDzialaniePrzycisku(odejmowanie);
        przycisk.nacisnij();





    }

    public static int dodawanie(int x, int y){
        return x+y;
    }
}

class Przycisk{

    Equation dzialanie;
    int liczba1;
    int liczba2;

    public void ustawDzialaniePrzycisku(Equation dzialanie){
        this.dzialanie = dzialanie;
    }

    public void nacisnij(){
        System.out.println(dzialanie.execute(liczba1, liczba2));
    }


}
