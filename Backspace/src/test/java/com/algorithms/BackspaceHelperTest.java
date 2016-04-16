package com.algorithms;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class BackspaceHelperTest {

    private BackspaceHelper backspaceHelper = new BackspaceHelper();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwsIllegalArgumentExceptionForNullArray() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("data shouldn't be null.");

        backspaceHelper.backspace(null, 5);
    }

    @Test
    public void throwsIllegalArgumentExceptionWhenDeletedIndexIsMoreThenArrayLength() {
        char[] inputArray = "1000010001000000".toCharArray();

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Index should be between 8 and " + inputArray.length);

        backspaceHelper.backspace(inputArray, 32);
    }

    @Test
    public void throwsIllegalArgumentExceptionWhenArrayIsLessThen8Bit() {
        char[] inputArray = "".toCharArray();

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("data should be more then 8 bit.");

        backspaceHelper.backspace(inputArray, 32);
    }

    @Test
    public void throwsIllegalArgumentExceptionWhenPreviousByteIsNotWellFormatted() {
        char[] inputArray = "235235352382".toCharArray();

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("data is not well formatted.");

        backspaceHelper.backspace(inputArray, 8);
    }

    @Test
    public void throwsIllegalArgumentExceptionWhenSecondPreviousByteIsNotWellFormatted() {
        char[] inputArray = "100011007000110000000100".toCharArray();

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("data is not well formatted.");

        backspaceHelper.backspace(inputArray, 16);
    }

    @Test
    public void backspaceWhenTwoPreviousByteIsAscii() {
        char[] inputArray = "0000110000000100".toCharArray();

        char[] expectedResult = "00000100".toCharArray();

        char[] actualResult = backspaceHelper.backspace(inputArray, 8);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void backspaceWhenPreviousIsAsciiAndNextIsKanji() {
        char[] inputArray = "100011000000110000000100".toCharArray();

        char[] expectedResult = "00000100".toCharArray();

        char[] actualResult = backspaceHelper.backspace(inputArray, 16);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void backspaceWhenPreviousIsKanji() {
        char[] inputArray = "100011000000110000000100".toCharArray();

        char[] expectedResult = "00000100".toCharArray();

        char[] actualResult = backspaceHelper.backspace(inputArray, 16);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
