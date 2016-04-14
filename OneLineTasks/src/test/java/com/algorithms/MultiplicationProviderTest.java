package com.algorithms;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplicationProviderTest {

    private MultiplicationProvider provider = new MultiplicationProvider();

    @Test
    public void multiplyNegativeNumberBySeven() {
        int actualResult = provider.multiplyBySeven(-15);

        assertThat(actualResult).isEqualTo(-105);
    }

    @Test
    public void multiplyPositiveNumberBySeven() {
        int actualResult = provider.multiplyBySeven(18);

        assertThat(actualResult).isEqualTo(126);
    }

    @Test
    public void multiplyZeroBySeven() {
        int actualResult = provider.multiplyBySeven(0);

        assertThat(actualResult).isEqualTo(0);
    }
}