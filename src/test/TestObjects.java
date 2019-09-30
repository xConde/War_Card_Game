package test;

import Deck.*;
import Player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

public class TestObjects {

    Deck practiceDeck;
    Player practicePlayer;
    Hand handTest1;
    Card testCard1;
    int winningScore = 55;

    @Before
    public void setUpBefore() {
        practiceDeck = new Deck();
        practicePlayer = new Player("Exhausted fellow", winningScore);
        handTest1 = new Hand();
        testCard1 = new Card(CardRank.QUEEN, CardSuit.HEARTS);
        handTest1.addCardToTop(testCard1);
    }

    @Test
    public void constructor_generate52UniqueCards() {
        int quantityExpected = 52;
        int actual = new HashSet<>(practiceDeck.getCards()).size();
        Assert.assertEquals(quantityExpected, actual);
    }

    @Test
    public void constructor_orderBeforeShuffle() {
        Assert.assertEquals(practiceDeck.getCards().get(0).toString().trim(), new Card(CardRank.TWO, CardSuit.HEARTS).toString());
        Assert.assertEquals(practiceDeck.getCards().get(51).toString().trim(), new Card(CardRank.ACE, CardSuit.DIAMONDS).toString());
    }

    @Test
    public void noShuffleOrder() {
        Assert.assertEquals(new Deck().getCards().toString().trim(), practiceDeck.getCards().toString());
    }

    @Test
    public void getNameWorks() {
        String expected = "Exhausted fellow";
        String actual = practicePlayer.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getScoreWorks() {
        int expected = 55;
        int actual = practicePlayer.getScore();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateGetScoreWorks() {
        int expected = 69;
        practicePlayer.setScore(69);
        int actual = practicePlayer.getScore();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCard() {
        String expected = "Queen of Hearts";
        String actual = testCard1.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void handSize() {
        int expected = 1;
        int actual = handTest1.sizeOfHand();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTooMany() {
        ArrayList<Card> cards = handTest1.take(5);
        Assert.assertNotEquals(handTest1.sizeOfHand(), -4);
    }


}
