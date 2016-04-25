package com.algorithms;

import com.algorithms.validation.PredicateValidator;
import com.algorithms.validation.Validator;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.toUpperCase;

public class UpperCaseHelper {

    private Validator validator = new PredicateValidator();

    public String upper(String data) {

        validator.validate(evaluatingString -> evaluatingString == null, data, () -> {
            throw new IllegalArgumentException("string shouldn't be null.");
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < data.length(); ++i) {
            char elem = data.charAt(i);
            stringBuilder.append(isLowerCase(elem) ? toUpperCase(elem) : elem);
        }

        return stringBuilder.toString();
    }
}
