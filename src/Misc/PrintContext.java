package Misc;

import Deck.Card;
import Player.Player;

/**
 * PrintContext class. Used as context for the stdout type of game.
 */
public class PrintContext {

    /**
     * openingWarVariation. Used at the beginning of the game to introduce the players.
     *
     * @param variation
     * @param iterations
     */
    public void openingWarVariation(int variation, int iterations) {
        System.out.println("War Variation " + variation + " is beginning!");
        if (iterations == 26)
            System.out.println("Let the best player win, up to: " + iterations);
        else if (iterations < 26)
            System.out.println("Winner is player with most cards in points pile at the end of the game");
        else
            System.out.println("Let the best player win, but in case of a tie we've set the iterations to: " + iterations);
    }

    /**
     * checkIterations. Checks iterations and stdout a message based off of progress.
     *
     * @param iterations
     */
    public void checkIterations(int iterations) {
        if (iterations % 100 == 0 && iterations != 0)
            System.out.println("=================== Possible turns left: " + iterations + " ===================");
        else if (iterations == 0)
            System.out.println("=================== Last Turn ===================");
    }

    /**
     * announceTurn. Overloaded for 2 or 3 players it announces the turn.
     *
     * @param player1
     * @param player2
     * @param player3
     * @param card1
     * @param card2
     * @param card3
     */
    public void announceTurn(Player player1, Player player2, Player player3, Card card1, Card card2, Card card3) {
        System.out.println(player1.getName() + " plays " + card1 + " as up card");
        System.out.println(player2.getName() + " plays " + card2 + " as up card");
        System.out.println(player3.getName() + " plays " + card3 + " as up card");
    }

    public void announceTurn(Player player1, Player player2, Card card1, Card card2) {
        System.out.println(player1.getName() + " plays " + card1 + " as up card");
        System.out.println(player2.getName() + " plays " + card2 + " as up card");
    }

    /**
     * announceScore. Overloaded for 2 or 3 players it announces the score.
     *
     * @param player1
     * @param player2
     * @param player3
     */
    public void announceScore(Player player1, Player player2, Player player3) {
        System.out.println("Score is " + player1.getName() + " " + player1.getScore() + ", " + player2.getName() + " " +
                player2.getScore() + ", " + player3.getName() + " " + player3.getScore());
    }

    public void announceScore(Player player1, Player player2) {
        System.out.println("Score is " + player1.getName() + " " + player1.getScore() + ", " + player2.getName() +
                " " + player2.getScore());
    }

    /**
     * announceRoundWinner. Announces who won the round.
     *
     * @param player
     */
    public void announceRoundWinner(Player player) {
        System.out.println(player.getName() + " wins the round");
    }

    /**
     * announceWar. Announces if War was initiated.
     */
    public void announceWar() {
        System.out.println("War!");
    }

    /**
     * announceWinner. Announces who won.
     *
     * @param player
     */
    public void announceWinner(Player player) {
        System.out.println(player.getName() + " wins!");
    }

    /**
     * announceTie. Announces if there was a tie game.
     */
    public void announceTie() {
        System.out.println("Tie game!");
    }
}
