package com.algorithms.model;

public enum Suit {
    HEARTS("H"), DIAMONDS("D"), CLUBS("C"), SPADES("S");

    private final String value;

    Suit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
