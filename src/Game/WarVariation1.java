package Game;

import Deck.Deck;
import Player.Player;
import Deck.Hand;
import Deck.Card;

import java.util.ArrayList;

/**
 * WarVariation1 class. WarVariation1 extends War and is used to simulate the first version of the War game. In this version
 * you will place won cards on the bottom of the players hand, so having a set number of iterations due to the possible
 * length of this game is needed. Iteration is set to 500. Winner is the player with most cards in hand at the end of game.
 */
public class WarVariation1 extends War {

    /**
     * WarVariation1 constructor. Two players and a deck.
     *
     * @param player1
     * @param player2
     * @param deck
     */
    WarVariation1(Player player1, Player player2, Deck deck) {
        super(player1, player2, deck);
    }

    static int pointsEarned = 0;
    static int gameVariation = 1;

    /**
     * startGame. Initiates warVariation1. Stops if player(s) run out of cards in hand or iterations are up.
     */
    public void startGame() {
        message.openingWarVariation(gameVariation, iterations);
        setHands(player1, player2, deck);
        while (versus(player1, player2, null)) {
            iterations--;
            message.checkIterations(iterations);
            if (player1.getHand().sizeOfHand() == 0) {
                winner = player2;
                break;
            } else if (player2.getHand().sizeOfHand() == 0) {
                winner = player1;
                break;
            }
            if (iterations < 0)
                break;
        }
        determineOutcome(gameVariation);
    }

    /**
     * versus. Removes card from hand to play and compares card.
     *
     * @param player1
     * @param player2
     * @param pile
     * @return
     */
    public boolean versus(Player player1, Player player2, Hand pile) {
        Card player1FaceCard = player1.getHand().removeCardFromTop();
        Card player2FaceCard = player2.getHand().removeCardFromTop();
        if (player1FaceCard == null || player2FaceCard == null)
            return false;
        if (pile == null)
            pile = new Hand();
        pile.addCardToTop(player1FaceCard);
        pile.addCardToTop(player2FaceCard);
        int compareCards = player1FaceCard.compareTo(player2FaceCard);
        return warRound(compareCards, pile, player1FaceCard, player2FaceCard);
    }

    /**
     * warRound. Based off of compareTo from card you will get a 0, 1, or -1 based off of card 1 vs card 2. Redirects based off that.
     * 0 Initiates war, 1 player1 wins the round, -1 player2 wins the round.
     *
     * @param compareCards
     * @param pile
     * @param player1FaceCard
     * @param player2FaceCard
     * @return
     */
    public boolean warRound(int compareCards, Hand pile, Card player1FaceCard, Card player2FaceCard) {
        switch (compareCards) {
            case 0:
                boolean check = drawThree(pile, player1FaceCard, player2FaceCard);
                message.announceWar();
                if (check == false)
                    return false;
                return versus(player1, player2, pile);
            case 1:
                playerConfigurePoints(player1FaceCard, player2FaceCard, 1, pointsEarned, gameVariation);
                player1.getHand().mergeHand(pile);
                pointsEarned = 0;
                break;
            case -1:
                playerConfigurePoints(player1FaceCard, player2FaceCard, 2, pointsEarned, gameVariation);
                player2.getHand().mergeHand(pile);
                pointsEarned = 0;
                break;
        }
        return true;
    }

    /**
     * drawThree. This is war! Draws 3 cards and sees if it was possible.
     *
     * @param pile
     * @param player1FaceCard
     * @param player2FaceCard
     * @return
     */
    public boolean drawThree(Hand pile, Card player1FaceCard, Card player2FaceCard) {
        message.announceTurn(player1, player2, player1FaceCard, player2FaceCard);
        ArrayList<Card> player1Pile = player1.getHand().take(3);
        ArrayList<Card> player2Pile = player2.getHand().take(3);
        if (player1Pile == null || player2Pile == null)
            return false;
        pile.addAllCardsToTop(player1Pile);
        pile.addAllCardsToTop(player2Pile);
        pointsEarned += 4;
        return true;
    }

}

