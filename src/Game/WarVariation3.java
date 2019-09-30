package Game;

import Deck.*;
import Player.Player;

import java.util.ArrayList;

/**
 * WarVariation1 class. WarVariation1 extends War and is used to simulate the third version of the War game. In this version
 * you will have three players and they will win by placing cards won in a separate pile. The player with the most cards in their
 * pile at the end of the deck wins.
 *
 * @author Ed
 */
public class WarVariation3 extends War {
    /**
     * WarVariation3 constructor.
     *
     * @param player1
     * @param player2
     * @param player3
     * @param deck
     */
    WarVariation3(Player player1, Player player2, Player player3, Deck deck) {
        super(player1, player2, player3, deck);
    }

    static int pointsEarned = 0;
    int iterations = 17;
    int gameVariation = 3;


    /**
     * startGame. Initiates warVariation3. Stops if player(s) run out of cards in hand or iterations are up.
     */
    public void startGame() {
        message.openingWarVariation(gameVariation, iterations);
        setHands(player1, player2, player3, deck);
        while (versus(player1, player2, player3)) {
        }
        determineOutcome(gameVariation);
    }

    /**
     * versus. Removes card from hand to play and compares card.
     *
     * @param player1
     * @param player2
     * @param player3
     * @return
     */
    public boolean versus(Player player1, Player player2, Player player3) {
        Card player1FaceCard = player1.getHand().removeCardFromTop();
        Card player2FaceCard = player2.getHand().removeCardFromTop();
        Card player3FaceCard = player3.getHand().removeCardFromTop();
        if (player1FaceCard == null || player2FaceCard == null || player3FaceCard == null)
            return false;
        // modifyPile(pile, player1FaceCard, player2FaceCard, player3FaceCard);
        return compareAllPlayers(player1FaceCard, player2FaceCard, player3FaceCard);
    }

    /**
     * modifyPile. Creates a pile if null and adds players facecards to it.
     *
     * @param pile
     * @param player1FaceCard
     * @param player2FaceCard
     * @param player3FaceCard
     */
    public void modifyPile(Hand pile, Card player1FaceCard, Card player2FaceCard, Card player3FaceCard) {
        if (pile == null)
            pile = new Hand();
        pile.addCardToTop(player1FaceCard);
        pile.addCardToTop(player2FaceCard);
        pile.addCardToTop(player3FaceCard);
    }

    /**
     * compareAllPlayers. Compares all three players at once and finds a winner. If there is no winner that means there is a tie (war)
     *
     * @param player1FaceCard
     * @param player2FaceCard
     * @param player3FaceCard
     * @return
     */
    public boolean compareAllPlayers(Card player1FaceCard, Card player2FaceCard, Card player3FaceCard) {
        if (player1FaceCard.compareTo(player2FaceCard) == 1 && player1FaceCard.compareTo(player3FaceCard) == 1)
            playerConfigurePoints(player1FaceCard, player2FaceCard, player3FaceCard, 1, pointsEarned);
        else if (player2FaceCard.compareTo(player1FaceCard) == 1 && player2FaceCard.compareTo(player3FaceCard) == 1)
            playerConfigurePoints(player1FaceCard, player2FaceCard, player3FaceCard, 2, pointsEarned);
        else if (player3FaceCard.compareTo(player1FaceCard) == 1 && player3FaceCard.compareTo(player2FaceCard) == 1)
            playerConfigurePoints(player1FaceCard, player2FaceCard, player3FaceCard, 3, pointsEarned);
        else {
            boolean check = drawThree(player1FaceCard, player2FaceCard, player3FaceCard);
            message.announceWar();
            if (check == false)
                return false;
            return versus(player1, player2, player3);
        }
        pointsEarned = 0;
        return true;
    }

    /**
     * drawThree. This is war! Draws 3 cards and sees if it was possible.
     *
     * @param player1FaceCard
     * @param player2FaceCard
     * @param player3FaceCard
     * @return
     */
    public boolean drawThree(Card player1FaceCard, Card player2FaceCard, Card player3FaceCard) {
        message.announceTurn(player1, player2, player3, player1FaceCard, player2FaceCard, player3FaceCard);
        ArrayList<Card> player1Pile = player1.getHand().take(3);
        ArrayList<Card> player2Pile = player2.getHand().take(3);
        ArrayList<Card> player3Pile = player3.getHand().take(3);

        if (player1Pile == null || player2Pile == null || player3Pile == null)
            return false;

        pointsEarned += 12;
        return true;
    }

}
