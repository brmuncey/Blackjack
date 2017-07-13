package Model;

import java.util.List;

public class Player {

    private String name;
    private Hand hand;

    Player(String name){
        this.name = name;
        hand = new Hand();
    }

    public String getName() { return name; }

    public void addCard(Card card) { hand.add(card); }

    public Hand getHand() { return hand; }

    public List<Card> discard() { return hand.emptyHand(); }
}
