package com.algorithms;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositiveSequenceHelperTest {
    private PositiveSequenceHelper positiveSequenceHelper;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void before() {
        positiveSequenceHelper = new PositiveSequenceHelper();
    }

    @Test
    public void throwIllegalArgumentExceptionForNullSequence() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("input array shouldn't be null.");

        positiveSequenceHelper.containDuplicates(null);
    }

    @Test
    public void throwIllegalArgumentExceptionForNegativeElementsInSequence() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("sequence should contain only positive numbers.");

        int[] ints = {1, -1};
        positiveSequenceHelper.containDuplicates(ints);
    }

    @Test
    public void falseForAnEmptySequence() {
        int[] ints = {};
        boolean containDuplicates = positiveSequenceHelper.containDuplicates(ints);

        assertThat(containDuplicates).isFalse();
    }

    @Test
    public void falseForPositiveSequence() {
        int[] ints = {1, 2, 3, 4, 5};
        boolean containDuplicates = positiveSequenceHelper.containDuplicates(ints);

        assertThat(containDuplicates).isFalse();
    }

    @Test
    public void falseForSequenceWithDuplicates() {
        int[] ints = {1, 2, 5, 5, 5};
        boolean containDuplicates = positiveSequenceHelper.containDuplicates(ints);

        assertThat(containDuplicates).isTrue();
    }

}
