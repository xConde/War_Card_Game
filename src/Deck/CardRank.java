package Deck;

/**
 * CardRank enum
 *
 * @author Ed
 */
public enum CardRank {
    TWO(2, "Two"), THREE(3, "Three"),
    FOUR(4, "Four"), FIVE(5, "Five"), SIX(6, "Six"),
    SEVEN(7, "Seven"), EIGHT(8, "Eight"), NINE(9, "Nine"),
    TEN(10, "Ten"), JACK(11, "Jack"), QUEEN(12, "Queen"),
    KING(13, "King"), ACE(14, "Ace");

    private final int value;
    private final String fullName;

    /**
     * CardRank constructor allows for value, then a proper full name provided.
     *
     * @param value
     * @param fullName
     */
    CardRank(int value, String fullName) {
        this.value = value;
        this.fullName = fullName;
    }

    public int getValue() {
        return this.value;
    }

    public String getFullName() {
        return this.fullName;
    }
}
