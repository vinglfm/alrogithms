package com.algorithm;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseWordOrderProviderTest {

    private ReverseWordOrderProvider reverseWordOrderProvider = new ReverseWordOrderProvider();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwNullPointerExceptionForNullArray() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("sentence shouldn't be null.");

        reverseWordOrderProvider.reverse(null);
    }

    @Test
    public void reverseWellStructuredSentence() {
        char[] sentence = "This is a sentence.".toCharArray();
        char[] expectedResult = "sentence. a is This".toCharArray();

        char[] actualResult = reverseWordOrderProvider.reverse(sentence);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void reverseSingleWordSentence() {
        char[] sentence = "Physic".toCharArray();
        char[] expectedResult = "Physic".toCharArray();

        char[] actualResult = reverseWordOrderProvider.reverse(sentence);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void reverseEmptyArray() {
        char[] sentence = "".toCharArray();
        char[] expectedResult = "".toCharArray();

        char[] actualResult = reverseWordOrderProvider.reverse(sentence);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
