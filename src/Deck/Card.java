package Deck;

/**
 * This class builds an object Card. Card is comprised of a rank and suit. Card implements comparable<Card> and can
 * use the compareTo function to compare another card.
 *
 * @author Ed
 */
public class Card implements Comparable<Card> {

    private CardRank rank;
    private CardSuit suit;


    /**
     * Constructor Card
     *
     * @param rank
     * @param suit
     */
    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * compareTo function used to compare to objects of card by ranking.
     *
     * @param secondCard
     * @return
     */
    public int compareTo(Card secondCard) {
        return this.getRank().compareTo(secondCard.getRank());
    }


    public Integer getRank() {
        return rank.getValue();
    }

    public String printRank() {
        return rank.getFullName();
    }

    /**
     * toString Override formats a card printout as "Rank of Suit", ex. "Ace of Hearts"
     *
     * @return
     */
    @Override
    public String toString() {
        return this.printRank() + " of " + this.suit.getSuitText();
    }
}
