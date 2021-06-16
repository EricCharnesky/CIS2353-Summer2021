package project2;

import java.util.ArrayList;

public class Project2 {

    public static void main(String[] args) {
        int totalTurns = 0;

        for (int numberOfDecks = 1; numberOfDecks <= 10; numberOfDecks++) {

            for (int turn = 0; turn < 100; turn++) {

                Player firstPlayer = new Player();
                Player secondPlayer = new Player();

                for (int deckCount = 0; deckCount < numberOfDecks; deckCount++) {

                    Deck deck = new Deck();

                    while (!deck.isEmpty()) {
                        firstPlayer.dealCard(deck.draw());
                        secondPlayer.dealCard(deck.draw());
                    }
                }

                int turnCount = 0;
                while (!firstPlayer.isOutOfCards() && !secondPlayer.isOutOfCards()) {
                    turnCount++;

                    Card firstPlayerCard = firstPlayer.playCard();
                    Card secondPlayerCard = secondPlayer.playCard();

                    ArrayList<Card> pile = new ArrayList<>();
                    pile.add(firstPlayerCard);
                    pile.add(secondPlayerCard);

                    //System.out.println("Player One: " + firstPlayerCard);
                    //System.out.println("Player Two: " + secondPlayerCard);
                    int result = firstPlayerCard.compareTo(secondPlayerCard);

                    while (!firstPlayer.isOutOfCards() && !secondPlayer.isOutOfCards()
                            && result == 0) {

                        int warCardsPlayed = 0;
                        while (!firstPlayer.isOutOfCards() && !secondPlayer.isOutOfCards()
                                && warCardsPlayed < 3) {
                            pile.add(firstPlayer.playCard());
                            pile.add(secondPlayer.playCard());
                            warCardsPlayed++;
                        }
                        if (!firstPlayer.isOutOfCards() && !secondPlayer.isOutOfCards()) {
                            firstPlayerCard = firstPlayer.playCard();
                            secondPlayerCard = secondPlayer.playCard();

                            pile.add(firstPlayerCard);
                            pile.add(secondPlayerCard);

                            //System.out.println("WAR!");
                            //System.out.println("Player One: " + firstPlayerCard);
                            //System.out.println("Player Two: " + secondPlayerCard);
                            result = firstPlayerCard.compareTo(secondPlayerCard);
                        }

                    }
                    if (result > 0) {
                        firstPlayer.winCards(pile);
                        if (firstPlayer.isOutOfCards()) {
                            firstPlayer.shufflePileIntoStack();
                        }
                    } else if (result < 0) {
                        secondPlayer.winCards(pile);
                        if (secondPlayer.isOutOfCards()) {
                            secondPlayer.shufflePileIntoStack();
                        }
                    }
                }
                totalTurns += turnCount;
                //System.out.println("Number of turns until someone ran out of cards: " + turnCount);
            }

            System.out.println("Average number of turns for " 
                    + numberOfDecks + " decks: " + totalTurns / 100);

        }
    }

}
