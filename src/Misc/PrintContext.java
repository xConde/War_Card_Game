package Misc;

import Deck.Card;
import Player.Player;

public class PrintContext {

    public void openingWarVariation(int variation, int iterations) {
        System.out.println("War Variation " + variation + " is beginning!");
        System.out.println("Let the best player win, but in case of a tie we've set the iterations to: " + iterations);
    }

    public void announceTurn(Player player1, Player player2, Player player3, Card card1, Card card2, Card card3) {
        System.out.println(player1.getName() + " plays " + card1 + " as up card");
        System.out.println(player2.getName() + " plays " + card2 + " as up card");
        System.out.println(player3.getName() + " plays " + card3 + " as up card");
    }

    public void announceTurn(Player player1, Player player2, Card card1, Card card2) {
        System.out.println(player1.getName() + " plays " + card1 + " as up card");
        System.out.println(player2.getName() + " plays " + card2 + " as up card");
    }

    public void announceScore(Player player1, Player player2, Player player3) {
        System.out.println("Score is " + player1 + " " + player1.getHand().sizeOfHand() + ", " + player2 + " " +
                player2.getHand().sizeOfHand() + ", " + player3 + " " + player3.getHand().sizeOfHand());
    }

    public void announceScore(Player player1, Player player2) {
        System.out.println("Score is " + player1.getName() + " " + player1.getHand().sizeOfHand() + ", " + player2.getName() +
                " " + player2.getHand().sizeOfHand());
    }

    public void announceRoundWinner(Player player) { System.out.println( player.getName() + " wins the round"); }

    public void announceWar() { System.out.println("War!"); }

    public void announceWinner(Player player) { System.out.println(player.getName() + " wins!"); }

    public void announceTie() { System.out.println("Tie game!"); }
}
