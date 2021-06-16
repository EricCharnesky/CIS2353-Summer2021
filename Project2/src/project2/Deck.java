
package project2;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;
    
    public Deck(){
        cards = new ArrayList<>();
        
        for ( Card.Face face : Card.Face.values() ){
            for ( Card.Suit suit : Card.Suit.values() ){
                cards.add( new Card(face, suit));
            } 
        } 
        
        Collections.shuffle(cards);
        
    }
    
    public Card draw(){
        return cards.remove(cards.size()-1);
    }
    
    public boolean isEmpty(){
        return cards.isEmpty();
    }
}
