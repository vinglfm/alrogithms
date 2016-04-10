package com.algorithms;

public class PowerOfTwoResolver {

    public boolean test(int number) {
        return number < 2 ? false : (number & (number - 1)) == 0;
    }
}
