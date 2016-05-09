package com.algorithms;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveHelperTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void addProhibitedStringThrowsIllegalArgumentExceptionForNullString() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("prohibited string shouldn't be null.");

        RemoveHelper removeHelper = new RemoveHelper();
        removeHelper.addProhibitedWords(null);
    }

    @Test
    public void removeThrowsIllegalArgumentExceptionForNullString() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("text to clean up shouldn't be null.");

        RemoveHelper removeHelper = new RemoveHelper();
        removeHelper.remove(null);
    }

    @Test
    public void removeSingleCharacter() {
        String expectedResult = "dt";

        RemoveHelper removeHelper = new RemoveHelper();
        removeHelper.addProhibitedWords("a");

        String actualResult = removeHelper.remove("dat");

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void removeMultiplyDuplicateCharacters() {
        String expectedResult = "dt";

        RemoveHelper removeHelper = new RemoveHelper();
        removeHelper.addProhibitedWords("a");

        String actualResult = removeHelper.remove("data");

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void removeWordWithRepeatingCharacter() {
        String expectedResult = "dta";

        RemoveHelper removeHelper = new RemoveHelper();
        removeHelper.addProhibitedWords("aa");

        String actualResult = removeHelper.remove("daata");

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void removeWordWithRepeatingCharacterFromTheEnd() {
        String expectedResult = "dat";

        RemoveHelper removeHelper = new RemoveHelper();
        removeHelper.addProhibitedWords("aa");

        String actualResult = removeHelper.remove("dataa");

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void removeWholeWord() {
        String expectedResult = "";

        RemoveHelper removeHelper = new RemoveHelper();
        removeHelper.addProhibitedWords("data");

        String actualResult = removeHelper.remove("data");

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void removeNothingForNonMatchingWords() {
        String expectedResult = "data";

        RemoveHelper removeHelper = new RemoveHelper();
        removeHelper.addProhibitedWords("adat");
        removeHelper.addProhibitedWords("bdat");

        String actualResult = removeHelper.remove("data");

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void removeNothingForPartlyMachedWord() {
        String expectedResult = "data";

        RemoveHelper removeHelper = new RemoveHelper();
        removeHelper.addProhibitedWords("datas");

        String actualResult = removeHelper.remove("data");

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
