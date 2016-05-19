package com.algorithms;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class CountSortTest {

    private final CountSorter countSorter = new CountSorter();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwsIllegalArgumentExceptionForNullInput() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("sorting array shouldn't be null");

        countSorter.sort(null);
    }

    @Test
    public void throwsIllegalArgumentExceptionForNegativeNumbersArray() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("array should contains only positive numbers");

        int[] ints = {-1, 1};
        countSorter.sort(ints);
    }

    @Test
    public void sortEmptyArray() {
        int[] ints = {};
        int[] expectedResult = {};

        int[] actualResult = countSorter.sort(ints);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void sortSingleNumberArray() {
        int[] ints = {1};
        int[] expectedResult = {1};

        int[] actualResult = countSorter.sort(ints);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void sortSortedArray() {
        int[] ints = {1, 2, 3, 5, 7};
        int[] expectedResult = {1, 2, 3, 5, 7};

        int[] actualResult = countSorter.sort(ints);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void sortSortedArrayWithDuplicates() {
        int[] ints = {1, 2, 3, 3, 5, 7};
        int[] expectedResult = {1, 2, 3, 3, 5, 7};

        int[] actualResult = countSorter.sort(ints);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void sortUnsortedArray() {
        int[] ints = {6, 1, 3, 7, 2};
        int[] expectedResult = {1, 2, 3, 6, 7};

        int[] actualResult = countSorter.sort(ints);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void sortUnsortedArrayWithDuplictes() {
        int[] ints = {6, 6, 1, 3, 7, 2};
        int[] expectedResult = {1, 2, 3, 6, 6, 7};

        int[] actualResult = countSorter.sort(ints);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
