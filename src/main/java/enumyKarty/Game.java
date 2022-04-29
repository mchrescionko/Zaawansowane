package enumyKarty;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static void round(Gracz gracz1, Gracz gracz2, List<Karty> drawCards2) {
        Scanner scanner = new Scanner(System.in);
        Karty player1Card = gracz1.takeLastCard();
        Karty player2Card = gracz2.takeLastCard();
        List<Karty> drawCards = new ArrayList<>(drawCards2);
        drawCards.add(player1Card);
        drawCards.add(player2Card);

        System.out.println("Karta gracza " + gracz1 + " to " + player1Card);
        System.out.println("Karta gracza " + gracz2 + " to " + player2Card);

        if (player1Card.getRank().getRankStrength() > player2Card.getRank().getRankStrength()) {
            System.out.println("wygrywa gracz " + gracz1);
            gracz2.addCard(drawCards);

        } else if (player1Card.getRank().getRankStrength() < player2Card.getRank().getRankStrength()) {
            System.out.println("wygrywa gracz " + gracz2);
            gracz1.addCard(drawCards);

        } else {
            System.out.println("remis, karty na stos ");
            round(gracz1, gracz2, drawCards);
        }
        scanner.nextInt();

    }

}

