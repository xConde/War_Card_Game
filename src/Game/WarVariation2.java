package Game;

import Deck.*;
import Player.Player;

import java.util.ArrayList;

/**
 * WarVariation2. WarVariation2 extends War class. Placing won cards in a separate point pile, winner is player with most cards in their pile
 * at the end of the game.
 * @author Ed
 */
public class WarVariation2 extends War {

    /**
     * WarVariation2 constructor.
     * @param player1
     * @param player2
     * @param deck
     */
    WarVariation2(Player player1, Player player2, Deck deck) { super(player1, player2, deck); }

    static int pointsEarned = 0;
    int iterations = 26;
    static int gameVariation = 2;

    /**
     * startGame. Initiates warVariation2. Stops if player(s) run out of cards in hand or iterations are up.
     */
    public void startGame() {
        message.openingWarVariation(gameVariation, iterations);
        setHands(player1, player2, deck);
        while (versus(player1, player2)) { }
        determineOutcome(gameVariation);
    }

    /**
     * versus. Removes card from hand to play and compares card.
     * @param player1
     * @param player2
     * @return
     */
    public boolean versus(Player player1, Player player2) {
        Card player1FaceCard = player1.getHand().removeCardFromTop();
        Card player2FaceCard = player2.getHand().removeCardFromTop();
        if (player1FaceCard == null || player2FaceCard == null )
            return false;
        int compareCards = player1FaceCard.compareTo(player2FaceCard);
        return warRound(compareCards, player1FaceCard, player2FaceCard);
    }

    /**
     * warRound. Based off of compareTo from card you will get a 0, 1, or -1 based off of card 1 vs card 2. Redirects based off that.
     * 0 Initiates war, 1 player1 wins the round, -1 player2 wins the round.
     * @param compareCards
     * @param player1FaceCard
     * @param player2FaceCard
     * @return
     */
    public boolean warRound(int compareCards, Card player1FaceCard, Card player2FaceCard) {
        switch (compareCards) {
            case 0:
                boolean check = drawThree(player1FaceCard, player2FaceCard);
                message.announceWar();
                if (check == false)
                    return false;
                return versus(player1, player2);
            case 1:
                playerConfigurePoints(player1FaceCard, player2FaceCard, 1, pointsEarned, gameVariation);
                pointsEarned = 0;
                break;
            case -1:
                playerConfigurePoints(player1FaceCard, player2FaceCard, 2, pointsEarned, gameVariation);
                pointsEarned = 0;
                break;
        }
        return true;
    }

    /**
     * drawThree. This is war! Draws 3 cards and sees if it was possible.
     * @param player1FaceCard
     * @param player2FaceCard
     * @return
     */
    public boolean drawThree(Card player1FaceCard, Card player2FaceCard) {
        message.announceTurn(player1, player2, player1FaceCard, player2FaceCard);
        ArrayList<Card> player1Pile = player1.getHand().take(3);
        ArrayList<Card> player2Pile = player2.getHand().take(3);
        if (player1Pile == null || player2Pile == null)
            return false;
        pointsEarned += 8;
        return true;
    }
}
