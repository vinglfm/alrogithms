package com.algorithms;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InterceptionHelperTest {

    private InterceptionHelper interceptionHelper = new InterceptionHelper();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void removeInterceptedCharsThrowsIllegalArgumentExceptionForNullFirstString() {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input arguments shouldn't be null.");

        String first = null;
        String second = "second";
        interceptionHelper.removeInterceptedChars(first, second);
    }

    @Test
    public void removeInterceptedCharsThrowsIllegalArgumentExceptionForNullSecondString() {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input arguments shouldn't be null.");

        String first = "first";
        String second = null;
        interceptionHelper.removeInterceptedChars(first, second);
    }

    @Test
    public void removeInterceptedCharsWhenEmptyFirstString() {

        String first = "";
        String second = "second";
        InterceptionHelper.Holder holder = interceptionHelper.removeInterceptedChars(first, second);

        assertThat(holder.getFirst()).isEqualTo(first);
        assertThat(holder.getSecond()).isEqualTo(second);
    }

    @Test
    public void removeInterceptedCharsWhenEmptySecondString() {

        String first = "first";
        String second = "";
        InterceptionHelper.Holder holder = interceptionHelper.removeInterceptedChars(first, second);

        assertThat(holder.getFirst()).isEqualTo(first);
        assertThat(holder.getSecond()).isEqualTo(second);
    }

    @Test
    public void removeInterceptedCharsSunnyDay() {

        String first = "first";
        String second = "second";
        String expectedFirst = "firt";
        String expectedSecond = "econd";
        InterceptionHelper.Holder holder = interceptionHelper.removeInterceptedChars(first, second);

        assertThat(holder.getFirst()).isEqualTo(expectedFirst);
        assertThat(holder.getSecond()).isEqualTo(expectedSecond);
    }
}
