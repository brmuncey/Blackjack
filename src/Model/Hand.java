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

    public String getTotal(){
        int total = 0;
        for(Card c : cards ){
            if(c.getCard().equals("A")){
                if(total + 11 > 21){ total += 11; }
                else { total++; }
            } else { total += c.getValue(); }
        }

        if(total <= 21) { return Integer.toString(total); }
        return "Busted";
    }
}
