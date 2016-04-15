package com.algorithms;

import com.algorithms.validation.InputValidator;

public class LinkedList<T> {

    private Node<T> first;
    private Node<T> last;

    private int size;

    private InputValidator<Integer> integerInputValidator;

    public LinkedList() {
        integerInputValidator = new InputValidator<>(elem -> {
            return elem < 0 || elem > size;
        });
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addLast(T data) {
        if (first == null) {
            first = last = new Node<>(data);
        } else {
            last.next = new Node<>(data);
            last = last.next;
        }
        ++size;
    }

    public void add(T data, int index) {

        integerInputValidator.validate(index, "Index " + index + " should be between 0 and " + size);

        if (index == 0) {
            Node<T> newNode = new Node<>(data);
            newNode.next = first;
            first = newNode;
            if (last == null) {
                last = first;
            }
        } else {
            Node<T> current = first;
            int position = 1;

            while (position++ != index) {
                current = current.next;
            }

            Node<T> newNode = new Node<>(data);
            newNode.next = current.next;
            current.next = newNode;
            if (index == size) {
                last = newNode;
            }
        }
        ++size;
    }

    public void removeAll(T data) {

        if (size > 0) {
            Node<T> current = first;

            while (current.next != null && current.next != last) {
                if (current.next.data.equals(data)) {
                    Node<T> removed = current.next;
                    current.next = current.next.next;
                    removed.next = null;
                    --size;
                } else {
                    current = current.next;
                }
            }

            if (first.data.equals(data)) {
                Node<T> removed = first;
                first = first.next;
                removed.next = null;
                --size;
            }
            if (last.data.equals(data)) {
                current.next = null;
                last = current;
                --size;
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

    public T getLast() {
        return last.data;
    }

    private static final class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
}
