package com.algorithms;

import static org.apache.commons.lang3.Validate.notNull;

public class SortedList<T extends Comparable<T>> {
    private Node<T> first;

    public boolean isEmpty() {
        return first == null;
    }

    public void add(T data) {

        notNull(data, "Data shouldn't be null.");

        if(isEmpty()) {
            first = new Node(data);
        } else {
            Node<T> current = first;

            while (current.next != null && data.compareTo(current.data) > 0) {
                current = current.next;
            }

            Node<T> newNode = new Node<T>(data);
            if(data.compareTo(first.data) < 0) {
                newNode.next = first;
                first = newNode;
            } else {
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }

    public T get(int position) {
        Node<T> current = first;
        int pointer = 0;
        while (pointer != position) {
            current = current.next;
            pointer++;
        }
        return current.data;
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
}
