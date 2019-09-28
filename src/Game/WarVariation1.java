package Game;

import Deck.Deck;
import Player.Player;
import Deck.Hand;
import Deck.Card;

import java.util.ArrayList;

public class WarVariation1 extends War {

    WarVariation1(Player player1, Player player2, Deck deck) { super(player1, player2, deck); }

    public void startGame() {
        message.openingWarVariation(1, iterations);
        setHands(player1, player2, deck);
        boolean stillPlaying = true;
        while (stillPlaying) {
            stillPlaying = versus(player1, player2, null);
            iterations--;

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
        determineOutcome();
    }

    public void determineOutcome() {
        if (player1.getHand().sizeOfHand() > player2.getHand().sizeOfHand())
            winner = player1;
        else if (player2.getHand().sizeOfHand() > player1.getHand().sizeOfHand())
            winner = player2;
        else {
            message.announceTie();
            return;
        }
        message.announceWinner(winner);
    }

    public boolean versus(Player player1, Player player2, Hand pile) {
        Card player1FaceCard = player1.getHand().removeCardFromTop();
        Card player2FaceCard = player2.getHand().removeCardFromTop();
        if (player1FaceCard == null || player2FaceCard == null )
            return false;
        if (pile == null)
            pile = new Hand();

        pile.addCardToTop(player1FaceCard);
        pile.addCardToTop(player2FaceCard);
        int compareCards = player1FaceCard.compareTo(player2FaceCard);
        boolean result = true;
        result = warRound(compareCards, pile, player1FaceCard, player2FaceCard);
        if (result == false)
            return false;
        return true;
    }

    public boolean warRound(int result, Hand pile, Card player1FaceCard, Card player2FaceCard) {
        boolean check = true;
        switch(result) {
            case 0:
                check = drawThree(pile);
                if (check == false)
                    return false;
                return versus(player1, player2, pile);
            case 1:
                player1WinsRound(player1, player2, player1FaceCard, player2FaceCard, pile);
                break;
            case 2:
                player2WinsRound(player1, player2, player1FaceCard, player2FaceCard, pile);
                break;
        }
        return true;
    }

    public void player1WinsRound(Player player1, Player player2, Card player1FaceCard, Card player2FaceCard, Hand pile) {
        player1.getHand().mergeHand(pile);
        message.announceTurn(player1, player2, player1FaceCard, player2FaceCard);
        message.announceScore(player1, player2);
        message.announceRoundWinner(player1);
    }

    public void player2WinsRound(Player player1, Player player2, Card player1FaceCard, Card player2FaceCard, Hand pile) {
        player2.getHand().mergeHand(pile);
        message.announceTurn(player1, player2, player1FaceCard, player2FaceCard);
        message.announceScore(player1, player2);
        message.announceRoundWinner(player2);
    }

    public boolean drawThree(Hand pile) {
        message.announceWar();
        ArrayList<Card> player1Pile = player1.getHand().take(3);
        ArrayList<Card> player2Pile = player2.getHand().take(3);
        if (player1Pile == null || player2Pile == null)
            return false;
        pile.addAllCardsToTop(player1Pile);
        pile.addAllCardsToTop(player2Pile);
        return true;
    }

}

