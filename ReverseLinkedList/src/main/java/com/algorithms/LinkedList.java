package com.algorithms;

import java.util.ArrayList;
import java.util.Collection;

public class LinkedList<T> {

    private Node<T> beg;
    private Node<T> end;

    public void add(T data) {
        Node<T> holder = new Node<>(data);

        if (beg == null) {
            beg = end = holder;
        } else {
            end.next = holder;
            end = end.next;
        }
    }

    public Collection<T> asList() {
        Collection<T> elements = new ArrayList<>();
        for(Node<T> current = beg; current != null; current = current.next) {
            elements.add(current.data);
        }
        return elements;
    }

    public void reverse() {
        if(beg != null) {
            Node<T> current = beg.next;
            beg.next = null;
            while (current != null) {
                Node<T> temp = current.next;

                current.next = beg;

                beg = current;

                current = temp;
            }
        }
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}
