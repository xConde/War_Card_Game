package Game;

import Deck.Deck;
import Player.Player;

public class Launcher {

    public static void main(String[] args) {
        try {
            Deck deck = new Deck();
            deck.addAllCardsToDeck();
          //  deck.shuffle();

            Player sue = new Player("Sue");
            Player bob = new Player("Bob");
            Player joe = new Player("Joe");

            WarVariation1 game = new WarVariation1(sue, bob, deck);
           // War game = new WarVariation2(sue, bob, deck);
          //  War game = new WarVariation3(sue, bob, joe, deck);

          //  game.dealCardsToPlayers();
            game.startGame();

    /*        if (game.getWinningPlayer() == Player.NO_PLAYER)
                System.out.println("Tie game!");
            else
                System.out.println(game.getWinningPlayer() + " wins the game!"); */
        } catch (GameException e) {
          //  System.out.println(e.GetMessage());
        }

    }
}

