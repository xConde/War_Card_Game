package Deck;

import Player.Player;

import java.util.ArrayList;


public class Hand {

    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<Card>();
    }

    public void mergeHand(Hand otherHand) {
        for (Card card: otherHand.cards) {
            this.addCardToBottom(card);
        }
    }

    public ArrayList<Card> take(int quantityCards) {
        if (quantityCards > this.sizeOfHand())
            return null;
        ArrayList<Card> remove = new ArrayList<>();
        for (int i = 0; i < quantityCards; i++) {
            remove.add(this.cards.remove(this.sizeOfHand() - 1));
        }

        return remove;
    }

    public void addCardToTop(Card card) {
        if (card == null)
            throw new NullPointerException("Can't add null card to top.: addCardToTop");
        cards.add(card);
    }

    public void addAllCardsToTop(ArrayList<Card> pile) { this.cards.addAll(pile); }

    public void addCardToBottom(Card card) { cards.add(0, card); }

    public Card removeCardFromTop() {
        if (sizeOfHand() < 1)
            return null;
        return cards.remove(sizeOfHand() - 1);
    }

    public Card removeCardFromBottom() {
        if (sizeOfHand() < 1)
            return null;
        return cards.remove(0);
    }

    public int sizeOfHand() { return cards.size(); }

}
