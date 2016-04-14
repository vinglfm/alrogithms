package com.algorithms;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class SortedListTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void constructorCreatesEmptyList() {
        SortedList sortedList = new SortedList();

        assertThat(sortedList.isEmpty()).isTrue();
    }

    @Test
    public void throwsNullPointerExceptionOnNullData() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Data shouldn't be null.");

        SortedList sortedList = new SortedList();

        sortedList.add(null);
    }

    @Test
    public void addToAnEmptyList() {
        SortedList<Integer> sortedList = new SortedList();

        sortedList.add(10);

        assertThat(sortedList.isEmpty()).isFalse();
        assertThat(sortedList.get(0)).isEqualTo(10);
    }

    @Test
    public void addLowestElement() {
        SortedList<Integer> sortedList = new SortedList();
        sortedList.add(10);
        sortedList.add(9);


        assertThat(sortedList.isEmpty()).isFalse();
        assertThat(sortedList.get(0)).isEqualTo(9);
    }

    @Test
    public void addHighestElement() {
        SortedList<Integer> sortedList = new SortedList();
        sortedList.add(10);
        sortedList.add(11);


        assertThat(sortedList.isEmpty()).isFalse();
        assertThat(sortedList.get(1)).isEqualTo(11);
    }
}
