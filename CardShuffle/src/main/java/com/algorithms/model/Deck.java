package com.algorithms.model;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private final List<Card> cards = new ArrayList<>();

    public Deck() {
        for (Suit suit : Suit.values()) {
            for (Number number : Number.values()) {
                cards.add(new Card(suit, number));
            }
        }
    }

    public int size() {
        return cards.size();
    }

    public Card getCard(int index) {
        return cards.get(index);
    }

    public void setCard(Card card, int index) {
        cards.add(index, card);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deck deck = (Deck) o;

        return !(cards != null ? !cards.equals(deck.cards) : deck.cards != null);

    }

    @Override
    public int hashCode() {
        return cards != null ? cards.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Deck{" + cards + "}";
    }
}
