package Deck;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Deck class. Deck class extends Hand as a different type of collection of cards. Performs common functionality
 * that a deck typically does such as, shuffle, draw, etc.
 *
 * @author Ed
 */
public class Deck extends Hand {

    private final ArrayList<Card> cards = new ArrayList<Card>();

    /**
     * Deck constructor.
     */
    public Deck() {
        addAllCardsToDeck();
    }

    /**
     * addAllCardsToDeck. This populates our deck. It grabs a suit value for every rank value. 52 card deck is the outcome.
     */
    public void addAllCardsToDeck() {
        for (CardSuit suit : CardSuit.values()) {
            for (CardRank rank : CardRank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    /**
     * shuffle. Uses the ArrayList library to shuffle the "cards" at random.
     */
    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    /**
     * draw. Returns a card when drawn.
     *
     * @return
     */
    public Card draw() {
        return this.cards.remove(this.cards.size() - 1);
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    /**
     * toString. toString override from the card class.
     *
     * @return
     */
    @Override
    public String toString() {
        return this.cards.toString();
    }

}


