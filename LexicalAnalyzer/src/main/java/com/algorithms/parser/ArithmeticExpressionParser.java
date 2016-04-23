package com.algorithms.parser;

import com.algorithms.Operation;
import com.algorithms.validation.PredicateValidator;

import java.util.ArrayDeque;
import java.util.Deque;

import static com.algorithms.Operation.*;
import static com.algorithms.Operation.CLOSED_BRACKET;
import static com.algorithms.Operation.OPEN_BRACKET;
import static java.lang.Character.isDigit;
import static java.lang.Integer.valueOf;

public class ArithmeticExpressionParser {

    private PredicateValidator validator = new PredicateValidator();

    public Holder parse(String expression) {

        validator.validate(data -> data == null || data.isEmpty(),
                expression,
                () -> {
                    throw new IllegalArgumentException("Expression can't be null or empty.");
                });

        Deque<Integer> numbers = new ArrayDeque<>();
        Deque<Operation> operations = new ArrayDeque<>();

        StringBuilder currentNumber = new StringBuilder();
        int bracketCounter = 0;
        for (int i = 0; i < expression.length(); ++i) {
            char elem = expression.charAt(i);
            if (isDigit(elem) || isUnaryMinus(operations, currentNumber, i, elem)) {
                currentNumber.append(elem);
            } else if (isOperation(elem)) {
                currentNumber = processNumber(numbers, currentNumber);

                Operation operation = getOperationByCode(elem);

                bracketCounter = countBrackets(bracketCounter, operation);

                processOperations(operations, operation);
            } else {
                throw new IllegalArgumentException("Expression has to contain only digits or operations.");
            }
        }

        validateBrackets(bracketCounter);

        postProcessNumber(numbers, currentNumber);

        return new Holder(numbers, operations);
    }

    private StringBuilder processNumber(Deque<Integer> numbers, StringBuilder currentNumber) {
        if (containNumber(currentNumber)) {
            numbers.add(valueOf(currentNumber.toString()));
            currentNumber = new StringBuilder();
        }
        return currentNumber;
    }

    private void postProcessNumber(Deque<Integer> numbers, StringBuilder currentNumber) {
        if (containNumber(currentNumber)) {
            numbers.add(valueOf(currentNumber.toString()));
        }
    }

    private void validateBrackets(int bracketCounter) {
        if (bracketCounter != 0) {
            throw new IllegalArgumentException("Expression has to contain valid brackets.");
        }
    }

    private void processOperations(Deque<Operation> operations, Operation operation) {
        if (CLOSED_BRACKET.equals(operation) && OPEN_BRACKET.equals(operations.getLast())) {
            operations.removeLast();
        } else {
            operations.add(operation);
        }
    }

    private int countBrackets(int bracketCounter, Operation operation) {
        if (OPEN_BRACKET.equals(operation)) {
            bracketCounter++;
        } else if (CLOSED_BRACKET.equals(operation)) {
            bracketCounter--;
            if (bracketCounter < 0) {
                throw new IllegalArgumentException("Expression has to contain valid brackets.");
            }
        }
        return bracketCounter;
    }

    private boolean containNumber(StringBuilder currentNumber) {
        return currentNumber.length() != 0;
    }

    private boolean isUnaryMinus(Deque<Operation> operations, StringBuilder currentNumber, int index, char elem) {
        return elem == '-' && (index == 0 || (
                currentNumber.length() == 0 && !operations.isEmpty() && OPEN_BRACKET.equals(operations.getLast())));
    }
}
