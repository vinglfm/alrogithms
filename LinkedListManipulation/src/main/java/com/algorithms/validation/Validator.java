package com.algorithms.validation;

public interface Validator<T> {
    void validate(T data, String message);
}
