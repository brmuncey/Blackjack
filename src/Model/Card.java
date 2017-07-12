package Model;

public class Card {

    private int value;
    private Suit suit;

    Card(int value, Suit suit){
        this.value = value;
        this.suit = suit;
    }

    private int getValue() { return value; }

    public Suit getSuit() { return suit; }

    public String getCard(){
        String value;

        if(getValue() == 1){ value = "A"; }
        else if(getValue() == 11){ value = "J"; }
        else if(getValue() == 12){ value = "Q"; }
        else if(getValue() == 13){ value = "K"; }
        else { value = Integer.toString(getValue()); }

        return value;
    }

    public enum Suit { SPADES , DIAMONDS , CLUBS , HEARTS }
}
