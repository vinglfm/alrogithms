package com.algorithms;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class DuplicateLocatorTest {

    private DuplicateLocator duplicateLocator = new DuplicateLocator();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwIllegalArgumentExceptionForNullArray() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("input array shouldn't be null.");

        duplicateLocator.locate(null);
    }

    @Test
    public void falseForEmptyArray() {
        int[] inputArray = {};
        boolean actualResult = duplicateLocator.locate(inputArray);
        assertThat(actualResult).isFalse();
    }

    @Test
    public void falseForSingleElementArray() {
        int[] inputArray = {1};
        boolean actualResult = duplicateLocator.locate(inputArray);
        assertThat(actualResult).isFalse();
    }

    @Test
    public void falseForArrayWithDuplicates() {
        int[] inputArray = {5, 3, 3, 3, 2};
        boolean actualResult = duplicateLocator.locate(inputArray);
        assertThat(actualResult).isTrue();
    }

    @Test
    public void falseForArrayWithoutDuplicates() {
        int[] inputArray = {5, 3, 4, 1, 2};
        boolean actualResult = duplicateLocator.locate(inputArray);
        assertThat(actualResult).isFalse();
    }
}
