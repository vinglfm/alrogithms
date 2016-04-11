package com.algorithms;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListTest {

    @Test
    public void reverseSingleNodeLinkedList() {
        LinkedList linkedList = new LinkedList();

        linkedList.add(1);

        linkedList.reverse();

        assertThat(linkedList.asList()).containsExactly(1);
    }

    @Test
    public void reverseGeneralLinkedList() {
        LinkedList linkedList = new LinkedList();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        linkedList.reverse();

        assertThat(linkedList.asList()).containsExactly(4, 3, 2, 1);
    }
}
