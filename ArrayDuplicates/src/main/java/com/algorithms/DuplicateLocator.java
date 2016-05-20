package com.algorithms;

public class DuplicateLocator {

    private static final String NULL_ARRAY_MESSAGE = "input array shouldn't be null.";

    public boolean locate(int[] ints) {
        if (ints == null) {
            throw new IllegalArgumentException(NULL_ARRAY_MESSAGE);
        }

        int noDuplicatesSum = ints.length * (ints.length + 1) / 2;

        int actualSum = 0;
        for(int i = 0; i < ints.length; ++i) {
            actualSum += ints[i];
        }

        return actualSum != noDuplicatesSum;
    }
}
