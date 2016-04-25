package com.algorithms;

import com.algorithms.model.Card;
import com.algorithms.model.Deck;
import com.algorithms.validation.PredicateValidator;
import com.algorithms.validation.Validator;

import java.util.Random;

public class DeckShuffle {

    private Validator validator = new PredicateValidator();

    public void shuffle(Deck deck) {
        validator.validate(data -> data == null, deck, () -> {
            throw new IllegalArgumentException("deck shouldn't be null.");
        });

        Random random = new Random();

        int size = deck.size() - 1;
        for (int i = 0; i < size; ++i) {
            int index = i + random.nextInt(size - i);
            swapCards(deck, index, i);
        }

    }

    private void swapCards(Deck deck, int cardIndex, int withCardIndex) {
        Card card = deck.getCard(cardIndex);
        Card withCard = deck.getCard(withCardIndex);
        deck.setCard(card, withCardIndex);
        deck.setCard(withCard, cardIndex);
    }

    public static void main(String[] args) {
        DeckShuffle deckShuffle = new DeckShuffle();
        Deck deck = new Deck();
        deckShuffle.shuffle(deck);

        System.out.print(deck);
    }
}
