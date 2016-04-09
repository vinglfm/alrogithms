package com.algorithms;

import static org.apache.commons.lang3.Validate.isTrue;

public class LongPrinter {

    public static final String NON_NEGATIVE_INPUT = "Printing element shouldn't be negative.";
    public static final int RADIX = 10;

    public void putLong(long number) {
        isTrue(number >= 0, NON_NEGATIVE_INPUT);

        if(number == 0) {
            putChar('0');
        }

        print(number);
    }

    private void print(long number) {
        if(number == 0) {
            return;
        }

        int digit = (int)(number % RADIX);
        print(number/RADIX);
        putChar(Character.forDigit(digit, RADIX));
    }

    private void putChar(char digit) {
        System.out.print(digit);
    }
}
