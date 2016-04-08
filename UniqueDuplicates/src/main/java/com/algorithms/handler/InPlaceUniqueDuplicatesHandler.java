package com.algorithms.handler;

import java.util.Arrays;

import static org.apache.commons.lang3.Validate.notNull;

public class InPlaceUniqueDuplicatesHandler implements UniqueDuplicatesHandler {

    private static final String INPUT_NULL_ARRAY_MESSAGE = "Elements array shouldn't be null";
    private static final int DUPLICATE = 0;

    @Override
    public int[] handle(int[] elements) {
        notNull(elements, INPUT_NULL_ARRAY_MESSAGE);

        for (int i = 0; i < elements.length; ) {
            if(isDuplicate(elements[i]) || isDuplicate(elements[elements[i] - 1])) {
                i++;
            } else {
                if (!isInPosition(elements[i], i + 1)) {
                    if (!isInPosition(elements[elements[i] - 1], elements[i])) {
                        swap(elements, i, elements[i] - 1);
                    } else {
                        markDuplicate(elements, elements[i] - 1);
                        i++;
                    }
                } else {
                    i++;
                }
            }
        }

        return prepareDuplicates(elements);
    }

    private boolean isDuplicate(int element) {
        return element == DUPLICATE;
    }

    private boolean isInPosition(int element, int position) {
        return element == position;
    }

    private void markDuplicate(int[] elements, int position) {
        elements[position] = DUPLICATE;
    }

    private void swap(int[] elements, int from, int to) {
        int temp = elements[from];
        elements[from] = elements[to];
        elements[to] = temp;
    }

    private int[] prepareDuplicates(int[] elements) {
        int dupsEnd = 0;
        for (int i = 0; i < elements.length; i++) {
            if (isDuplicate(elements[i])) {
                elements[dupsEnd++] = i + 1;
            }
        }

        return Arrays.copyOf(elements, dupsEnd);
    }
}
