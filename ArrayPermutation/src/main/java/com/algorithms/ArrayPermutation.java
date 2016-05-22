package com.algorithms;

import com.algorithms.generator.NumberGenerator;

public class ArrayPermutation {

    private NumberGenerator numberGeneration;

    public ArrayPermutation(NumberGenerator numberGeneration) {
        this.numberGeneration = numberGeneration;
    }

    public int[] permute(int[] ints) {
        if(ints == null) {
            throw new IllegalArgumentException("input array shouldn't be null.å");
        }
        for (int i = 0; i < ints.length; ++i) {
            int withIndx = numberGeneration.generate(i, ints.length);
            swap(ints, i, withIndx);
        }
        return ints;
    }

    private void swap(int[] ints, int i, int withIndx) {
        int temp = ints[i];
        ints[i] = ints[withIndx];
        ints[withIndx] = temp;
    }
}
