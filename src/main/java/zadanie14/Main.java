package zadanie14;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Peasant peasant = new Peasant("John");
        Townsman townsman = new Townsman("Kevin");
        King king = new King("Jason");
        Soldier soldier = new Soldier("Marcus");

        List<Citizen> citizens = new ArrayList<>(List.of(peasant, townsman, king, soldier));

        Town town = new Town(citizens);
        System.out.println(town.howManyCanVote());
        town.whoCanVote();



    }

}
