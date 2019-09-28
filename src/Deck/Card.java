package Deck;

public class Card implements Comparable<Card> {

    private CardRank rank;
    private CardSuit suit;

    public Card (CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int compareTo(Card secondCard) { return this.getRank().compareTo(secondCard.getRank()); }

    public boolean sameRank(Card secondCard) { return rank.equals(secondCard.rank); }

    public String getSuit() {
        return suit.getSuitText();
    }

    public Integer getRank() {
        return rank.getValue();
    }

    public String printRank() {
        return rank.getFullName();
    }

    @Override
    public String toString() { return this.printRank() + " of " + this.suit.getSuitText(); }
}
