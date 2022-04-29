package enumyKarty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Gracz {
    private String name;
    private List<Karty> handCards = new ArrayList<>();
    private List<Karty> tableCards = new ArrayList<>();

    public Gracz(String name) {
        this.name = name;
    }

    public void addCard(List <Karty> cards){
        tableCards.addAll(cards);
    }

    public List<Karty> getTableCards() {
        return tableCards;
    }

    public List<Karty> gethandCards() {
        return handCards;
    }

    public Karty takeLastCard(){
        Karty card = handCards.remove(0);
        handCards.remove(0);

        if(handCards.size()==0){

            Collections.shuffle(tableCards);
            handCards.addAll(tableCards);
        }
        return card;
    }
    
    public String toString (){
        return name;
    }

    public void addCard1(Karty karta){
        handCards.add(karta);
    }
    
    
}
