package com.algorithms;

import com.algorithms.model.Deck;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CardShuffleTest {

    private DeckShuffle deckShuffle = new DeckShuffle();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwsIllegalArgumentExceptionForNullDeck() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Shuffled deck can't be null.");

        deckShuffle.shuffle(null);
    }

    @Test
    public void shuffleDeck() {
        Deck originalDeck = new Deck();

        Deck deckToShuffle = new Deck();
        deckShuffle.shuffle(deckToShuffle);

        assertThat(deckToShuffle).isNotEqualTo(originalDeck);
    }
}
