package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Deck {

    private List<Card> cards;
    private List<Card> discard = new ArrayList<>();

    Deck(){ cards = new CardGenerator().getCards(); }

    List<Card> getCards(){ return cards; }

    void shuffle(){
        for(int i = 0 ; i < cards.size(); i++ ){
            int random = getRandom();
            while(random == i){ getRandom(); }
            swapCards( i , random );
        }
    }

    private void swapCards(int i, int j){
        Card temp = cards.get(i);
        cards.set(i,cards.get(j));
        cards.set(j, temp);
    }

    private int getRandom() { return ThreadLocalRandom.current().nextInt(0,  52); }

    void printDeck(){
        System.out.println();
        for(Card c : cards)
            System.out.println(c.getCard());
    }

    private void addToDiscard(Card card){ discard.add(card); }
}
