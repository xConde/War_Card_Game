package Game;

import Deck.Deck;
import Misc.PrintContext;
import Player.Player;
import Deck.Hand;



public class War {

    Deck deck;
    Player player1;
    Player player2;
    Player player3;
    Player winner = null;
    int iterations = 500;
    public static PrintContext message = new PrintContext();

    War(Player player1, Player player2, Player player3, Deck deck) {
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.deck = deck;
    }

    War(Player player1, Player player2, Deck deck) {
        this.player1 = player1;
        this.player2 = player2;
        this.deck = deck;
    }

    public void setHands(Player player1, Player player2, Player player3, Deck deck) {
        player1.setHand(new Hand());
        player2.setHand(new Hand());
        player3.setHand(new Hand());
        splitDeck(player1.getHand(), 3, deck);
        splitDeck(player2.getHand(), 3, deck);
        splitDeck(player3.getHand(), 3, deck);
    }

    public void setHands(Player player1, Player player2, Deck deck) {
        player1.setHand(new Hand());
        player2.setHand(new Hand());
        splitDeck(player1.getHand(), 2, deck);
        splitDeck(player2.getHand(), 2, deck);
    }

    public void splitDeck(Hand hand, int players, Deck deck) {
        if (players == 2) {
            for (int i = 0; i < 26; i++) {
                hand.addCardToTop(deck.draw());
            }
        } else if (players == 3) {
            for (int i = 0; i < 17; i++) {
                hand.addCardToTop(deck.draw());
            }
        }

    }






}
