package Model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Card> cards = new ArrayList<>();

    Player(String name){ this.name = name; }

    String getName() { return name; }

    public List<Card> getCards() { return cards; }

    void addCard(Card card) { cards.add(card); }
}
