package com.algorithms;

import com.algorithms.generator.NumberGenerator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class ArrayPermutationTest {

    private ArrayPermutation arrayPermutation;
    private NumberGenerator numberGenerator;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void before() {
        numberGenerator = mock(NumberGenerator.class);
        arrayPermutation = new ArrayPermutation(numberGenerator);
    }

    @Test
    public void throwIllegalArgumentExceptionForNullArray() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("input array shouldn't be null.");

        arrayPermutation.permute(null);
    }

    @Test
    public void emptyArrayPermutation() {
        int[] ints = {};
        int[] actualResult = arrayPermutation.permute(ints);

        assertThat(actualResult).isEmpty();
        verifyNoMoreInteractions(numberGenerator);
    }

    @Test
    public void generalArrayPermutation() {
        int[] ints = {1, 2, 3, 4, 5, 6};

        when(numberGenerator.generate(anyInt(), anyInt())).thenReturn(3, 2, 2, 3, 5, 5);

        int[] actualResult = arrayPermutation.permute(ints);

        assertThat(actualResult).containsExactly(4, 3, 2, 1, 6, 5);
        verify(numberGenerator, times(6)).generate(anyInt(), anyInt());
    }
}
