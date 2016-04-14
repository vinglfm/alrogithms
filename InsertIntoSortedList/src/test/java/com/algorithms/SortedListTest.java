package com.algorithms;

import com.algorithms.validation.Validator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class SortedListTest {

    private Validator validator = mock(Validator.class);

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void constructorCreatesEmptyList() {

        SortedList sortedList = new SortedList(validator);

        assertThat(sortedList.isEmpty()).isTrue();
    }

    @Test
    public void throwsNullPointerExceptionOnNullData() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Data shouldn't be null.");

        SortedList sortedList = new SortedList(validator);

        sortedList.add(null);
    }

    @Test
    public void addToAnEmptyList() {
        SortedList<Integer> sortedList = new SortedList(validator);

        int expectedResult = 10;
        sortedList.add(expectedResult);

        assertThat(sortedList.isEmpty()).isFalse();

        int actualResult = sortedList.get(0);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void addLowestElement() {
        SortedList<Integer> sortedList = new SortedList(validator);

        sortedList.add(10);

        int expectedResult = 9;
        sortedList.add(expectedResult);


        assertThat(sortedList.isEmpty()).isFalse();

        Integer actualResult = sortedList.get(0);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void addHighestElement() {
        SortedList<Integer> sortedList = new SortedList(validator);
        sortedList.add(10);

        int expectedResult = 11;
        sortedList.add(expectedResult);


        assertThat(sortedList.isEmpty()).isFalse();

        Integer actualResult = sortedList.get(1);
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
