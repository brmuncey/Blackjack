package Model;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Deck {

    private List<Card> cards;

    Deck(){
        cards = new CardGenerator().getCards();
        shuffle();
    }

    private void shuffle(){
        for(int i = 0 ; i < cards.size(); i++){
            int random = getRandom();
            swapCards( i , random );
        }
    }

    private void swapCards(int i, int j){
        Card temp = cards.get(i);
        cards.set(i,cards.get(j));
        cards.set(j, temp);
    }

    private int getRandom() { return ThreadLocalRandom.current().nextInt(0,  52); }

    /*void printDeck(){
        System.out.println();
        for(Card c : cards) { System.out.println(c.getCard()); }
    }*/

    Card pop(){ return cards.remove(0); }

    List<Card> getCards() { return cards; }

    void insert(List<Card> discard) {
        cards.addAll(discard);
        shuffle();
    }
}
