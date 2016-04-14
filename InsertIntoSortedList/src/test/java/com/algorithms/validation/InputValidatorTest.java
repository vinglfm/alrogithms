package com.algorithms.validation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.function.Predicate;

public class InputValidatorTest {

    private Validator<Integer> validator;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwsIllegalArgumentExceptionWhenPredicateIsTrue() {
        String message = "Condition is true";

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(message);

        Predicate<Integer> predicate = data -> data < 10;
        validator = new InputValidator<>(predicate);

        validator.validate(9, message);
    }

    @Test
    public void doNotThrowIllegalArgumentExceptionWhenPredicateIsFalse() {
        String message = "Condition is fasle";

        Predicate<Integer> predicate = data -> data < 10;
        validator = new InputValidator<>(predicate);

        validator.validate(16, message);
    }
}