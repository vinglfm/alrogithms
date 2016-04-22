package com.algorithms;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

enum Operation {
    SUBTRACTION('-') {
        @Override
        public void evaluate(Deque<Integer> numbers, Deque<Operation> operations) {
            Integer first = numbers.pop();
            Integer second = numbers.pop();
            numbers.push(second - first);
        }
    },
    ADDITION('+') {
        @Override
        public void evaluate(Deque<Integer> numbers, Deque<Operation> operations) {
            Integer first = numbers.pop();
            Integer second = numbers.pop();
            numbers.push(first + second);
        }
    },
    MULTIPLY('*') {
        @Override
        public void evaluate(Deque<Integer> numbers, Deque<Operation> operations) {
            Integer first = numbers.pop();
            Integer second = numbers.pop();
            numbers.push(first * second);
        }
    },
    DIVISION('/') {
        @Override
        public void evaluate(Deque<Integer> numbers, Deque<Operation> operations) {
            Integer first = numbers.pop();
            Integer second = numbers.pop();
            numbers.push(second / first);
        }
    },
    OPEN_BRACKET('(') {
        @Override
        public void evaluate(Deque<Integer> numbers, Deque<Operation> operations) {

        }
    },
    CLOSED_BRACKET(')') {
        @Override
        public void evaluate(Deque<Integer> numbers, Deque<Operation> operations) {
            Operation operation = operations.removeLast();
            while (!operation.equals(OPEN_BRACKET)) {
                operation.evaluate(numbers, operations);
                operation = operations.removeLast();
            }
            if (!operations.isEmpty()) {
                operation = operations.removeLast();
                if (MULTIPLY.equals(operation) ||
                        DIVISION.equals(operation)) {
                    operation.evaluate(numbers, operations);
                } else {
                    operations.add(operation);
                }
            }
        }
    };

    private static final Map<Character, Operation> codeToOperation = new HashMap<>();

    static {
        for (Operation operation : Operation.values()) {
            codeToOperation.put(operation.code, operation);
        }
    }

    private final char code;

    Operation(char code) {
        this.code = code;
    }

    public static Operation getOperationByCode(char code) {
        return codeToOperation.get(code);
    }

    public static boolean isOperation(char code) {
        return codeToOperation.containsKey(code);
    }

    public char getCode() {
        return code;
    }

    public abstract void evaluate(Deque<Integer> numbers, Deque<Operation> operations);
}
