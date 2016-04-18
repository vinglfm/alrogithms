package com.algorithms;

public interface List<T> {

    boolean isEmpty();

    int size();

    void delete(T element);

    void add(T element);

    T get(int index);
}
