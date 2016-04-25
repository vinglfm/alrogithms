package com.algorithms;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class UpperCaseHelperTest {

    private UpperCaseHelper upperCaseHelper = new UpperCaseHelper();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwsIllegalArgumentExceptionForNullData() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("string shouldn't be null.");

        upperCaseHelper.upper(null);
    }

    @Test
    public void uppersEmptyString() {
        String data = "";
        String actualResult = upperCaseHelper.upper(data);

        assertThat(actualResult).isEqualTo(data);
    }

    @Test
    public void uppersStringWithLowerCharacters() {
        String data = "This is a test";
        String expectedResult = "THIS IS A TEST";

        String actualResult = upperCaseHelper.upper(data);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void uppersStringWithOnlyUpperCharacters() {
        String expectedResult = "THIS IS A TEST";
        String actualResult = upperCaseHelper.upper(expectedResult);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void uppersStringWithNumberCharacters() {
        String expectedResult = "123";
        String actualResult = upperCaseHelper.upper(expectedResult);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
