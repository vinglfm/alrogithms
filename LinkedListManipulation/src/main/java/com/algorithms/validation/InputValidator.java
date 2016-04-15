package com.algorithms.validation;

import java.util.function.Predicate;

public class InputValidator<T> implements Validator<T> {

    private final Predicate<T> validationFunction;

    public InputValidator(Predicate<T> validationFunction) {
        this.validationFunction = validationFunction;
    }

    @Override
    public void validate(T data, String message) {
        if (validationFunction.test(data)) {
            throw new IndexOutOfBoundsException(message);
        }
    }
}
