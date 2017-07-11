package Model;

class Dealer extends Player{

    Dealer(){
        super("Dealer");
    }

    void initialDeal(Deck deck, Player player) {
        int j = 0;
        while ( j < 2){
            dealTo(player, deck);
            dealTo(this,deck);
            j++;
        }
    }

    private void dealTo(Player player, Deck deck){
        player.addCard(deck.getCards().remove(0));
    }
}
