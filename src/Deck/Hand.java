package Deck;

import Player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Hand class. Creates multiples of the object Card and utilizes the ArrayList for functionality and to store them.
 *
 * @author Ed
 */
public class Hand {

    private ArrayList<Card> cards;

    /**
     * Hand constructor.
     */
    public Hand() {
        cards = new ArrayList<Card>();
    }

    /**
     * mergeHand takes a pile of cards and tosses it into a pile at the bottom of the hand. Used for WarVariation1
     * to throw winnings back into the player who won the round pile.
     *
     * @param otherHand
     */
    public void mergeHand(Hand otherHand) {
        for (Card card : otherHand.cards) {
            this.addCardToBottom(card);
        }
    }

    /**
     * Take. Used by drawThree method in all warVariations. Used to take a specified quantity of cards from the players
     * remaining hand.
     *
     * @param quantityCards
     * @return
     */
    public ArrayList<Card> take(int quantityCards) {
        if (quantityCards > this.sizeOfHand())
            return null;
        ArrayList<Card> remove = new ArrayList<>();
        for (int i = 0; i < quantityCards; i++) {
            remove.add(this.cards.remove(this.sizeOfHand() - 1));
        }
        return remove;
    }

    /**
     * addCardToTop. Uses the ArrayList functionality to add a card to the top.
     *
     * @param card
     */
    public void addCardToTop(Card card) {
        cards.add(card);
    }

    /**
     * addAllCardsToTop. Takes an ArrayList of cards (pile) to add all cards to the top.
     *
     * @param pile
     */
    public void addAllCardsToTop(ArrayList<Card> pile) {
        this.cards.addAll(pile);
    }

    /**
     * addCardToBottom. Throws card to index 0 (bottom)
     *
     * @param card
     */
    public void addCardToBottom(Card card) {
        cards.add(0, card);
    }

    /**
     * removeCardFromTop. If there are 1 or more cards remaining you may remove a card from the top.
     *
     * @return
     */
    public Card removeCardFromTop() {
        if (sizeOfHand() < 1)
            return null;
        return cards.remove(sizeOfHand() - 1);
    }

    /**
     * sizeOfHand. Returns the quantity of cards in the hand currently.
     *
     * @return
     */
    public int sizeOfHand() {
        return cards.size();
    }

}
