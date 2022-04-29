package pokerEnumy;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Karty {

    private Suit suit;
    private Rank rank;

    public Karty(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public String toString(){
        return suit + " " + rank;
    }

    public Rank getRank() {
        return rank;
    }

    public Karty compare(Karty karta1, Karty  karta2){
        if (karta1.getRank().getRankStrength()>karta2.getRank().getRankStrength()){
            return karta1;
        }
        return karta2;
    }
    public Karty compareLowest(Karty karta1, Karty  karta2){
        if (karta1.getRank().getRankStrength()>karta2.getRank().getRankStrength()){
            return karta2;
        }
        return karta1;
    }



}
