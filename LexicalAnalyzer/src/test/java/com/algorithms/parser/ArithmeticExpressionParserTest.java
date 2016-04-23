package com.algorithms.parser;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.algorithms.Operation.ADDITION;
import static org.assertj.core.api.Assertions.assertThat;

public class ArithmeticExpressionParserTest {

    private ArithmeticExpressionParser parser = new ArithmeticExpressionParser();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwsIllegalArgumentExceptionForNullExpression() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Expression can't be null or empty.");

        parser.parse(null);
    }

    @Test
    public void parseSingleNumberExpression() {

        String expression = "10";
        Holder actualResult = parser.parse(expression);

        assertThat(actualResult.getNumbers().size()).isEqualTo(1);
        assertThat(actualResult.getNumbers().poll()).isEqualTo(10);
    }

    @Test
    public void parseSingleNegativeNumberExpression() {

        String expression = "-10";
        Holder actualResult = parser.parse(expression);

        assertThat(actualResult.getNumbers().size()).isEqualTo(1);
        assertThat(actualResult.getNumbers().poll()).isEqualTo(-10);
    }

    @Test
    public void parseSingleOperationNumberExpression() {

        String expression = "-10+5";
        Holder actualResult = parser.parse(expression);

        assertThat(actualResult.getNumbers().size()).isEqualTo(2);
        assertThat(actualResult.getNumbers().pop()).isEqualTo(-10);
        assertThat(actualResult.getNumbers().pop()).isEqualTo(5);
        assertThat(actualResult.getOperations().pop()).isEqualTo(ADDITION);
    }

    @Test
    public void parseNegativeNumberInBracketsExpression() {

        String expression = "15+(-5)";
        Holder actualResult = parser.parse(expression);

        assertThat(actualResult.getNumbers().size()).isEqualTo(2);
        assertThat(actualResult.getNumbers().pop()).isEqualTo(15);
        assertThat(actualResult.getNumbers().pop()).isEqualTo(-5);
        assertThat(actualResult.getOperations().size()).isEqualTo(1);
        assertThat(actualResult.getOperations().pop()).isEqualTo(ADDITION);
    }
}