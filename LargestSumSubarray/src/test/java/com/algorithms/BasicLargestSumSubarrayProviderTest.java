package com.algorithms;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicLargestSumSubarrayProviderTest {

    private BasicLargestSumSubarrayProvider provider = new BasicLargestSumSubarrayProvider();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwNullPointerExceptionOnNullArray() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Input array shouldn't be null.");

        int[] nullArray = null;
        provider.calculate(nullArray);
    }

    @Test
    public void returnsEmptyLargestSumSubArrayForEmptyArray() {

        int[] emptyArray = {};
        int[] expectedResult = provider.calculate(emptyArray);

        assertThat(expectedResult).isEmpty();
    }

    @Test
    public void returnsLargestSumSubArrayForBasicArray() {
        int[] array = {2, 5, -6, -2, 2, -1, 6, -1, 6, -5};
        int[] expectedResult = {2, -1, 6, -1, 6};

        int[] actualResult = provider.calculate(array);
        assertThat(actualResult).containsExactly(expectedResult);
    }

    @Test
    public void returnsLargestSumSubArrayForSortedAscArray() {
        int[] array = {-1, 1, 2, 3, 5, 7};
        int[] expectedResult = {1, 2, 3, 5, 7};

        int[] actualResult = provider.calculate(array);
        assertThat(actualResult).containsExactly(expectedResult);
    }

    @Test
    public void returnsLargestSumSubArrayForSortedDescArray() {
        int[] array = {5, 3, 2, 1, -1, -6};
        int[] expectedResult = {5, 3, 2, 1};

        int[] actualResult = provider.calculate(array);
        assertThat(actualResult).containsExactly(expectedResult);
    }

    @Test
    public void returnsLargestSumSubArrayForNegativeArray() {
        int[] array = {-5, -5, -3, -6, -1};
        int[] expectedResult = {-1};

        int[] actualResult = provider.calculate(array);
        assertThat(actualResult).containsExactly(expectedResult);
    }

    @Test
    public void returnsLargestSumSubArrayForDuplicateNegativeNumberArray() {
        int[] array = {-1, -1, -1, -1, -1};
        int[] expectedResult = {-1};

        int[] actualResult = provider.calculate(array);
        assertThat(actualResult).containsExactly(expectedResult);
    }
}
