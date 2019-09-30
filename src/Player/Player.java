package Player;

import Deck.Hand;

/**
 * Player class. Player is used to make an object, Player that has a name and a score to their person.
 */
public class Player {

    private String name;
    private Hand hand;
    private int score;

    /**
     * Player constructor.
     *
     * @param name
     * @param score
     */
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return this.hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

}
