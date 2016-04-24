package com.algorithms;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class SpinTraversalTest {

    private SpinTraverser spinTraverser = new SpinTraverser();

    @Rule
    public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwsIllegalArgumentExceptionForNullArray() {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("array shouldn't be null.");

        spinTraverser.traverseArray(null);
    }

    @Test
    public void printsEmptyArray() {
        Integer[][] ints = {{}};
        spinTraverser.traverseArray(ints);

        assertThat(systemOutRule.getLog()).isEmpty();
    }

    @Test
    public void printsSingleElementArray() {
        Integer[][] ints = {{1}};
        spinTraverser.traverseArray(ints);

        assertThat(systemOutRule.getLog()).isEqualTo("1");
    }

    @Test
    public void printsDoubleRowColumnQuadraticArray() {
        Integer[][] ints = {{1, 2}, {3, 4}};
        spinTraverser.traverseArray(ints);

        assertThat(systemOutRule.getLog()).isEqualTo("1243");
    }

    @Test
    public void printsTripleRowColumnQuadraticArray() {
        Integer[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        spinTraverser.traverseArray(ints);

        assertThat(systemOutRule.getLog()).isEqualTo("123698745");
    }

    @Test
    public void printsNonQuadraticArray() {
        Integer[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        spinTraverser.traverseArray(ints);

        assertThat(systemOutRule.getLog()).isEqualTo("123691211107458");
    }
}
