package Model;

import java.util.ArrayList;
import java.util.List;

class CardGenerator {

    private List<Card> cards = new ArrayList<>();

    CardGenerator(){ generate(); }

    private void generate() {
        for(Card.Suit suit : Card.Suit.values())
            for (int j = 1; j < 14; j++) { cards.add(new Card(j , suit)); }
    }

    List<Card> getCards(){ return cards; }

}
