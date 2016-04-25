package com.algorithms.validation;

import java.util.function.Predicate;

public class PredicateValidator implements Validator {

    @Override
    public <T> void validate(Predicate<T> predicate, T data, Procedure procedure) {
        if (predicate.test(data)) {
            procedure.execute();
        }
    }
}
