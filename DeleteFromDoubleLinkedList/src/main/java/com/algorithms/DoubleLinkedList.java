package com.algorithms;

import com.algorithms.validation.PredicateValidator;
import com.algorithms.validation.Validator;

public class DoubleLinkedList<T> implements List<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    private final Validator validator;

    public DoubleLinkedList() {
        validator = new PredicateValidator();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T data) {
        validator.validate(elem -> elem == null, data, "data shouldn't be null.");
        if (first == null) {
            first = last = new Node<>(data, null, null);
        } else {
            last.next = new Node<>(data, last, null);
            last = last.next;
        }
        ++size;
    }

    @Override
    public T get(int index) {

        validator.validate(data -> data == 0, size, "list is empty.");
        validator.validate(data -> data < 0 || data > size - 1, index, "index should be  [0," + size + ").");

        Node<T> current = first;
        int counter = 0;
        while (counter != index) {
            current = current.next;
            ++counter;
        }

        return current.data;
    }

    @Override
    public void delete(T data) {
        validator.validate(elem -> elem == null, data, "data shouldn't be null.");

        if (!isEmpty()) {
            Node<T> current = first.next;

            while (current != null && current != last) {
                if (current.data.equals(data)) {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    --size;
                }
                current = current.next;
            }

            deleteFirst(data);

            deleteLast(data);
        }

    }

    private void deleteLast(T data) {
        if (last != null && last.data.equals(data)) {
            last = last.prev;
            if (last != null) {
                last.next = null;
            } else {
                first = null;
            }
            --size;
        }
    }

    private void deleteFirst(T data) {
        if (first != null && first.data.equals(data)) {
            first = first.next;
            if (first != null) {
                first.prev = null;
            } else {
                last = null;
            }
            --size;
        }
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
