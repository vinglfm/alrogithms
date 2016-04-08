package com.algorithms.handler;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class InPlaceUniqueDuplicatesHandlerTest {
    private final UniqueDuplicatesHandler uniqueDuplicatesHandler = new InPlaceUniqueDuplicatesHandler();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwNullPointerExceptionForNullInput() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Elements array shouldn't be null");

        int[] nullArray = null;
        uniqueDuplicatesHandler.handle(nullArray);
    }

    @Test
    public void emptyArrayForEmptyArrayInput() {
        int[] emptyArray = {};
        int[] actualResult = uniqueDuplicatesHandler.handle(emptyArray);
        assertThat(actualResult).isEmpty();
    }

    @Test
    public void emptyArrayForArrayWithoutDuplicates() {
        int[] inputArray = {1, 2, 3, 4, 5};
        int[] actualResult = uniqueDuplicatesHandler.handle(inputArray);
        assertThat(actualResult).isEmpty();
    }

    @Test
    public void arrayWithSingleDuplicate() {
        int[] inputArray = {1, 3, 2, 2, 5, 4};
        int[] actualResult = uniqueDuplicatesHandler.handle(inputArray);
        assertThat(actualResult).containsExactly(2);
    }

    @Test
    public void arrayWithMultiplyDuplicates() {
        int[] inputArray = {1, 3, 5, 5, 7, 5, 6, 7};
        int[] actualResult = uniqueDuplicatesHandler.handle(inputArray);
        assertThat(actualResult).containsExactly(5, 7);
    }

    @Test
    public void arrayWithAllDuplicates() {
        int[] inputArray = {1, 1, 1, 1, 1, 1, 1, 1};
        int[] actualResult = uniqueDuplicatesHandler.handle(inputArray);
        assertThat(actualResult).containsExactly(1);
    }
}