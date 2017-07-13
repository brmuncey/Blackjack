package Model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();

    void add(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getTotal(){
        int total = 0;
        for(Card c : cards ){
            if(c.getCard().equals("A") && total <= 11){ total += 11; }
            else { total += c.getValue(); }
        }
        return total;
    }

    public int getFirstDealTotal(){ return cards.get(1).getValue(); }



}
