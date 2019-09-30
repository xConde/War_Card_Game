package Game;

import Deck.*;
import Misc.PrintContext;
import Player.Player;
import Deck.Hand;

/**
 * War. War is the super class of WarVariation1, WarVariation2, & WarVariation3. It has overloaded constructors, overloaded methods
 * and a lot of shared logic between the three of the versions of the game.
 *
 * @author Ed
 */
public class War {

    Deck deck;
    Player player1, player2, player3;
    Player winner = null;
    int iterations = 500;

    /**
     * message. Instantiates a new PrintContext object to be used for out printing game messages to stdout.
     */
    public static PrintContext message = new PrintContext();

    /**
     * War Constructor. Overloaded for 3 players.
     *
     * @param player1
     * @param player2
     * @param player3
     * @param deck
     */
    War(Player player1, Player player2, Player player3, Deck deck) {
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.deck = deck;
    }

    /**
     * War Constructor. Overloaded for 2 players.
     *
     * @param player1
     * @param player2
     * @param deck
     */
    War(Player player1, Player player2, Deck deck) {
        this.player1 = player1;
        this.player2 = player2;
        this.deck = deck;
    }

    /**
     * setHands. Overloaded for 2 and 3 players. Gets the inital setup for player's hands and how many cards they'll have.
     *
     * @param player1
     * @param player2
     * @param player3
     * @param deck
     */
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

    /**
     * splitDeck. Populates cards into players hand from the deck.
     *
     * @param hand
     * @param players
     * @param deck
     */
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

    /**
     * determineOutcome. At the end of any game we need to decide which player won the game. gameVersion is passed as a
     * argument to determine which game they are playing. If the version is less than 3 we will only have two players. If
     * there is no winner we announce a tie.
     *
     * @param gameVersion
     */
    public void determineOutcome(int gameVersion) {
        if (gameVersion == 1 || gameVersion == 2) {
            if (player1.getScore() > player2.getScore())
                winner = player1;
            else if (player2.getScore() > player1.getScore())
                winner = player2;
            else {
                message.announceTie();
                return;
            }
        } else {
            if (player1.getScore() > player2.getScore() && player1.getScore() > player3.getScore())
                winner = player1;
            else if (player2.getScore() > player1.getScore() && player2.getScore() > player3.getScore())
                winner = player2;
            else if (player3.getScore() > player1.getScore() && player3.getScore() > player2.getScore())
                winner = player3;
            else {
                message.announceTie();
                return;
            }
        }
        message.announceWinner(winner);
    }

    /**
     * playerConfigurePoints. Overloaded for 2 or 3 players. This will determine a winner based on who triggered it and assign points
     * to that winner's score.
     *
     * @param player1FaceCard
     * @param player2FaceCard
     * @param player3FaceCard
     * @param trigger
     * @param pointsEarned
     */
    public void playerConfigurePoints(Card player1FaceCard, Card player2FaceCard, Card player3FaceCard, int trigger, int pointsEarned) {
        Player playerWonRound = roundWinner(trigger);
        message.announceTurn(player1, player2, player3, player1FaceCard, player2FaceCard, player3FaceCard);
        message.announceRoundWinner(playerWonRound);
        sortPoints(playerWonRound, pointsEarned, 2);
    }

    public void playerConfigurePoints(Card player1FaceCard, Card player2FaceCard, int trigger, int pointsEarned, int gameVariation) {
        Player playerWonRound = roundWinner(trigger);
        message.announceTurn(player1, player2, player1FaceCard, player2FaceCard);
        message.announceRoundWinner(playerWonRound);
        sortPoints(playerWonRound, pointsEarned, gameVariation);
    }

    /**
     * roundWinner. Returns player who won based on who triggered it.
     *
     * @param trigger
     * @return
     */
    public Player roundWinner(int trigger) {
        if (trigger == 1)
            return player1;
        else if (trigger == 2)
            return player2;
        else
            return player3;
    }

    /**
     * sortPoints. Assigns points to the winner and takes into consideration if pointsEarned is greater than 0. If it is
     * than it will be added to the players score total, else it adds the iterated amount based on gameVariation.
     *
     * @param playerWonRound
     * @param pointsEarned
     * @param gameVariation
     */
    public void sortPoints(Player playerWonRound, int pointsEarned, int gameVariation) {
        if (playerWonRound == player1) {
            if (pointsEarned > 0)
                player1.setScore(player1.getScore() + pointsEarned);
            else
                player1.setScore(player1.getScore() + gameVariation);
        } else if (playerWonRound == player2) {
            if (pointsEarned > 0)
                player2.setScore(player2.getScore() + pointsEarned);
            else
                player2.setScore(player2.getScore() + gameVariation);
        } else {
            if (pointsEarned > 0)
                player3.setScore(player3.getScore() + pointsEarned);
            else
                player3.setScore(player3.getScore() + gameVariation);
        }
        if (player1 != null && player2 != null && player3 != null)
            message.announceScore(player1, player2, player3);
        else
            message.announceScore(player1, player2);
    }

}
