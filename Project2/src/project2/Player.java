package project2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Player {

    private Stack<Card> cards;
    private ArrayList<Card> pile;

    public Player() {
        cards = new Stack<>();
        pile = new ArrayList<>();
    }

    public void dealCard(Card card) {
        cards.push(card);
    }

    public Card playCard() {
        Card card = cards.pop();
        if ( cards.isEmpty()){
            shufflePileIntoStack();
        }
        return card;
    }

    public void winCards(ArrayList<Card> cards) {
        pile.addAll(cards);
    }

    public void shufflePileIntoStack() {
        Collections.shuffle(pile);
        for (Card card : pile) {
            cards.push(card);
        }
        pile.clear();
    }

    public int cardsInStack() {
        return cards.size();
    }

    public boolean isOutOfCards() {
        return cards.isEmpty();
    }
}
