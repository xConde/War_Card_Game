package Game;

import Deck.Deck;
import Player.Player;

/**
 * Launcher. Our main that kicks everything off. WarVariations are commented out when not in use.
 *
 * @author Ed
 */
public class Launcher {

    /**
     * main. Creates an environment to run a scenario 1, 2, or 3.
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            Deck deck = new Deck();
            deck.addAllCardsToDeck();
            deck.shuffle();
            int player1Points = 0, player2Points = 0, player3Points = 0;

            Player sue = new Player("Sue", player1Points);
            Player bob = new Player("Bob", player2Points);
            Player joe = new Player("Joe", player3Points);

            //   WarVariation1 game = new WarVariation1(sue, bob, deck);
            //   WarVariation2 game = new WarVariation2(sue, bob, deck);
               WarVariation3 game = new WarVariation3(sue, bob, joe, deck);

            game.startGame();

        } catch (GameException e) {
            e.printStackTrace();
        }
    }
}

