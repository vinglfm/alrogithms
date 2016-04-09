package com.algorithms;

import static org.apache.commons.lang3.Validate.isTrue;

public class Circle {

    private static final String RADIUS_SHOULD_BE_POSITIVE = "Radius should be more then 0.";

    public void draw(int x, int y, int r) {
        isTrue(r > 0, RADIUS_SHOULD_BE_POSITIVE);

        int squareRadius = r * r;
        for (int i = y + r; i >= y - r; --i) {
            for (int j = 0; j <= x + r; ++j) {
                print(isInsideCircle(x, y, squareRadius, i, j) ? 'x' : ' ');
            }
            System.out.println();
        }
    }

    private boolean isInsideCircle(int x, int y, int squareRadius, int i, int j) {
        return (i - y) * (i - y) + (j - x) * (j - x) <= squareRadius;
    }

    private void print(char elem) {
        System.out.print(elem);
    }
}
