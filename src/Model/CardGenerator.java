package Model;

import java.util.List;

class CardGenerator {

    CardGenerator(Deck deck){
        List<Card> cards = deck.getCards();
        generate(cards);
    }

    private void generate(List<Card> cards) {
        for(Card.Suit suit : Card.Suit.values())
            for (int j = 1; j < 14; j++) { cards.add(new Card(j , suit)); }
    }

}
