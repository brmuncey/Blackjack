package Model;

public class Player {

    private String name;
    private Hand hand;

    Player(String name){
        this.name = name;
        hand = new Hand();
    }

    String getName() { return name; }

    public void addCard(Card card) { hand.add(card); }

    public Hand getHand() { return hand; }
}
