package Model;

public class Game {

    private Deck deck;
    private Player player;
    private Dealer dealer;

    public void setup() {
        deck = new Deck();
        dealer = new Dealer();
        new CardGenerator(deck);
        deck.shuffle();
        deck.printDeck();
        player = new Player("Brannon");
    }

    public void play(){
        dealer.initialDeal(deck, player);
        printHands();
    }

    private void printHands(){
        System.out.println(dealer.getName()+": ");
        for(Card c : dealer.getCards()) System.out.println(c.getCard());

        System.out.println("\n"+player.getName()+": ");
        for(Card c : player.getCards()) System.out.println(c.getCard());
    }
}
