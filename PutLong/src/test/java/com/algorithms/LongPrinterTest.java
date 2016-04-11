package com.algorithms;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class LongPrinterTest {

    private LongPrinter longPrinter = new LongPrinter();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Rule
    public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void throwIllegalArgumentExceptionOnNegativeInput() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Printing element shouldn't be negative.");

        long printingNumber = -5;
        longPrinter.putLong(printingNumber);
    }

    @Test
    public void printZero() {

        long printingNumber = 0L;
        String expectedResult = "0";

        longPrinter.putLong(printingNumber);

        String actualResult = systemOutRule.getLog();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void printPositiveNumber() {
        long printingNumber = 15677L;
        String expectedResult = "15677";

        longPrinter.putLong(printingNumber);

        String actualResult = systemOutRule.getLog();
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
