package Model;

public class Game {

    private Player player;
    private Dealer dealer;

    public void setup() {
        Deck deck = new Deck();
        deck.printDeck();
        dealer = new Dealer(deck);
        player = new Player("Brannon");
    }

    public void play(){
        dealer.initialDeal(player);
        printHands();
    }

    private void printHands(){
        System.out.println(dealer.getName()+": ");
        for(Card c : dealer.getHand().getCards()) System.out.println(c.getCard());

        System.out.println("\n"+player.getName()+": ");
        for(Card c : player.getHand().getCards()) System.out.println(c.getCard());
    }

    public Player getPlayer() { return player; }

    public Dealer getDealer() { return dealer; }
}
