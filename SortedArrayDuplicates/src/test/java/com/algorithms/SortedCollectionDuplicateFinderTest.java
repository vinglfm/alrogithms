package com.algorithms;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class SortedCollectionDuplicateFinderTest {

    private final SortedCollectionDuplicateFinder sortedCollectionDuplicateFinder = new SortedCollectionDuplicateFinder();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwsIllegalArgumentExceptionOnNullArray() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("input array shouldn't be null.");

        sortedCollectionDuplicateFinder.getDuplicates(null);
    }

    @Test
    public void emptyResultForSingleElementCollection() {
        Integer[] elements = {1};
        Integer[] expectedResult = {};

        Collection<Integer> actualResult = sortedCollectionDuplicateFinder.getDuplicates(elements);
        assertThat(actualResult).containsExactly(expectedResult);
    }

    @Test
    public void emptyResultForUniqueElementCollection() {
        Integer[] elements = {1, 2, 3};
        Integer[] expectedResult = {};

        Collection<Integer> actualResult = sortedCollectionDuplicateFinder.getDuplicates(elements);
        assertThat(actualResult).containsExactly(expectedResult);
    }

    @Test
    public void singleElementForSingleElementCollection() {
        Integer[] elements = {7, 7, 7, 7, 7};
        Integer[] expectedResult = {7};

        Collection<Integer> actualResult = sortedCollectionDuplicateFinder.getDuplicates(elements);
        assertThat(actualResult).containsExactly(expectedResult);
    }

    @Test
    public void duplicatesForAnyElementCollection() {
        Integer[] elements = {1, 6, 6, 7, 8, 10, 15, 15, 26, 28, 37, 39, 46, 47, 47};
        Integer[] expectedResult = {6, 15, 47};

        Collection<Integer> actualResult = sortedCollectionDuplicateFinder.getDuplicates(elements);
        assertThat(actualResult).containsExactly(expectedResult);
    }
}
