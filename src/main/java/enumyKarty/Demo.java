package enumyKarty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

//        Karty karta = new Karty(Suit.Karo, Rank.Jopek);
//        Karty karta2 = new Karty(Suit.Kier, Rank.Dama);
//
//        System.out.println(karta);
//
//        for(Rank rank1: Rank.values()){
//            System.out.println(rank1);
//        }
//
//        ArrayList<Karty> listaPikow = new ArrayList<>();
//        for(Rank ranking: Rank.values()){
//            listaPikow.add(new Karty(Suit.Karo,ranking));
//        }
//
//        for(Karty karta1: listaPikow){
//            System.out.println(karta1);
//        }
//
//

//
//        for(Karty karta5:talia){
//            System.out.println(karta5);
//        }

        List<Karty> talia = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                talia.add(new Karty(suit, rank));
            }
        }

        Collections.shuffle(talia);

        Gracz gracz1 = new Gracz("John");
        Gracz gracz2 = new Gracz("Max");

        int i = 0;

        for (Karty karty : talia) {
            if (i % 2 == 0) {
                gracz1.addCard1(karty);
            } else {
                gracz2.addCard1(karty);
            }
            i++;
        }

        while (!(gracz1.gethandCards().size() == 0 && gracz1.getTableCards().size() == 0) || (gracz2.gethandCards().size() == 0 && gracz2.getTableCards().size() == 0)) {

            List<Karty> emptyList = new ArrayList<>();
            Game.round(gracz1, gracz2, emptyList);

        }


    }
}
