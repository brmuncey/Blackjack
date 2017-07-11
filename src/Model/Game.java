package Model;

public class Game {

    private Deck deck;
    private Player player;
    private Dealer dealer;

    public void setup() {
        deck = new Deck();
        deck.shuffle();
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
        for(Card c : dealer.getCards()) System.out.println(c.getCard());

        System.out.println("\n"+player.getName()+": ");
        for(Card c : player.getCards()) System.out.println(c.getCard());
    }
}
