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

        int currentSum = 0;
        int largestSum = Integer.MIN_VALUE;

        for (int i = 0; i < elements.length; ++i) {
            currentSum += elements[i];

            if(isLargestSum(currentSum, largestSum)) {
                largestSum = currentSum;
                largestBegIndex = begIndex;
                largestEndIndex = i + 1;
            }

            if (shouldInvalidateSum(currentSum)) {
                currentSum = elements[i];
                begIndex = i;

                if (isLargestSum(currentSum, largestSum)) {
                    largestBegIndex = begIndex;
                    largestEndIndex = i + 1;
                }
            }
        }

        return copyOfRange(elements, largestBegIndex, largestEndIndex);
    }

    private boolean isLargestSum(int currentSum, int largestSum) {
        return largestSum < currentSum;
    }

    private boolean shouldInvalidateSum(int sum) {
        return signum(sum) < 1;
    }
}
