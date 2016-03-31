package com.algorithms.handler;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class UniqueDuplicatesHandlerTest {

    private final UniqueDuplicatesHandler uniqueDuplicatesHandler = new UniqueDuplicatesHandler();

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
    public void arrayOfUniqueDuplicatesForValidInput() {
        int[] inputArray = {1, 3, 2, 2, 5, 3};
        int[] actualResult = uniqueDuplicatesHandler.handle(inputArray);
        assertThat(actualResult).containsOnly(2, 3);
    }
}
