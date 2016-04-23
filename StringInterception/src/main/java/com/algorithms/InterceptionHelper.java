package com.algorithms;

import com.algorithms.validation.PredicateValidator;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class InterceptionHelper {

    private static final String ARGUMENT_NULL_MESSAGE = "Input arguments shouldn't be null.";
    private PredicateValidator predicateValidator = new PredicateValidator();
    private Predicate<String> nullPredicate = data -> data == null;

    public Holder removeInterceptedChars(String first, String second) {
        validate(first);
        validate(second);

        Set<Character> firstElements = mapToSet(first);

        Set<Character> interception = getInterceptedChars(second, firstElements);

        StringBuilder firstIntercepted = clearInterceptedChars(first, interception);
        StringBuilder secondIntercepted = clearInterceptedChars(second, interception);

        return new Holder(firstIntercepted.toString(), secondIntercepted.toString());
    }

    private Set<Character> getInterceptedChars(String second, Set<Character> firstElements) {
        Set<Character> interception = new HashSet<>();
        for (int i = 0; i < second.length(); ++i) {
            char current = second.charAt(i);
            if (firstElements.contains(current)) {
                interception.add(current);
            }
        }
        return interception;
    }

    private StringBuilder clearInterceptedChars(String data, Set<Character> interception) {
        StringBuilder firstIntercepted = new StringBuilder();
        for (int i = 0; i < data.length(); ++i) {
            char current = data.charAt(i);
            if (!interception.contains(current)) {
                firstIntercepted.append(current);
            }
        }
        return firstIntercepted;
    }

    private Set<Character> mapToSet(String first) {
        Set<Character> firstElements = new HashSet<>();
        for (int i = 0; i < first.length(); ++i) {
            firstElements.add(first.charAt(i));
        }
        return firstElements;
    }

    private void validate(String data) {
        predicateValidator.validate(nullPredicate, data, ARGUMENT_NULL_MESSAGE);
    }

    public static final class Holder {
        private String first;
        private String second;

        public Holder(String first, String second) {
            this.first = first;
            this.second = second;
        }

        public String getFirst() {
            return first;
        }

        public String getSecond() {
            return second;
        }
    }
}
