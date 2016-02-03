package com.algorithms.validator;

public class TreeDataValidator implements Validator<String> {

    private final String validRegex;

    public TreeDataValidator(String validSymbolsRegex) {
        if(validSymbolsRegex == null) {
            throw new IllegalArgumentException("validSymbolsRegex shouldn't be null.");
        }

        this.validRegex = validSymbolsRegex;
    }

    public void validate(String data) {
        if(data == null) {
            throw new IllegalArgumentException("data shouldn't be null.");
        }

        if (!data.matches(validRegex)) {
            throw new ValidationException(data + " doesn't match patter: " + validRegex);
        }
    }
}
