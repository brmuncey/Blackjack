package Model;

class Dealer extends Player{

    private Deck deck;
    Dealer(Deck deck){
        super("Dealer");
        this.deck = deck;
    }

    void initialDeal(Player player) {
        int j = 0;
        while ( j < 2){
            dealTo(player);
            dealTo(this);
            j++;
        }
    }

    private void dealTo(Player player ){ player.addCard(deck.getCards().remove(0)); }
}
