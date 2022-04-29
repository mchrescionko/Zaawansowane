package listy;

import java.util.ArrayList;
import java.util.Arrays;
import org.hibernate.cfg.Configuration;

public class Lists {
    public static void main(String[] args) {
        ArrayList<Integer> liczby = new ArrayList<>();
        liczby.add(1);
        liczby.add(2);
        System.out.println(liczby);
        System.out.println(liczby.size());
        liczby.add(3);
        System.out.println(liczby);
        System.out.println(liczby.get(1));
        liczby.add(0,10);
        System.out.println(liczby);

        System.out.println(liczby);
        Integer pierwsza = (Integer) liczby.get(0);

        liczby.remove(0);
        System.out.println(liczby);

        ArrayList<String> imiona = new ArrayList<>();
        imiona.add("Asia");
        imiona.add("Asia");
        imiona.add("Kasia");
        imiona.remove("Asia");
        System.out.println(imiona);

        ArrayList<String >imiona2 = new ArrayList<>(imiona);
        System.out.println(imiona2);
        imiona.add("Jan");
        for(String imie:imiona){
            if(!imie.endsWith("a")){
                System.out.println(imie);
            }
        }




        }
    }



