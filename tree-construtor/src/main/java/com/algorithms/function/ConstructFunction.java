package com.algorithms.function;

public interface ConstructFunction<T, U, V> {
    void apply(T current, U left, V right);
}
