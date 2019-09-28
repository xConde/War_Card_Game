package Deck;

import java.util.ArrayList;
import java.util.Collections;

public class Deck extends Hand {

    private final ArrayList<Card> cards = new ArrayList<Card>();

    public Deck() {
        addAllCardsToDeck();
    }

    public void addAllCardsToDeck() {
        for (CardSuit suit: CardSuit.values()) {
            for (CardRank rank: CardRank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public void shuffle() { Collections.shuffle(this.cards); }

    public Card draw() { return this.cards.remove(this.cards.size() - 1); }

    public ArrayList<Card> getCards() { return this.cards; }

    @Override
    public String toString() { return this.cards.toString(); }

}


