package com.algorithms;

import com.algorithms.validation.Validator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class SortedListTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void constructorCreatesEmptyList() {

        SortedList sortedList = new SortedList();

        assertThat(sortedList.isEmpty()).isTrue();
    }

    @Test
    public void throwsIllegalArgumentExceptionOnNullData() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Data shouldn't be null.");

        SortedList sortedList = new SortedList();

        sortedList.add(null);
    }

    @Test
    public void addToAnEmptyList() {
        SortedList<Integer> sortedList = new SortedList();

        int expectedResult = 10;
        sortedList.add(expectedResult);

        assertThat(sortedList.isEmpty()).isFalse();

        int actualResult = sortedList.get(0);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void addLowestElement() {
        SortedList<Integer> sortedList = new SortedList();

        sortedList.add(10);

        int expectedResult = 9;
        sortedList.add(expectedResult);


        assertThat(sortedList.isEmpty()).isFalse();

        Integer actualResult = sortedList.get(0);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void addHighestElement() {
        SortedList<Integer> sortedList = new SortedList();
        sortedList.add(10);

        int expectedResult = 11;
        sortedList.add(expectedResult);


        assertThat(sortedList.isEmpty()).isFalse();

        Integer actualResult = sortedList.get(1);
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
