package com.algorithms.provider;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.apache.commons.lang3.ArrayUtils.toPrimitive;
import static org.apache.commons.lang3.Validate.notNull;

public final class UniqueDuplicatesHandler {

    private static final String INPUT_NULL_ARRAY_MESSAGE = "Elements array shouldn't be null";

    public int[] handle(int[] elements) {
        notNull(elements, INPUT_NULL_ARRAY_MESSAGE);

        Set<Integer> uniqueElements = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        Arrays.stream(elements).forEach(element -> {
            if (!uniqueElements.add(element)) {
                duplicates.add(element);
            }
        });
        return toPrimitive(duplicates.toArray(new Integer[duplicates.size()]));
    }
}
