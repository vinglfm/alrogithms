package com.algorithms;

import static org.apache.commons.lang3.Validate.isTrue;

public class LongPrinter {

    private static final String NON_NEGATIVE_INPUT = "Printing element shouldn't be negative.";
    private static final int RADIX = 10;

    public void putLong(long number) {
        isTrue(number >= 0, NON_NEGATIVE_INPUT);

        if (number == 0) {
            putChar('0');
        }

        number = reverse(number);

        while (number != 0) {
            int digit = (int) (number % RADIX);
            number = number / RADIX;
            putChar(Character.forDigit(digit, RADIX));
        }
    }

    private long reverse(long number) {
        long reversed = 0;

        while (number != 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }

        return reversed;
    }

    private void putChar(char digit) {
        System.out.print(digit);
    }
}
