package com.algorithms;

import validation.PredicateValidator;
import validation.Validator;

import static com.algorithms.Direction.*;

public class SpinTraverser {

    private Validator validator = new PredicateValidator();

    public <T> void traverseArray(T[][] elems) {
        validator.validate(data -> data == null, elems, () -> {
            throw new IllegalArgumentException("array shouldn't be null.");
        });

        int printedElements = elems.length * (elems.length == 0 ? 0 : elems[0].length);

        int begHorizontal = 0, begVertical = 0,
                endHorizontal = elems.length == 0 ? 0 : elems[0].length - 1,
                endVertical = elems.length - 1;

        int i = 0, j = 0;

        Direction currentDirection = RIGHT;

        while (printedElements != 0) {
            System.out.print(elems[i][j]);
            --printedElements;

            if (RIGHT.equals(currentDirection)) {
                if (j == endHorizontal) {
                    ++begVertical;
                    currentDirection = BOTTOM;
                    ++i;
                } else {
                    ++j;
                }
            } else if (BOTTOM.equals(currentDirection)) {
                if (i == endVertical) {
                    --endHorizontal;
                    currentDirection = LEFT;
                    --j;
                } else {
                    ++i;
                }
            } else if (LEFT.equals(currentDirection)) {
                if (j == begHorizontal) {
                    --endVertical;
                    currentDirection = TOP;
                    --i;
                } else {
                    --j;
                }
            } else {
                if (i == begVertical) {
                    ++begHorizontal;
                    currentDirection = RIGHT;
                    ++j;
                } else {
                    --i;
                }
            }
        }
    }
}
