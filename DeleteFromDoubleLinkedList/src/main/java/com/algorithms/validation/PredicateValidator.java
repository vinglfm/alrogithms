package com.algorithms.validation;

import java.util.function.Predicate;

public class PredicateValidator implements Validator {

    @Override
    public <T> void validate(Predicate<T> predicate, T data, String message) {
        if (predicate.test(data)) {
            throw new IllegalArgumentException(message);
        }
    }
}
