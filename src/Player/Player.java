package Player;

import Deck.Hand;

public class Player {

    private String name;
    private Hand hand;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) { this.name = name; }

    public Hand getHand() { return this.hand; }

    public void setHand(Hand hand) { this.hand = hand; }

}
