package Deck;

public enum CardSuit {
    HEARTS("Hearts"),SPADES("Spades"),CLUBS("Clubs"),DIAMONDS("Diamonds");

    private final String suitText;

    CardSuit(String suitText) {
        this.suitText = suitText;
    }

    public String getSuitText() {
        return this.suitText;
    }
}
