package Model;

public class Dealer extends Player{

    private Deck deck;
    Dealer(Deck deck){
        super("Dealer");
        this.deck = deck;
    }

    void initialDeal(Player player) {
        for(int i = 0 ; i < 2 ; i++) {
            dealTo(player);
            dealTo(this);
        }
    }

    private void dealTo(Player player){ player.addCard( deck.getCards().remove(0)); }
}
