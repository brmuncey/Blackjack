package Model;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends Player{

    private Deck deck;
    private List<Card> discard = new ArrayList<>();

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

    private void dealTo(Player player){ player.addCard( deck.pop()); }

    public Card deal() { return deck.pop(); }

    public void takeTurn() {
        while (this.getHand().getTotal() < 17) {
            this.addCard(this.deal());
            if(this.getHand().getTotal() < 22 && this.getHand().getTotal() > 16) { break; }
        }
    }

    public void retrieveCards(List<Card> playerCards, List<Card> dealerCards) {
        discard.addAll(playerCards);
        discard.addAll(dealerCards);
        checkForReshuffle();
    }

    private void checkForReshuffle() {
        if(deck.getCards().size() <= 10){ deck.insert(discard); }
    }
}
