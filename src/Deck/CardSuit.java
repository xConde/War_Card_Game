package Deck;

/**
 * CardSuit enum
 *
 * @author Ed
 */
public enum CardSuit {
    HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");

    private final String suitText;

    /**
     * CardSuit constructor takes in a specified text for CardSuit. Changes it from the default all caps to an
     * easier to read capitalization.
     *
     * @param suitText
     */
    CardSuit(String suitText) {
        this.suitText = suitText;
    }

    public String getSuitText() {
        return this.suitText;
    }
}
