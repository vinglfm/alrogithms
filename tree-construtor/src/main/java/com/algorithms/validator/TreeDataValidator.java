package com.algorithms.validator;

public class TreeDataValidator implements Validator<String> {

    private final String validRegex;

    public TreeDataValidator(String validRegex) {
        if(validRegex == null) {
            throw new IllegalArgumentException("regex shouldn't be null.");
        }

        this.validRegex = validRegex;
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
