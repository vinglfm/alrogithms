package com.algorithms;

import com.algorithms.validation.PredicateValidator;

import java.util.*;

import static com.algorithms.Operation.*;
import static java.lang.Character.isDigit;
import static java.lang.Integer.valueOf;

public class LexicalAnalyzer {

    private PredicateValidator validator = new PredicateValidator();

    public int evaluate(String expression) {

        validator.validate(data -> data == null || data.isEmpty(),
                expression,
                () -> {
                    throw new IllegalArgumentException("Expression can't be null or empty.");
                });

        Deque<Integer> numbers = new ArrayDeque<>();
        Deque<Operation> operations = new ArrayDeque<>();

        char[] chars = expression.toCharArray();

        StringBuilder currentNumber = new StringBuilder();
        int bracketCounter = 0;
        for (int i = 0; i < chars.length; ++i) {
            if (isDigit(chars[i]) ||
                    chars[i] == '-' && (i == 0 || (
                            currentNumber.length() == 0 && !operations.isEmpty() && OPEN_BRACKET.equals(operations.getLast())))) {
                currentNumber.append(chars[i]);
            } else if (isOperation(chars[i])) {
                if (currentNumber.length() != 0) {
                    numbers.add(valueOf(currentNumber.toString()));
                    currentNumber = new StringBuilder();
                }

                Operation operation = getOperationByCode(chars[i]);

                if (OPEN_BRACKET.equals(operation)) {
                    bracketCounter++;
                } else if (CLOSED_BRACKET.equals(operation)) {
                    bracketCounter--;
                    if (bracketCounter < 0) {
                        throw new IllegalArgumentException("Expression has to contain valid brackets.");
                    }
                }

                if (CLOSED_BRACKET.equals(operation) && OPEN_BRACKET.equals(operations.getLast())) {
                    operations.removeLast();
                } else {
                    operations.add(operation);
                }
            } else {
                throw new IllegalArgumentException("Expression has to contain only digits or operations.");
            }
        }

        if (bracketCounter != 0) {
            throw new IllegalArgumentException("Expression has to contain valid brackets.");
        }

        if (currentNumber.length() != 0) {
            numbers.add(valueOf(currentNumber.toString()));
        }

        Deque<Operation> processingOperations = new ArrayDeque<>();
        Deque<Integer> processingNumbers = new ArrayDeque<>();

        processingNumbers.push(numbers.removeFirst());

        if (!operations.isEmpty()) {
            processingOperations.add(operations.removeFirst());

            while (!processingOperations.isEmpty()) {
                Operation currentOperation = processingOperations.removeLast();
                if ((!operations.isEmpty() && (ADDITION.equals(currentOperation) ||
                        SUBTRACTION.equals(currentOperation) ||
                        OPEN_BRACKET.equals(operations.getFirst())))) {
                    processingOperations.add(currentOperation);
                    if (!numbers.isEmpty()) {
                        processingNumbers.push(numbers.removeFirst());
                    }
                } else if (OPEN_BRACKET.equals(currentOperation)) {
                    processingOperations.add(currentOperation);
                } else {
                    if (!numbers.isEmpty() && !CLOSED_BRACKET.equals(currentOperation)) {
                        processingNumbers.push(numbers.removeFirst());
                    }
                    currentOperation.evaluate(processingNumbers, processingOperations);
                }

                if (!operations.isEmpty()) {
                    processingOperations.add(operations.removeFirst());
                }
            }
        }

        if (processingNumbers.size() != 1) {
            throw new IllegalArgumentException("Expression can't be processed due to non arichmetic format.");
        }

        return processingNumbers.pop();
    }
}
