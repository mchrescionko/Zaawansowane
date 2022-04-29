package pokerEnumy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;


public class Gra {
    public Gra() {
    }

    public List<pokerEnumy.Karty> tworzenieTalii() {
        List<pokerEnumy.Karty> talia = new ArrayList<>();
        for (pokerEnumy.Suit suit : Suit.values()) {
            for (pokerEnumy.Rank rank : Rank.values()) {
                talia.add(new Karty(suit, rank));
            }
        }
        return talia;
    }

    public void generator() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        List<List<Karty>> mainListOfListCards = new ArrayList<>();
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Karty> singleHandList = tworzenieTalii();
            singleHandList = tasowanieTalii(singleHandList);
            singleHandList = rozdanie(singleHandList);
            String uklad = sprawdzenieZwracajaceStringa(singleHandList);
            resultList.add(uklad);
            mainListOfListCards.add(singleHandList);
        }
        System.out.println("lista: " + mainListOfListCards);

        String jsonMainListofLists = objectMapper.writeValueAsString(mainListOfListCards);
        String jsonResults = objectMapper.writeValueAsString(resultList);

        PrintWriter printWriter = new PrintWriter("test5");
        printWriter.println(jsonMainListofLists);
        printWriter.println(jsonResults);
        printWriter.close();

    }

    public void testNew() throws JsonProcessingException, FileNotFoundException {

        File file = new File("test5");
        Scanner scanner = new Scanner(file);
        String listofLists = scanner.nextLine();
        System.out.println(listofLists);
        String resultList = scanner.nextLine();

        ObjectMapper objectMapper = new ObjectMapper();
        List<List<Karty>> kartyList = objectMapper.readValue(listofLists, new TypeReference<>() {
        });
        List<String> resultLists = objectMapper.readValue(resultList, new TypeReference<>() {
        });

        System.out.println("karty: "+kartyList);
        System.out.println(resultList);

//
        for (int i=0;i<kartyList.size();i++) {
            if(sprawdzenieZwracajaceStringa(kartyList.get(i)).equals(resultLists.get(i))){
                System.out.println("wynik nr "+i+ " prawidłowy");
            }else{
                System.out.println("wynik nr "+i+ " nieprawidłowy");

            }
        }

    }


    public List<pokerEnumy.Karty> tasowanieTalii(List<pokerEnumy.Karty> talia) {
        Collections.shuffle(talia);
        return talia;
    }

    public List<pokerEnumy.Karty> rozdanie(List<pokerEnumy.Karty> talia) {
        List<pokerEnumy.Karty> piecKart = new ArrayList<>();
        piecKart.add(talia.get(0));
        piecKart.add(talia.get(1));
        piecKart.add(talia.get(2));
        piecKart.add(talia.get(3));
        piecKart.add(talia.get(4));
        return piecKart;
    }

    public boolean czyZawiera(List<pokerEnumy.Karty> talia, Integer rank) {
        for (Karty karty : talia) {
            if (karty.getRank().getRankStrength() == rank) {
                return true;
            }
        }
        return false;
    }

    public void sprawdzenie(List<pokerEnumy.Karty> talia) {
        if (pokerKrolewski(talia)) {
            System.out.println("poker królewski");
            return;
        }
        if (poker(talia)) {
            System.out.println("poker");
            return;
        }
        if (kareta(talia)) {
            System.out.println("kareta");
            return;
        }
        if (full(talia)) {
            System.out.println("full");
            return;
        }
        if (kolor(talia)) {
            System.out.println("kolor");
            return;
        }
        if (strit(talia)) {
            System.out.println("strit");
            return;
        }
        if (trojka(talia)) {
            System.out.println("trojka");
            return;
        }
        if (dwiePary(talia)) {
            System.out.println("dwie pary");
            return;
        }
        if (para(talia)) {
            System.out.println("para");
            return;
        }
        System.out.println("nic");
    }


    public String sprawdzenieZwracajaceStringa(List<pokerEnumy.Karty> talia) {
        if (pokerKrolewski(talia)) {
            return "poker królewski";
        }
        if (poker(talia)) {
            System.out.println();
            return "poker";
        }
        if (kareta(talia)) {
            System.out.println("kareta");
            return "kareta";
        }
        if (full(talia)) {
            System.out.println("full");
            return "full";
        }
        if (kolor(talia)) {
            System.out.println();
            return "kolor";
        }
        if (strit(talia)) {
            System.out.println();
            return "strit";
        }
        if (trojka(talia)) {
            System.out.println("trojka");
            return "trojka";
        }
        if (dwiePary(talia)) {
            System.out.println("dwie pary");
            return "dwie pary";
        }
        if (para(talia)) {
            System.out.println("para");
            return "para";
        }
        System.out.println("nic");
        return "nic";
    }


    public boolean strit(List<pokerEnumy.Karty> talia) {

        Karty najnizsza = talia.get(0);
        for (Karty karty : talia) {
            najnizsza = najnizsza.compareLowest(najnizsza, karty);
        }

        int x = 0;

        for (int i = 1; i < 5; i++) {
            if (czyZawiera(talia, najnizsza.getRank().getRankStrength() + i)) {
                x++;
            }
        }
        if (x == 4) {
            return true;
        }

        boolean czyjestAs = false;
        for (Karty karty : talia) {
            if (karty.getRank().getRankStrength() == 14) {
                czyjestAs = true;
            }
        }

        if (!czyjestAs) {
            return false;
        }

        x = 0;

        for (int i = 1; i < 5; i++) {
            if (czyZawiera(talia, 1 + i)) {
                x++;
            }
        }
        return x == 4;
    }

    public boolean kolor(List<pokerEnumy.Karty> talia) {
        Suit suit = talia.get(0).getSuit();
        for (Karty karta : talia) {
            if (karta.getSuit() != suit) {
                return false;
            }
        }
        return true;
    }

    public boolean poker(List<pokerEnumy.Karty> talia) {
        if (kolor(talia) && strit(talia)) {
            return true;
        }
        return false;
    }


    public boolean pokerKrolewski(List<pokerEnumy.Karty> talia) {
        if (!poker(talia)) {
            return false;
        }

        for (Karty karty : talia) {
            if (karty.getRank().getRankStrength() == 14) {
                return true;
            }
        }
        return false;
    }

    public boolean kareta(List<pokerEnumy.Karty> talia) {
        for (Karty karty : talia) {
            int x = 0;
            for (Karty karty1 : talia) {
                if (karty.getRank() == karty1.getRank()) {
                    x++;
                }
            }
            if (x == 4) {
                return true;
            }
        }
        return false;
    }


    public boolean para(List<pokerEnumy.Karty> talia) {
        for (Karty karty : talia) {
            int x = 0;
            for (Karty karty1 : talia) {
                if (karty.getRank() == karty1.getRank()) {
                    x++;
                }

            }
            if (x > 1) {
                return true;
            }

        }
        return false;
    }

    public boolean trojka(List<pokerEnumy.Karty> talia) {
        for (Karty karty : talia) {
            int x = 0;
            for (Karty karty1 : talia) {
                if (karty.getRank() == karty1.getRank()) {
                    x++;
                }
            }
            if (x > 2) {
                return true;
            }
        }
        return false;
    }


    public boolean dwiePary(List<pokerEnumy.Karty> talia) {
        List<Karty> talia2 = new ArrayList<>(List.copyOf(talia));
        for (Karty karty : talia) {
            for (Karty karty1 : talia) {
                if ((karty1 != karty) & (karty.getRank() == karty1.getRank())) {
                    talia2.remove(karty);
                    talia2.remove(karty1);
                    return para(talia2);
                }
            }
        }
        return false;
    }

    public boolean full(List<pokerEnumy.Karty> talia) {

        for (Karty karty : talia) {
            List<Karty> talia2 = new ArrayList<>(List.copyOf(talia));
            for (Karty karty1 : talia) {
                if ((karty1 != karty) & (karty.getRank() == karty1.getRank())) {
                    talia2.remove(karty);
                    talia2.remove(karty1);
                    if (trojka(talia2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


}
