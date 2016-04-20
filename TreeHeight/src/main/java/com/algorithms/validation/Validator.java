package com.algorithms.validation;

import java.util.function.Predicate;

public interface Validator {
    <T> void validate(Predicate<T> predicate, T data, String message);
}
