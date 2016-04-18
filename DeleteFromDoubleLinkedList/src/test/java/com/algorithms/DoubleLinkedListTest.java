package com.algorithms;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DoubleLinkedListTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void constructorCreatesEmptyLinkedList() {
        List<Integer> linkedList = new DoubleLinkedList<>();

        assertThat(linkedList.isEmpty()).isTrue();
    }

    @Test
    public void addThrowsIllegalArgumentExceptionForNullElement() {
        List<Integer> linkedList = new DoubleLinkedList<>();

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("data shouldn't be null.");

        linkedList.add(null);
    }

    @Test
    public void getThrowsIllegalArgumentExceptionWhenListIsEmpty() {
        List<Integer> linkedList = new DoubleLinkedList<>();

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("list is empty.");

        linkedList.get(0);
    }

    @Test
    public void getThrowsIllegalArgumentExceptionForNegativeIndex() {
        List<Integer> linkedList = new DoubleLinkedList<>();

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("index should be  [0,1).");

        linkedList.add(16);
        linkedList.get(-5);
    }

    @Test
    public void getThrowsIllegalArgumentExceptionForIndexHigherThenSize() {
        List<Integer> linkedList = new DoubleLinkedList<>();

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("index should be  [0,1).");

        linkedList.add(16);
        linkedList.get(1);
    }

    @Test
    public void addElementToAnEmptyList() {
        List<Integer> linkedList = new DoubleLinkedList<>();
        int expectedResult = 16;
        linkedList.add(expectedResult);

        int actualResult = linkedList.get(0);

        assertThat(linkedList.isEmpty()).isFalse();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void addElementToListWithData() {
        List<Integer> linkedList = new DoubleLinkedList<>();
        int expectedResult = 16;
        linkedList.add(15);
        linkedList.add(expectedResult);

        int actualResult = linkedList.get(1);

        assertThat(linkedList.isEmpty()).isFalse();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void deleteElementFromEmptyList() {
        List<Integer> linkedList = new DoubleLinkedList<>();

        linkedList.delete(10);

        assertThat(linkedList.isEmpty()).isTrue();
    }

    @Test
    public void deleteElementFromSingleNodeList() {
        List<Integer> linkedList = new DoubleLinkedList<>();

        linkedList.add(10);

        linkedList.delete(10);

        assertThat(linkedList.isEmpty()).isTrue();
    }

    @Test
    public void deleteDuplicateElementsFromDoubleNodeList() {
        List<Integer> linkedList = new DoubleLinkedList<>();

        linkedList.add(10);
        linkedList.add(10);

        linkedList.delete(10);

        assertThat(linkedList.isEmpty()).isTrue();
    }

    @Test
    public void deleteElementFromMultiplyNodeList() {
        List<Integer> linkedList = new DoubleLinkedList<>();

        linkedList.add(15);
        linkedList.add(10);
        linkedList.add(15);

        linkedList.delete(10);

        assertThat(linkedList.size()).isEqualTo(2);
    }

    @Test
    public void deleteDuplicateElementsFromListEnds() {
        List<Integer> linkedList = new DoubleLinkedList<>();

        linkedList.add(15);
        linkedList.add(10);
        linkedList.add(15);

        linkedList.delete(15);

        assertThat(linkedList.size()).isEqualTo(1);
    }

    @Test
    public void deleteAbsentElement() {
        List<Integer> linkedList = new DoubleLinkedList<>();

        linkedList.add(15);
        linkedList.add(10);
        linkedList.add(15);

        linkedList.delete(16);

        assertThat(linkedList.size()).isEqualTo(3);
    }
}
