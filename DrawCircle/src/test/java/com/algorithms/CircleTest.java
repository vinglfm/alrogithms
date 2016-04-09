package com.algorithms;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class CircleTest {

    private Circle circle = new Circle();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Rule
    public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void throwIllegalArgumentExceptionWhenRadiusIsNegative() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Radius should be more then 0.");

        circle.draw(10, 10, -25);
    }

    @Test
    public void drawCircleForCorrectInput() {
        circle.draw(10, 10, 2);
        String actualCircle = systemOutRule.getLog();
        String expectedCircle =
                "          x  \r\n" +
                "         xxx \r\n" +
                "        xxxxx\r\n" +
                "         xxx \r\n" +
                "          x  \r\n";

        assertThat(actualCircle).isEqualTo(expectedCircle);
    }

}
