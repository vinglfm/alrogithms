package com.algorithms;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void constructorCreatesEmptyLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList();

        assertThat(linkedList.isEmpty()).isTrue();
    }

    @Test
    public void addLastToEmptyList() {
        LinkedList<Integer> linkedList = new LinkedList();
        Integer expectedData = 10;
        linkedList.addLast(expectedData);

        assertThat(linkedList.size()).isEqualTo(1);

        Integer actualResult = linkedList.getLast();
        assertThat(actualResult).isEqualTo(expectedData);
    }

    @Test
    public void addToEmptyList() {
        LinkedList<Integer> linkedList = new LinkedList();
        Integer expectedData = 10;
        linkedList.add(expectedData, 0);

        assertThat(linkedList.size()).isEqualTo(1);
        Integer actualResult = linkedList.get(0);
        assertThat(actualResult).isEqualTo(expectedData);
    }

    @Test
    public void removeAllFromEmptyList() {
        LinkedList<Integer> linkedList = new LinkedList();

        linkedList.removeAll(10);

        assertThat(linkedList.isEmpty()).isTrue();
    }

    @Test
    public void addLastToNonEmptyList() {
        LinkedList<Integer> linkedList = new LinkedList();

        int expectedResult = 15;

        linkedList.addLast(10);
        linkedList.addLast(expectedResult);

        assertThat(linkedList.size()).isEqualTo(2);
        Integer actualResult = linkedList.getLast();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void addToListWithNegativeIndex() {
        LinkedList<Integer> linkedList = new LinkedList();

        expectedException.expect(IndexOutOfBoundsException.class);
        expectedException.expectMessage("Index " + -1 + " should be between 0 and " + 1);

        linkedList.add(10, 0);
        linkedList.add(15, -1);
    }

    @Test
    public void addToListWhenIndexBiggerThenSize() {
        LinkedList<Integer> linkedList = new LinkedList();

        expectedException.expect(IndexOutOfBoundsException.class);
        expectedException.expectMessage("Index " + 2 + " should be between 0 and " + 1);

        linkedList.add(10, 0);
        linkedList.add(15, 2);
    }

    @Test
    public void addToBegginingOfNonEmptyList() {
        LinkedList<Integer> linkedList = new LinkedList();

        int expectedResult = 15;

        linkedList.add(10, 0);
        linkedList.add(expectedResult, 0);

        assertThat(linkedList.size()).isEqualTo(2);
        Integer actualResult = linkedList.get(0);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void addToEndOfNonEmptyList() {
        LinkedList<Integer> linkedList = new LinkedList();

        int expectedResult = 15;

        linkedList.add(10, 0);
        linkedList.add(expectedResult, 1);

        assertThat(linkedList.size()).isEqualTo(2);
        Integer actualResult = linkedList.get(1);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void addToMiddleOfNonEmptyList() {
        LinkedList<Integer> linkedList = new LinkedList();

        int expectedResult = 17;

        linkedList.add(10, 0);
        linkedList.add(15, 1);
        linkedList.add(expectedResult, 1);

        assertThat(linkedList.size()).isEqualTo(3);
        Integer actualResult = linkedList.get(1);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void addDuplicate() {
        LinkedList<Integer> linkedList = new LinkedList();

        int expectedResult = 10;

        linkedList.add(10, 0);
        linkedList.add(expectedResult, 1);

        assertThat(linkedList.size()).isEqualTo(2);
        Integer actualResult = linkedList.get(1);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void removeAllWithSingleOccurrence() {
        LinkedList<Integer> linkedList = new LinkedList();

        int removedElement = 15;

        linkedList.add(10, 0);
        linkedList.add(removedElement, 1);

        linkedList.removeAll(removedElement);

        assertThat(linkedList.size()).isEqualTo(1);
    }

    @Test
    public void removeAllWithMultiplyOccurrence() {
        LinkedList<Integer> linkedList = new LinkedList();

        linkedList.add(10, 0);
        linkedList.add(10, 0);
        linkedList.add(15, 1);

        linkedList.removeAll(10);

        assertThat(linkedList.size()).isEqualTo(1);
    }

    @Test
    public void removeAllWhenElementIsInFirstAndLastPosition() {
        LinkedList<Integer> linkedList = new LinkedList();

        linkedList.add(10, 0);
        linkedList.add(15, 0);
        linkedList.addLast(10);

        linkedList.removeAll(10);

        assertThat(linkedList.size()).isEqualTo(1);
    }
}
