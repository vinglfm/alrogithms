package com.algorithms;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LexicalAnalyzerTest {

    private LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwsIllegalArgumentExceptionForNullExpression() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Expression can't be null or empty.");

        lexicalAnalyzer.evaluate(null);
    }

    @Test
    public void evaluateSingleNumberExpression() {
        int expectedResult = 10;

        int actualResult = lexicalAnalyzer.evaluate("10");

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void evaluateNegativeSingleNumberExpression() {
        int expectedResult = -10;

        int actualResult = lexicalAnalyzer.evaluate("-10");

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void evaluateAdditionExpression() {
        String expression = "10+18";
        int expectedResult = 28;

        int actualResult = lexicalAnalyzer.evaluate(expression);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void evaluateSubstractionExpression() {
        String expression = "10-18";
        int expectedResult = -8;

        int actualResult = lexicalAnalyzer.evaluate(expression);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void evaluateMultiplicationExpression() {
        String expression = "10*18";
        int expectedResult = 180;

        int actualResult = lexicalAnalyzer.evaluate(expression);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void evaluateDivisionExpression() {
        String expression = "18/15";
        int expectedResult = 1;

        int actualResult = lexicalAnalyzer.evaluate(expression);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void evaluateExpressionWithNegativeNumbers() {
        String expression = "25+(-18)";
        int expectedResult = 7;

        int actualResult = lexicalAnalyzer.evaluate(expression);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void evaluateExpressionWithNotNumberAndOperation() {
        String expression = "-10a-18";

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Expression has to contain only digits or operations.");

        lexicalAnalyzer.evaluate(expression);
    }

    @Test
    public void evaluateExpressionWithBrackets() {
        String expression = "-5+6*(10+3*7)";

        int actualResult = lexicalAnalyzer.evaluate(expression);

        int expectedResult = 181;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void evaluateExpressionWithMultiplyBrackets() {
        String expression = "(-5+(6*(10+3*7)-1))";

        int actualResult = lexicalAnalyzer.evaluate(expression);

        int expectedResult = 180;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void evaluateExpressionWithWrongBracketsNumber() {
        String expression = "(-5+(6*(10+3*7))";

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Expression has to contain valid brackets.");


        lexicalAnalyzer.evaluate(expression);
    }

    @Test
    public void evaluateExpressionWithWrongBracketsDirection() {
        String expression = ")-5+(6*(10+3*7))";

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Expression has to contain valid brackets.");


        lexicalAnalyzer.evaluate(expression);
    }

    @Test
    public void evaluateExpressionWithTwoBracketsMultiplication() {
        String expression = "(2+(10-5)*(6*(3+7)))";

        int actualResult = lexicalAnalyzer.evaluate(expression);

        int expectedResult = 302;
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
