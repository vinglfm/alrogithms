package com.algorithms;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class SortedCollectionDuplicateFinder {

    public static final String NULL_ARRAY_MESSAGE = "input array shouldn't be null.";

    public <T> Collection<T> getDuplicates(T[] elements) {
        if (elements == null) {
            throw new IllegalArgumentException(NULL_ARRAY_MESSAGE);
        }

        Set<T> duplicates = new LinkedHashSet<T>();
        for (int i = 1; i < elements.length; ++i) {
            if (elements[i].equals(elements[i - 1])) {
                duplicates.add(elements[i]);
            }
        }

        return duplicates;
    }
}
