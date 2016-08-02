package com.algorithms;

public class PositiveSequenceHelper {
    public boolean containDuplicates(int[] ints) {
        if (ints == null) {
            throw new IllegalArgumentException("input array shouldn't be null.");
        }

        if (ints.length == 0) {
            return false;
        }

        int calculatedSum = calculateSequenceSum(ints);
        int fixedLengthSequenceSum = calculateFixedLengthSequenceSum(ints);

        return fixedLengthSequenceSum != calculatedSum;
    }

    private int calculateFixedLengthSequenceSum(int[] ints) {
        return ints.length * (ints.length + 1) / 2;
    }

    private int calculateSequenceSum(int[] ints) {
        int sum = 0;
        for (int i = 0; i < ints.length; ++i) {
            validatePositiveSequence(ints[i]);
            sum += ints[i];
        }
        return sum;
    }

    private void validatePositiveSequence(int anInt) {
        if (anInt < 1) {
            throw new IllegalArgumentException("sequence should contain only positive numbers.");
        }
    }
}
