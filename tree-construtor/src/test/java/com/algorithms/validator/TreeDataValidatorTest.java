package com.algorithms.validator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TreeDataValidatorTest {

    private String validationRegex = "[a-zA-Z#,]+";
    private String invalidData = "Fox,#,1";
    private String validData = "Fox,#,#";

    private Validator<String> validator;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void constructorThrowsIllegalArgumentExceptionForNullRegex() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("validSymbolsRegex shouldn't be null.");

        validator = new TreeDataValidator(null);
    }
    @Test
    public void validateThrowsIllegalArgumentExceptionForNullData() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("data shouldn't be null.");

        validator = new TreeDataValidator(validationRegex);

        validator.validate(null);
    }

    @Test
    public void validateThrowsValidationExceptionForInvalidData() {
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage(invalidData + " doesn't match patter: " + validationRegex);

        validator = new TreeDataValidator(validationRegex);

        validator.validate(invalidData);
    }


    @Test
    public void validateDoNothingForValidData() {
        validator = new TreeDataValidator(validationRegex);

        validator.validate(validData);
    }

}