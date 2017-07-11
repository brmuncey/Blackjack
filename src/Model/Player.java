package Model;

import java.util.ArrayList;
import java.util.List;

class Player {

    private String name;
    private List<Card> cards;

    Player(String name){
        this.name = name;
        cards = new ArrayList<>();
    }

    String getName() { return name; }

    List<Card> getCards() { return cards; }

    void addCard(Card card) { cards.add(card); }
}
