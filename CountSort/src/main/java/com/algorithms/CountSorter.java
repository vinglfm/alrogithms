package com.algorithms;

public class CountSorter {

    private static final String NULL_ARRAY_MESSAGE = "sorting array shouldn't be null";

    public int[] sort(int[] ints) {
        if (ints == null) {
            throw new IllegalArgumentException(NULL_ARRAY_MESSAGE);
        }

        int max = findMax(ints);

        int[] sortedArray = ints;

        if (max > 0) {
            int[] counts = countNumbers(ints, max);
            sortedArray = sort(ints, counts);
        }
        return sortedArray;
    }

    private int[] sort(int[] ints, int[] counts) {
        int[] sortedArray = new int[ints.length];

        int position = 0;
        for (int i = 0; i < counts.length; ++i) {
            while (counts[i]-- > 0) {
                sortedArray[position++] = i + 1;
            }
        }

        return sortedArray;
    }

    private int[] countNumbers(int[] ints, int max) {
        int[] counts = new int[max];
        for (int i = 0; i < ints.length; ++i) {
            ++counts[ints[i] - 1];
        }
        return counts;
    }

    private int findMax(int[] ints) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < ints.length; ++i) {
            if (ints[i] < 1) {
                throw new IllegalArgumentException("array should contains only positive numbers");
            }
            max = Math.max(max, ints[i]);
        }
        return max;
    }
}
