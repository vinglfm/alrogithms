package com.algorithms;

import static java.lang.Integer.signum;
import static java.util.Arrays.copyOfRange;
import static org.apache.commons.lang3.Validate.notNull;

public final class BasicLargestSumSubarrayProvider {

    private static final String NULL_ARRAY_MESSAGE = "Input array shouldn't be null.";

    public int[] calculate(int[] elements) {

        notNull(elements, NULL_ARRAY_MESSAGE);

        int begIndex = 0;
        int largestBegIndex = 0;
        int largestEndIndex = 0;
        int currentSum = Integer.MIN_VALUE;
        int largestSum = Integer.MIN_VALUE;

        for (int i = 0; i < elements.length; ++i) {
            if (notPossitive(currentSum) && moreThenLargest(elements[i], largestSum)) {
                largestSum = elements[i];
                largestBegIndex = i;
                largestEndIndex = i + 1;

                currentSum = elements[i];
                begIndex = i;
            } else {
                currentSum += elements[i];

                if (notPossitive(currentSum)) {
                    currentSum = elements[i];
                    begIndex = i;
                }

                if (moreThenLargest(currentSum, largestSum)) {
                    largestSum = currentSum;
                    largestBegIndex = begIndex;
                    largestEndIndex = i + 1;
                }
            }
        }

        return copyOfRange(elements, largestBegIndex, largestEndIndex);
    }

    private boolean moreThenLargest(int current, int largest) {
        return current > largest;
    }

    private boolean notPossitive(int sum) {
        return signum(sum) < 1;
    }
}
