
package project2;

// sourced from https://github.com/EricCharnesky/CIS2151-Summer2021/blob/main/Project2-Holdem/src/project2/holdem/Card.java

public class Card implements Comparable<Card> {

    Card( Face face, Suit suit)
    {
        this.face = face;
        this.suit = suit;
    }
    
    Card(Card card) {
        face = card.face;
        suit = card.suit;
    }

    public enum Suit { CLUBS, HEARTS, SPADES, DIAMONDS };
    
    public enum Face { TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, 
        TEN, JACK, QUEEN, KING, ACE }
    
    private Suit suit;
    
    private Face face;

    public Face getFace() {
        return face;
    }
    
    public Suit getSuit() {
        return suit;
    }
    
    @Override
    public int compareTo(Card o) {
        return face.ordinal() - o.face.ordinal();
    }
    
    @Override
    public String toString()
    {
        return face.toString() + " of " + suit.toString();
    }
    
}