package com.algorithms;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PowerOfTwoResolverTest {

    private PowerOfTwoResolver resolver = new PowerOfTwoResolver();

    @Test
    public void falseForNegativeNumber() {
        boolean actualResult = resolver.test(-10);
        assertThat(actualResult).isFalse();
    }

    @Test
    public void falseForZero() {
        boolean actualResult = resolver.test(0);
        assertThat(actualResult).isFalse();
    }

    @Test
    public void falseForNotPowerOfTwo() {
        boolean actualResult = resolver.test(1);
        assertThat(actualResult).isFalse();
    }

    @Test
    public void trueForPowerOfTwo() {
        boolean actualResult = resolver.test(16);
        assertThat(actualResult).isTrue();
    }
}
