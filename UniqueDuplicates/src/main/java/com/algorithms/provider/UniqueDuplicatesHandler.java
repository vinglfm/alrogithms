package com.algorithms.provider;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class UniqueDuplicatesHandler {

    public int[] handle(int[] elements) {
        Validate.notNull(elements, "Elements array shouldn't be null");

        Set<Integer> uniqueElements = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        Arrays.stream(elements).forEach(element -> {
            if (!uniqueElements.add(element)) {
                duplicates.add(element);
            }
        });
        return ArrayUtils.toPrimitive(duplicates.toArray(new Integer[duplicates.size()]));
    }
}
